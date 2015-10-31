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
        input.addValue("createdon", new Date());
        input.addValue("updatedon", new Date());

        namedJdbcTemplate.update(sql, input);
    }

    public List<BrewRatings> getRatingByBrewId(BigInteger brewId) {
        String SQL = "SELECT * FROM brewratings where brewid = ?";
        return jdbcTemplate.query(SQL, new BrewRatingsRowMapper(), brewId.longValue());
    }

    public List<BrewRatings> getRatingByUserId(BigInteger userId) {
        String SQL = "SELECT * FROM brewratings where userid = ?";
        return jdbcTemplate.query(SQL, new BrewRatingsRowMapper(), userId.longValue());
    }

    public List<BrewRatings> getAllRatings() {
        String SQL = "SELECT * FROM brewratings";
        return jdbcTemplate.query(SQL, new BrewRatingsRowMapper());
    }

    public List<Brew> getBestBeers(int limit) {
        String SQL = "select id, brewname, brewtype, abv, style, rating from brew, \n" +
                "(select brewid, round(avg(rating),1) rating \n" +
                "from brewratings \n" +
                "group by brewid \n" +
                "order by rating desc) br \n" +
                "where brew.id = br.brewid \n" +
                "limit ?";
        return jdbcTemplate.query(SQL, new BrewRowMapper(), limit);
    }

    public List<Brew> getMatchingBeers(String query, int limit) {
        query = query + "%";
        String SQL = "select * from brew where lower(brewname) like ? limit ?";
        return jdbcTemplate.query(SQL, new BrewMapper(), query, limit);
    }
    
    private class BrewRatingsRowMapper implements RowMapper<BrewRatings> {
        @Override
        public BrewRatings mapRow(ResultSet rs, int rowNum) throws SQLException {
            BrewRatings brewRatings = new BrewRatings();
            brewRatings.setId(BigInteger.valueOf(rs.getLong("id")));
            brewRatings.setBrewId(BigInteger.valueOf(rs.getLong("brewid")));
            brewRatings.setUserid(BigInteger.valueOf(rs.getLong("userid")));
            brewRatings.setRating(BigInteger.valueOf(rs.getLong("rating")));
            brewRatings.setNote(rs.getString("note"));
            brewRatings.setAlcohol(BigDecimal.valueOf(rs.getDouble("alcohol")));
            brewRatings.setBitter(BigInteger.valueOf(rs.getLong("bitter")));
            brewRatings.setBody(BigInteger.valueOf(rs.getLong("body")));
            brewRatings.setCitrus(BigInteger.valueOf(rs.getLong("citrus")));
            brewRatings.setFloral(BigInteger.valueOf(rs.getLong("floral")));
            brewRatings.setHerbal(BigInteger.valueOf(rs.getLong("herbal")));
            brewRatings.setHoppy(BigInteger.valueOf(rs.getLong("hoppy")));
            return brewRatings;
        }
    }

    private class BrewRowMapper implements RowMapper<Brew> {
        @Override
        public Brew mapRow(ResultSet rs, int rowNum) throws SQLException {
            Brew brew = new Brew();
            brew.setId(BigInteger.valueOf(rs.getLong("id")));
            brew.setBrewName(rs.getString("brewname"));
            brew.setBrewType(rs.getString("brewtype"));
            brew.setAbv(BigDecimal.valueOf(rs.getDouble("abv")));
            brew.setStyle(rs.getString("style"));
            brew.setRating(BigDecimal.valueOf(rs.getDouble("rating")));
            return brew;
        }
    }

    private class BrewMapper implements RowMapper<Brew> {
        @Override
        public Brew mapRow(ResultSet rs, int rowNum) throws SQLException {
            Brew brew = new Brew();
            brew.setId(BigInteger.valueOf(rs.getLong("id")));
            brew.setBrewName(rs.getString("brewname"));
            brew.setBrewType(rs.getString("brewtype"));
            brew.setAbv(BigDecimal.valueOf(rs.getDouble("abv")));
            brew.setStyle(rs.getString("style"));
            return brew;
        }
    }
}


