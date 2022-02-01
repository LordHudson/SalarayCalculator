public class Main {

    public static void main(String[] args) {

        BonusAndIncrease calculator = new BonusAndIncrease(100000, 3, 5);

        System.out.println("******************Increase Calculator***************" + "\n");
        calculator.increaseCalculator();
        System.out.println("""

                ******************Bonus Calculator***************
                """);
        calculator.bonusCalculator();
    }
}
