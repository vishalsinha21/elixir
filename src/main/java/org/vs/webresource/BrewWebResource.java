package org.vs.webresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vs.domain.Brew;
import org.vs.service.BrewService;

import java.util.List;
import java.util.Map;

@RestController
public class BrewWebResource {

    BrewService brewService;

    @Autowired
    public BrewWebResource(BrewService brewService) {
        this.brewService = brewService;
    }

    @RequestMapping(value = "/brew/best", method = RequestMethod.GET)
    public ResponseEntity<List<Brew>> getBestBeers() {
        List<Brew> bestBeers = brewService.getBestBeers();
        return new ResponseEntity<List<Brew>>(bestBeers, HttpStatus.OK);
    }

    @RequestMapping(value = "/brew/match/{query}", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, Object>>> getMatchingBeers(@PathVariable String query) {
        List<Map<String, Object>> bestBeers = brewService.getMatchingBeers(query);
        return new ResponseEntity<List<Map<String, Object>>>(bestBeers, HttpStatus.OK);
    }

    @RequestMapping(value = "/brew/recent", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, Object>>> getRecentReviews() {
        List<Map<String, Object>> recentReviews = brewService.getRecentReviews();
        return new ResponseEntity<List<Map<String, Object>>>(recentReviews, HttpStatus.OK);
    }

}
