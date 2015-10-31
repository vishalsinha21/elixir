package org.vs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vs.dao.BrewRatingsDaoImpl;
import org.vs.domain.Brew;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BrewService {

    private final BrewRatingsDaoImpl ratingsDao;

    @Autowired
    public BrewService(BrewRatingsDaoImpl ratingsDao) {
        this.ratingsDao = ratingsDao;
    }

    public List<Brew> getBestBeers() {
        return ratingsDao.getBestBeers(5);
    }

    public List<Map<String, Object>> getMatchingBeers(String query) {
        if (query.trim().length() < 3) {
            return new ArrayList<Map<String, Object>>();
        }

        return ratingsDao.getMatchingBeers(query, 10);
    }

    public List<Map<String, Object>> getRecentReviews() {
        return ratingsDao.getRecentReviews(5);
    }

}
