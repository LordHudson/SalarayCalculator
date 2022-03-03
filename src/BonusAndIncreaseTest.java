import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusAndIncreaseTest {

    @Test
    void checkThatInvalidSalaryFails() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(100000.00, 4.8);
        assertEquals(-1, calculator1.increaseCalculator(4.85), 1);
    }

    @Test
    void checkThatNegativeRatingFails() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(150000.00, -1);
        assertEquals(-1, calculator1.increaseCalculator(7.5), 1);
    }

    @Test
    void checkThatRatingGreaterThanFiveFails() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(176987.33, 5.01);
        assertEquals(-1, calculator1.increaseCalculator(3.75),1);
    }

    @Test
    void checkThatNegativePercentageFails() {
        BonusAndIncrease calculator = new BonusAndIncrease(135620.32, 2.5);
        assertEquals(-1, calculator.increaseCalculator(-1), 1);
    }

    @Test
    void checkThatPercentageOFLessThan4Point4ForRatingOf3InclusiveAnd3Point5InclusiveFails() {
        BonusAndIncrease calculator = new BonusAndIncrease(135620.32, 3.1);
        assertEquals(-1, calculator.increaseCalculator(4.3), 1);
    }

    @Test
    void checkThatPercentageOFLessThan4Point5ForRatingOf3Point6InclusiveAnd3Point9InclusiveFails() {
        BonusAndIncrease calculator = new BonusAndIncrease(135620.32, 3.7);
        assertEquals(-1, calculator.increaseCalculator(4.0), 1);
    }

    @Test
    void checkThatPercentageOFLessThan4Point8ForRatingOf4InclusiveAnd4Point9InclusiveFails() {
        BonusAndIncrease calculator = new BonusAndIncrease(600000.00, 4.7);
        assertEquals(-1, calculator.increaseCalculator(3.7), 1);
    }

    @Test
    void checkThatPercentageOFLessThan5Point5ForRatingOf5Fails() {
        BonusAndIncrease calculator = new BonusAndIncrease(479351.69, 5);
        assertEquals(-1, calculator.increaseCalculator(5.49), 1);
    }

    @Test
    void checkThatRatingBelow3DoesNotComputeIncrease() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(432323.70, 2.9);
        assertEquals(0, calculator1.increaseCalculator(9.5),1);
    }

    @Test
    void checkThatRatingBetween3InclusiveAnd3Point5InclusiveReturnsNewSalaryAmount() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(120000.00, 3);
        BonusAndIncrease calculator2 = new BonusAndIncrease(200000.50, 3.5);

        assertEquals(127200.00, calculator1.increaseCalculator(6),1);
        assertEquals(210000.53, calculator2.increaseCalculator(5), 1);
    }



    @Test
    void checkThatRatingBetween3Point6InclusiveAnd3Point9InclusiveReturnsNewSalaryAmount() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(250000.57, 3.6);
        BonusAndIncrease calculator2 = new BonusAndIncrease(312347.89, 3.9);

        assertEquals(268125.61, calculator1.increaseCalculator(7.25), 1);
        assertEquals(326403.55, calculator2.increaseCalculator(4.5), 1);
    }

    @Test
    void checkThatRatingBetween4InclusiveAnd4Point9InclusiveReturnsNewSalaryAmount() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(112908.00, 4);
        BonusAndIncrease calculator2 = new BonusAndIncrease(312347.89, 4.9);

        assertEquals(118327.58, calculator1.increaseCalculator(4.8), 1);
        assertEquals(343582.68,calculator2.increaseCalculator(10), 1);
    }

    @Test
    void checkThatRatingOf5ReturnsNewSalaryAmount() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(255750.03, 5);
        assertEquals(269816.28, calculator1.increaseCalculator(5.5), 1);
    }

    @Test
    void checkThatRatingBetween0AndLessThan3ReturnNoBonus() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(112908.00, 0);
        BonusAndIncrease calculator2 = new BonusAndIncrease(300000.50, 2.9);

        assertEquals(0, calculator1.bonusCalculator());
        assertEquals(0, calculator2.bonusCalculator());
    }

    @Test
    void checkThatRatingBetween3And3Point5ReturnRecognitionPayment() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(250000.00, 3);
        BonusAndIncrease calculator2 = new BonusAndIncrease(112908.00, 3.5);

        assertEquals(10000.00, calculator1.bonusCalculator());
        assertEquals(10000.00, calculator2.bonusCalculator());
    }

    @Test
    void checkThatRatingBetween3Point6And3Point9ReturnGreaterOfRecognitionAmountAnd2ndRecognitionPayment() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(112908.00, 3.6);
        BonusAndIncrease calculator4 = new BonusAndIncrease(300567.89, 3.9);

        assertEquals(13000.00, calculator1.bonusCalculator(),1);
        assertEquals(19536.91, calculator4.bonusCalculator(), 1);
    }

    @Test
    void checkThatRatingBetween4And4Point9ReturnGreaterOfTwoBonusAmounts() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(160700.57, 4);
        BonusAndIncrease calculator4 = new BonusAndIncrease(570987.34, 4.9);

        assertEquals(16000.00, calculator1.bonusCalculator(), 1);
        assertEquals(42824.05, calculator4.bonusCalculator(), 1);
    }

    @Test
    void checkThatRatingOf5ReturnsGreaterOfTwoBonusAmounts() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(112908.00, 5);
        BonusAndIncrease calculator4 = new BonusAndIncrease(1003789.32, 5);

        assertEquals(19000.00, calculator1.bonusCalculator(), 1);
        assertEquals(100378.93, calculator4.bonusCalculator(), 1);
    }
}