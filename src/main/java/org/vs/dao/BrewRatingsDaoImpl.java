package org.vs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.vs.domain.Brew;
import org.vs.domain.BrewRatings;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class BrewRatingsDaoImpl {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    public BrewRatingsDaoImpl(@Qualifier("dataSource") DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void saveRating(BrewRatings brewRatings) {
        String columns = "brewid, userid, rating, note, alcohol, bitter, body, citrus, floral, herbal, hoppy, createdon, updatedon";
        String valuesNames = ":brewid, :userid, :rating, :note, :alcohol, :bitter, :body, :citrus, :floral, :herbal, :hoppy, :createdon, :updatedon";
        String sql = "INSERT INTO brewratings (" + columns + ") VALUES (" + valuesNames + ")";

        MapSqlParameterSource input = new MapSqlParameterSource();
        input.addValue("brewid", brewRatings.getBrewId().intValue());
        input.addValue("userid", brewRatings.getUserid().intValue());
        input.addValue("rating", brewRatings.getRating().intValue());
        input.addValue("note", brewRatings.getNote());
        input.addValue("alcohol", brewRatings.getAlcohol().doubleValue());
        input.addValue("bitter", brewRatings.getBitter().intValue());
        input.addValue("body", brewRatings.getBody().intValue());
        input.addValue("citrus", brewRatings.getCitrus().intValue());
        input.addValue("floral", brewRatings.getFloral().intValue());
        input.addValue("herbal", brewRatings.getHerbal().intValue());
        input.addValue("hoppy", brewRatings.getHoppy().intValue());
        input.addValue("createdon", brewRatings.getCreatedOn() != null ? brewRatings.getCreatedOn().toDate() : new Date());
        input.addValue("updatedon", brewRatings.getUpdatedOn() != null ? brewRatings.getUpdatedOn().toDate() : new Date());

        namedJdbcTemplate.update(sql, input);
    }

    public List<Map<String, Object>> getRatingByBrewId(BigInteger brewId) {
        String SQL = "SELECT * FROM brewratings where brewid = ?";
        return jdbcTemplate.queryForList(SQL, brewId.longValue());
    }

    public List<Map<String, Object>> getRatingByUserId(BigInteger userId) {
        String SQL = "SELECT * FROM brewratings where userid = ?";
        return jdbcTemplate.queryForList(SQL, userId.longValue());
    }

    public List<Map<String, Object>> getAllRatings() {
        String SQL = "SELECT * FROM brewratings";
        return jdbcTemplate.queryForList(SQL);
    }

    public List<Map<String, Object>> getBestBeers(int limit) {
        String SQL = "select id, brewname, brewtype, abv, style, rating from brew, \n" +
                "(select brewid, round(avg(rating),1) rating \n" +
                "from brewratings \n" +
                "group by brewid \n" +
                "order by rating desc) br \n" +
                "where brew.id = br.brewid \n" +
                "limit ?";
        return jdbcTemplate.queryForList(SQL, limit);
    }

    public List<Map<String, Object>> getMatchingBeers(String query, int limit) {
        query = query + "%";
        String SQL = "select * from brew where lower(brewname) like ? limit ?";
        return jdbcTemplate.queryForList(SQL, query, limit);
    }

    public List<Map<String, Object>> getRecentReviews(int limit) {
        String SQL = "select *\n" +
                "from brew, enduser,\n" +
                "(select * from brewratings\n" +
                "order by createdon desc\n" +
                "limit ?) ratings\n" +
                "where brew.id = ratings.brewid\n" +
                "and enduser.id = ratings.userid";
        return jdbcTemplate.queryForList(SQL, limit);
    }

}


