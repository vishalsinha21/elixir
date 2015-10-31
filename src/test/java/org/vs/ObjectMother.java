package org.vs;

import org.vs.domain.BrewRatings;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

public class ObjectMother {

    public static BrewRatings getBrewRating() {
        BrewRatings brewRating = new BrewRatings();

        brewRating.setUserid(BigInteger.ONE);
        brewRating.setBrewId(BigInteger.ONE);
        brewRating.setRating(BigInteger.ONE);
        brewRating.setNote("note");
        brewRating.setAlcohol(BigDecimal.valueOf(4.5));
        brewRating.setBitter(BigInteger.ONE);
        brewRating.setBody(BigInteger.ONE);
        brewRating.setCitrus(BigInteger.ONE);
        brewRating.setFloral(BigInteger.ONE);
        brewRating.setHerbal(BigInteger.ONE);
        brewRating.setHoppy(BigInteger.ONE);

        return brewRating;
    }

    public static BrewRatings getRandomBrewRating() {
        BrewRatings brewRating = new BrewRatings();
        double[] alcohol = {4.5, 5.0, 5.5, 6.0, 6.5, 7.0, 7.5, 8.0};
        
        Random random = new Random();
        brewRating.setUserid(BigInteger.valueOf(random.nextInt(100)));
        brewRating.setBrewId(BigInteger.valueOf(random.nextInt(100)));
        brewRating.setRating(BigInteger.valueOf(4 + random.nextInt(6 + 1)));
        brewRating.setNote("note");
        brewRating.setAlcohol(new BigDecimal(alcohol[random.nextInt(8)]).setScale(1, RoundingMode.CEILING));
        brewRating.setBitter(BigInteger.valueOf(random.nextInt(5+1)));
        brewRating.setBody(BigInteger.valueOf(random.nextInt(5+1)));
        brewRating.setCitrus(BigInteger.valueOf(random.nextInt(5+1)));
        brewRating.setFloral(BigInteger.valueOf(random.nextInt(5+1)));
        brewRating.setHerbal(BigInteger.valueOf(random.nextInt(5+1)));
        brewRating.setHoppy(BigInteger.valueOf(random.nextInt(5+1)));

        return brewRating;
    }

    public static BrewRatings getBrewRating(BigInteger userId,
                                            BigInteger brewId,
                                            BigInteger rating,
                                            String note,
                                            BigDecimal alcohol,
                                            BigInteger bitter,
                                            BigInteger body,
                                            BigInteger citrus,
                                            BigInteger floral,
                                            BigInteger herbal,
                                            BigInteger hoppy) {
        BrewRatings brewRating = new BrewRatings();

        brewRating.setUserid(BigInteger.ONE);
        brewRating.setBrewId(BigInteger.ONE);
        brewRating.setRating(BigInteger.ONE);
        brewRating.setNote("note");
        brewRating.setAlcohol(BigDecimal.valueOf(4.5));
        brewRating.setBitter(BigInteger.ONE);
        brewRating.setBody(BigInteger.ONE);
        brewRating.setCitrus(BigInteger.ONE);
        brewRating.setFloral(BigInteger.ONE);
        brewRating.setHerbal(BigInteger.ONE);
        brewRating.setHoppy(BigInteger.ONE);

        return brewRating;
    }
    
}
