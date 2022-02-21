import java.text.NumberFormat;

public class BonusAndIncrease {

    private final double salary;
    private final double minimumSalary = 112908.00;
    private final double rating;

    public BonusAndIncrease(double salary, double rating) {
        this.salary = salary;
        this.rating = rating;
    }

    public double increaseCalculator(double percentageIncrease) {

        percentageIncrease /= 100;

        if (this.salary < this.minimumSalary || percentageIncrease < 0 || this.rating < 0 || this.rating > 5) {
            System.out.println("Invalid Input Error: " + "\n" +
                    "Minimum amount for salary is: " + currencyFormatter(this.minimumSalary) + "\n" +
                    "Percentage cannot be less than: 1" + "\n" +
                    "Rating may not be less than: 0 or greater than: 5");

            return -1;

        } else if (this.rating >= 0 && this.rating < 3) {
            System.out.println("No increase for you!");

            return 0;

        } else if ((this.rating >= 3) && (this.rating <= 3.5)) {
            System.out.println("Your salary was increased by " + percentage(percentageIncrease) + "%.\n"
                    + "Your new salary is " + currencyFormatter(newSalary(percentageIncrease)));

            return newSalary(percentageIncrease);

        } else if ((this.rating >= 3.6) && (this.rating <= 3.9)) {
            System.out.println("Your salary was increased by " + percentage(percentageIncrease) + "%.\n"
                    + "Your new salary is " + currencyFormatter(newSalary(percentageIncrease)));

            return newSalary(percentageIncrease);

        } else if ((this.rating >= 4) && (this.rating <= 4.9)) {
            System.out.println("Your salary was increased by " + percentage(percentageIncrease) + "%.\n"
                    + "Your new salary is " + currencyFormatter(newSalary(percentageIncrease)));

            return newSalary(percentageIncrease);

        } else if (this.rating == 5) {
            System.out.println("Your salary was increased by " + percentage(percentageIncrease) + "%." + "\n"
                    + "Your new salary is " + currencyFormatter(newSalary(percentageIncrease)));

            return newSalary(percentageIncrease);

        } else System.out.println("No increase for you, your salary remains unchanged at " +
                currencyFormatter(this.salary));
        return -1;
    }

    public double bonusCalculator() {

        final double firstRecognitionAmount = 10000.00;
        final double secondRecognitionAmount = 13000.00;
        double firstBonusAmount = 16000.00;
        double secondBonusAmount = 19000.00;
        final double percentage1 = 6.5;
        final double percentage2 = 7.5;
        final double percentage3 = 10;

        if (this.salary < this.minimumSalary || this.rating < 0 || this.rating > 5) {
            System.out.println("Invalid Input Error: " + "\n" +
                    "Minimum amount for salary is: " + currencyFormatter(this.minimumSalary) + "\n" +
                    "Rating may not be less than: 0 or greater than: 5");

            return -1;

        } else if (this.rating >= 0 && this.rating < 3) {
            System.out.println("No firstBonusAmount for you.");

            return 0;

        } else if ((this.rating >= 3) && (this.rating <= 3.5)) {
            System.out.println("No performance firstBonusAmount for you, but your efforts have been recognized.\n"
                    + "Your performance recognition payment is: " + currencyFormatter(firstRecognitionAmount));

            return firstRecognitionAmount;

        } else if ((this.rating >= 3.6) && (this.rating <= 3.9)) {
            double recognitionAmount = bonusAmount(percentage1);
            if (recognitionAmount > secondRecognitionAmount) {
                System.out.println("No performance firstBonusAmount for you, but your efforts have been recognized.\n"
                        + "Your performance recognition payment is: " + currencyFormatter(secondRecognitionAmount));

                return recognitionAmount;

            } else {
                System.out.println("No performance firstBonusAmount for you, but your efforts have been recognized..\n"
                        + "Your performance recognition payment is: " + currencyFormatter(secondRecognitionAmount));

                return secondRecognitionAmount;

            }
        } else if ((this.rating >= 4) && (this.rating <= 4.9)) {
            double bonusAmount = bonusAmount(percentage2);
            if (bonusAmount > firstBonusAmount) {
                System.out.println("Your bonus amount is " + currencyFormatter(bonusAmount));

                return bonusAmount;

            } else {
                System.out.println("Your bonus amount is " + currencyFormatter(firstBonusAmount));

                return firstBonusAmount;
            }
        } else if ((this.rating == 5)) {
            double bonusAmount = bonusAmount(percentage3);
            if (bonusAmount > secondBonusAmount) {
                System.out.println("Your bonus amount is: " + currencyFormatter(bonusAmount));

                return bonusAmount;

            } else {
                System.out.println("Your bonus amount is: " + currencyFormatter(secondBonusAmount));

            }
        } return secondBonusAmount;
    }

    private String currencyFormatter(double money) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(money);
    }

    private double percentage(double percentageIncrease) {
        return percentageIncrease * 100;
    }

    private double newSalary(double percentageIncrease) {
        double increaseAmount = (percentageIncrease * this.salary);
        return increaseAmount + this.salary;
    }

    private double bonusAmount(double percentage) {
        return (percentage / 100) * this.salary;
    }
}

