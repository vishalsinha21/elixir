package org.vs;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.vs.domain.BrewRatings;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

public class ObjectMother {

    public static String[] reviews = {"Pours from the tin. with a slight haze and a little head that soon thins. Not much on the nose, perhaps malt is to the fore and there is straw in the background. Feels thin in the mouth with a short finish and gentle hops. Nice but not one that inspires.",
            "From Carrefour. At Halloween lunch, shared with brothers-in-law. In shaker. Pretty good for a cheap supermarket white label. Better than others like Grimbergen. Not too much artificially sweet. Could have more body",
            "12 oz can. Hazy orange with finger white head, great retention and rings of lace. Citrusy sweet aroma. Taste follows with citrusy hops at the forefront and a touch of malt backbone to balance. Earthy tones in the dry finish with a little crisp peppery bite. Thin to medium mouthfeel but soft. Overall very solid hop forward IPA, could drink this regularly.",
            "Great beer. Very well balanced, especially for 9.1%. I waited to drink this one because I figured it wouldn't be as good as the Sensi 2015 that I had, and I think it may even be better. Great Job Sixpoint!",
            "The beer has a hazy yellow color. The aroma is reminiscent of the malt profile in kolsch beer. The taste is very similar to a kolsch but with added bitterness and hop taste that lingers on the palate.",
            "The beer has a hazy dark orange color. The aroma is grassy and vegetal. The taste is creamy, grassy, vegetal, bubblegum, fruity, and has a clean finish. Tastes a lot like the IPAs from Tree House. Very good stuff",
            "Very big oak presence. Brett is fairly tame but a lighter funk comes through along with a light bready sweetness. Peach in the finish brightens it up.",
            "Lots of fruit on the nose, like Starburst (or Opal Fruits and they should be called!). Hazy appearance and a thin head that soon disappears. Taste is fruity too and with some hops coming through. A quick sharp finish with lingering fruit on the tongue.",
            "I really liked this one. I prefer 30th over Expedition fresh by quite a bit, so I'm excited to see how this will taste with a little age on it. Such a great mouthfeel as it warms near room temp. Sweet, roast, chocolate, with just a little hop present. Only thing to make this better would be a year in the barrel. Happy 30th, Bells!",
            "Nice & surprisingly well balanced but not as hoppy as I was expecting. Nice pine bitterness & tropical fruits (mango & citrus mainly) before some sweet malts, caramel & sugars appear. Not the best DIPA out there but a good one & one I wouldn't mind having again if I got the chance.",
            "Pours dark black with a small tan head. Medium carbonation. Smell - coffee with roasted malts. Taste - roasted malts to the fore but not overpowering, strong prolonged bitter finish. Very nice style.",
            "Pours amber with a white foamy head. Medium carbonation. Taste - fruit, melon/passion fruit with a crisp bitter finish. Very nice version of an American IPA.",
            "Clear, golden color with white head. Aroma has some bready malts but also an astringent note. Taste starts malty and slightly sweet and gets more balanced in the finish. Body is medium and the carbonation is quite low for the style. Mediocre.",
            "Tasty milk stout. Very smooth. Sweet start to beer. Not too strong of a stout flavor. Exactly what I want in this style of beer. Very good. Would buy again.",
            "Solid Peach Gose with subtle ginger. Nice peach on the nose...some sweetness but not enough to overpower. The ginger is very subtle and hard to pick up. Only negative would be the fact that it lacks a little body but that doesn't interfere with the excellent quality of this beer. Nice job",
            "I just tasted this after eating nacho chips and guacomole so I might not be getting the true flavour here. However, it has a tuition and piney smell and flavour with a slightly sharp sickly aftertaste (that might have been the nachos).",
    };

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
        DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        DateTime dateTime = format.parseDateTime("01/01/2013 10:10:00");
        dateTime = dateTime.plusDays(random.nextInt(365 * 2 + 300)).plusMinutes(random.nextInt(24 * 60));

        brewRating.setUserid(BigInteger.valueOf(random.nextInt(100)));
        brewRating.setBrewId(BigInteger.valueOf(random.nextInt(100)));
        brewRating.setRating(BigInteger.valueOf(4 + random.nextInt(6 + 1)));
        brewRating.setNote(reviews[random.nextInt(reviews.length)]);
        brewRating.setAlcohol(new BigDecimal(alcohol[random.nextInt(8)]).setScale(1, RoundingMode.CEILING));
        brewRating.setBitter(BigInteger.valueOf(random.nextInt(5 + 1)));
        brewRating.setBody(BigInteger.valueOf(random.nextInt(5 + 1)));
        brewRating.setCitrus(BigInteger.valueOf(random.nextInt(5 + 1)));
        brewRating.setFloral(BigInteger.valueOf(random.nextInt(5 + 1)));
        brewRating.setHerbal(BigInteger.valueOf(random.nextInt(5 + 1)));
        brewRating.setHoppy(BigInteger.valueOf(random.nextInt(5 + 1)));

        brewRating.setCreatedOn(dateTime);
        brewRating.setUpdatedOn(dateTime);

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

        brewRating.setUserid(userId);
        brewRating.setBrewId(brewId);
        brewRating.setRating(rating);
        brewRating.setNote(note);
        brewRating.setAlcohol(alcohol);
        brewRating.setBitter(bitter);
        brewRating.setBody(body);
        brewRating.setCitrus(citrus);
        brewRating.setFloral(floral);
        brewRating.setHerbal(herbal);
        brewRating.setHoppy(hoppy);

        return brewRating;
    }

}
