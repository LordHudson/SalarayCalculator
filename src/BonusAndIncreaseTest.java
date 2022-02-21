import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusAndIncreaseTest {

    @Test
    void checkThatInvalidSalaryFails() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(100000.00, 5);
        BonusAndIncrease calculator2 = new BonusAndIncrease(-1, 5);
        BonusAndIncrease calculator3 = new BonusAndIncrease(112907.9, 5);

        assertEquals(-1, calculator1.increaseCalculator(5), 1);
        assertEquals(-1, calculator2.increaseCalculator(5), 1);
        assertEquals(-1, calculator3.increaseCalculator(5),1);
    }

    @Test
    void checkThatNegativeRatingFails() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(150000.00, -1);
        assertEquals(-1, calculator1.increaseCalculator(5), 1);
    }

    @Test
    void checkThatRatingGreaterThanFiveFails() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(100000.00, 5.01);
        BonusAndIncrease calculator2 = new BonusAndIncrease(100000.00, 6);

        assertEquals(-1, calculator1.increaseCalculator(5),1);
        assertEquals(-1, calculator2.increaseCalculator(5),1);
    }

    @Test
    void checkThatNegativePercentageFails() {
        BonusAndIncrease calculator = new BonusAndIncrease(120000.00, 5);
        assertEquals(-1, calculator.increaseCalculator(-1), 1);
    }

    @Test
    void checkThatAllInvalidValuesFail() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(50000.00, -1);
        BonusAndIncrease calculator2 = new BonusAndIncrease(0, 5.1);

        assertEquals(-1, calculator1.increaseCalculator(-1), 1);
        assertEquals(-1, calculator2.increaseCalculator(-1), 1);
    }

    @Test
    void checkThatRatingBelow3DoesNotComputeIncrease() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(120000.00, 2.9);
        BonusAndIncrease calculator2 = new BonusAndIncrease(200000.00, 0);

        assertEquals(0, calculator1.increaseCalculator(2),1);
        assertEquals(0, calculator2.increaseCalculator(5),1);
    }

    @Test
    void checkThatRatingBetween3And3Point5ReturnsNewSalaryAmount() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(120000.00, 3);
        BonusAndIncrease calculator2 = new BonusAndIncrease(200000.50, 3.5);
        BonusAndIncrease calculator3 = new BonusAndIncrease(200000.00, 3.5);
        BonusAndIncrease calculator4 = new BonusAndIncrease(-1, 3.5);

        assertEquals(127200.00, calculator1.increaseCalculator(6),1);
        assertEquals(210000.53, calculator2.increaseCalculator(5), 1);
        assertEquals(-1, calculator3.increaseCalculator(-1), 1);
        assertEquals(-1, calculator4.increaseCalculator(5), 1);
    }

    @Test
    void checkThatRatingBetween3Point6And3Point9ReturnsNewSalaryAmount() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(250000.57, 3.6);
        BonusAndIncrease calculator2 = new BonusAndIncrease(312347.89, 3.9);

        assertEquals(268125.61, calculator1.increaseCalculator(7.25), 1);
        assertEquals(326403.55, calculator2.increaseCalculator(4.5), 1);
    }

    @Test
    void checkThatRatingBetween4And4Point9ReturnsNewSalaryAmount() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(112908.00, 3.6);
        BonusAndIncrease calculator2 = new BonusAndIncrease(312347.89, 3.9);

        assertEquals(117424.32, calculator1.increaseCalculator(4), 1);
        assertEquals(343582.68,calculator2.increaseCalculator(10), 1);
    }

    @Test
    void checkThatRatingOf5ReturnsNewSalaryAmount() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(255750.03, 5);
        assertEquals(267770.28, calculator1.increaseCalculator(4.7), 1);
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
        BonusAndIncrease calculator2 = new BonusAndIncrease(250000.00, 3.7);
        BonusAndIncrease calculator3 = new BonusAndIncrease(150321.57, 3.8);
        BonusAndIncrease calculator4 = new BonusAndIncrease(300567.89, 3.9);

        assertEquals(13000.00, calculator1.bonusCalculator(),1);
        assertEquals(16250.00, calculator2.bonusCalculator(),1);
        assertEquals(13000.00, calculator3.bonusCalculator(), 1);
        assertEquals(19536.91, calculator4.bonusCalculator(), 1);
    }

    @Test
    void checkThatRatingBetween4And4Point9ReturnGreaterOfTwoBonusAmounts() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(160700.57, 4);
        BonusAndIncrease calculator2 = new BonusAndIncrease(200876.78, 4.1);
        BonusAndIncrease calculator3 = new BonusAndIncrease(300500.00, 4.5);
        BonusAndIncrease calculator4 = new BonusAndIncrease(570987.34, 4.9);

        assertEquals(16000.00, calculator1.bonusCalculator(), 1);
        assertEquals(16000.00, calculator2.bonusCalculator(), 1);
        assertEquals(22537.50, calculator3.bonusCalculator(), 1);
        assertEquals(42824.05, calculator4.bonusCalculator(), 1);
    }

    @Test
    void checkThatRatingOf5ReturnsGreaterOfTwoBonusAmounts() {
        BonusAndIncrease calculator1 = new BonusAndIncrease(112908.00, 5);
        BonusAndIncrease calculator2 = new BonusAndIncrease(170367.64, 5);
        BonusAndIncrease calculator3 = new BonusAndIncrease(340123.41, 5);
        BonusAndIncrease calculator4 = new BonusAndIncrease(1003789.32, 5);

        assertEquals(19000.00, calculator1.bonusCalculator(), 1);
        assertEquals(19000.00, calculator2.bonusCalculator(), 1);
        assertEquals(34012.34, calculator3.bonusCalculator(), 1);
        assertEquals(100378.93, calculator4.bonusCalculator(), 1);
    }

}