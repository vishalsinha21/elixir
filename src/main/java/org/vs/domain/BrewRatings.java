package org.vs.domain;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BrewRatings {

    private BigInteger id;
    private BigInteger brewId;
    private BigInteger userid;
    private BigInteger rating;
    private String note;
    private BigDecimal alcohol;
    private BigInteger bitter;
    private BigInteger body;
    private BigInteger citrus;
    private BigInteger floral;
    private BigInteger herbal;
    private BigInteger hoppy;
    private DateTime createdOn;
    private DateTime updatedOn;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getBrewId() {
        return brewId;
    }

    public void setBrewId(BigInteger brewId) {
        this.brewId = brewId;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public BigInteger getRating() {
        return rating;
    }

    public void setRating(BigInteger rating) {
        this.rating = rating;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(BigDecimal alcohol) {
        this.alcohol = alcohol;
    }

    public BigInteger getBitter() {
        return bitter;
    }

    public void setBitter(BigInteger bitter) {
        this.bitter = bitter;
    }

    public BigInteger getBody() {
        return body;
    }

    public void setBody(BigInteger body) {
        this.body = body;
    }

    public BigInteger getCitrus() {
        return citrus;
    }

    public void setCitrus(BigInteger citrus) {
        this.citrus = citrus;
    }

    public BigInteger getFloral() {
        return floral;
    }

    public void setFloral(BigInteger floral) {
        this.floral = floral;
    }

    public BigInteger getHerbal() {
        return herbal;
    }

    public void setHerbal(BigInteger herbal) {
        this.herbal = herbal;
    }

    public BigInteger getHoppy() {
        return hoppy;
    }

    public void setHoppy(BigInteger hoppy) {
        this.hoppy = hoppy;
    }

    public DateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTime createdOn) {
        this.createdOn = createdOn;
    }

    public DateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(DateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
