package org.vs.dao;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.vs.ObjectMother;
import org.vs.domain.Brew;
import org.vs.domain.BrewRatings;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import static java.math.BigInteger.ONE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/spring/applicationContext.xml"})
@Transactional
//@TransactionConfiguration(defaultRollback = true)
public class BrewRatingsDaoImplTest extends TestCase {

    @Autowired
    private BrewRatingsDaoImpl brewRatingsDao;

    @Test
    public void should_create_and_get_all_ratings() {
        BrewRatings brewRating = ObjectMother.getBrewRating();
        brewRatingsDao.saveRating(brewRating);
        brewRatingsDao.saveRating(brewRating);
        brewRatingsDao.saveRating(brewRating);

        List<BrewRatings> allRatings = brewRatingsDao.getAllRatings();

        assertEquals(true, allRatings.size() >= 3);
    }

    @Test
    public void should_get_all_ratings_by_brew_id() {
        BrewRatings brewRating = ObjectMother.getBrewRating(ONE, new BigInteger("9999999"), ONE, "note", new BigDecimal(4.5), ONE, ONE, ONE, ONE, ONE, ONE);
        brewRatingsDao.saveRating(brewRating);

        List<BrewRatings> result = brewRatingsDao.getRatingByBrewId(brewRating.getBrewId());

        assertEquals(brewRating.getNote(), result.get(0).getNote());
    }

    @Test
    public void should_get_all_ratings_by_user_id() {
        BrewRatings brewRating = ObjectMother.getBrewRating(new BigInteger("7777777"), ONE, ONE, "great note", new BigDecimal(4.5), ONE, ONE, ONE, ONE, ONE, ONE);
        brewRatingsDao.saveRating(brewRating);

        List<BrewRatings> result = brewRatingsDao.getRatingByUserId(brewRating.getUserid());

        assertEquals(brewRating.getNote(), result.get(0).getNote());
    }

    @Ignore
    public void create_ratings_data() {

        for (int i = 0; i < 10000; i++) {
            BrewRatings brewRating = ObjectMother.getRandomBrewRating();
            brewRatingsDao.saveRating(brewRating);
        }

    }


}