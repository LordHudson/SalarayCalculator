public class Main {

    public static void main(String[] args) {

        BonusAndIncrease calculator = new BonusAndIncrease(200000.50, 3.6);

        System.out.println("******************Increase Calculator***************" + "\n");
        System.out.println("return value " + calculator.increaseCalculator(4.4));
        System.out.println("""

                ******************Bonus Calculator***************
                """);
        System.out.println("Return value: " + calculator.bonusCalculator());

    }
}
