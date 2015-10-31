package org.vs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vs.dao.BrewRatingsDaoImpl;
import org.vs.domain.Brew;

import java.util.ArrayList;
import java.util.List;

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

    public List<Brew> getMatchingBeers(String query) {
        if(query.trim().length() < 3) {
            return new ArrayList<Brew>();
        }
        
        return ratingsDao.getMatchingBeers(query, 10);
    }

}
