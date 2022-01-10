import java.text.NumberFormat;

public class BonusAndIncrease {

    private final double salary;
    private final double rating;
    private final double percentageIncrease;

    public BonusAndIncrease(double salary, double rating, double percentageIncrease) {
        this.percentageIncrease = percentageIncrease / 100;
        this.salary = salary;
        this.rating = rating;

        double minimumSalary = 112908.00;
        if (salary < minimumSalary) {
            System.out.println("Invalid salary amount. Minimum salary is " + currencyFormatter(minimumSalary));
        }
    }

    public void increaseCalculator() {

        double minimumSalary = 112908.00;
        if (salary < minimumSalary || percentageIncrease < 1 || (rating < 0 || rating > 5)) {
            System.out.println("Invalid Input Error: " + "\n" +
                    "Minimum amount for salary is: " + currencyFormatter(minimumSalary) + "\n" +
                    "Percentage cannot be less than: 1" + "\n" +
                    "Rating may not be less than: 0 or greater than: 5" );
        } else if (this.rating >= 1 && this.rating < 3) {
            System.out.println("No increase for you!");

        } else if ((this.rating >= 3) && (this.rating <= 3.5)) {

            double increaseAmount = (this.percentageIncrease * salary);
            double newSalary = (increaseAmount + this.salary);
            System.out.println("Your salary was increased by " + (this.percentageIncrease * 100) + "%.\n"
                    + "Your new salary is " + currencyFormatter(newSalary));
        } else if ((this.rating >= 3.6) && (this.rating <= 3.9)) {
            double increaseAmount = (this.percentageIncrease * this.salary);
            double newSalary = (increaseAmount + this.salary);
            System.out.println("Your salary was increased by " + (this.percentageIncrease * 100) + "%.\n"
                    + "Your new salary is " + currencyFormatter(newSalary));

        } else if ((this.rating >= 4) && (this.rating <= 4.9)) {
            double increaseAmount = (this.percentageIncrease * this.salary);
            double newSalary = (increaseAmount + this.salary);
            System.out.println("Your salary was increased by " + (this.percentageIncrease * 100) + "%.\n"
                    + "Your new salary is " + currencyFormatter(newSalary));

        } else if (this.rating == 5) {
            double increaseAmount = (this.percentageIncrease * this.salary);
            double newSalary = (increaseAmount + this.salary);
            System.out.println("Your salary was increased by " + (this.percentageIncrease * 100) + "%." + "\n"
                    + "Your new salary is " + "R" + String.format("%.2f", newSalary));
        } else System.out.println("No increase for you, your salary remains unchanged at " + this.salary);
    }

    public void bonusCalculator() {

        final double recognitionPayment = 10000.00;
        final double secondRecognitionPayment = 13000.00;
        double bonus = 16000.00;
        double bonus2 = 19000.00;
        final double percentage1 = 6.5;
        final double percentage2 = 7.5;
        final double percentage3 = 10;

        double minimumSalary = 112908.00;
        if (this.salary < minimumSalary || this.percentageIncrease < 1|| (this.rating < 0 || this.rating > 5)) {
            System.out.println("Invalid Input Error: " + "\n" +
                    "Minimum amount for salary is: " + currencyFormatter(minimumSalary) + "\n" +
                    "Percentage cannot be less than: 1" + "\n" +
                    "Rating may not be less than: 0 or greater than: 5" );
        } else if (this.rating >= 1 && this.rating < 3) {
            System.out.println("No bonus for you.");
        } else if ((this.rating >= 3) && (this.rating <= 3.5)) {
            System.out.println("No performance bonus for you, but your efforts have been recognized.\n"
                    + "Your performance recognition payment is: " + currencyFormatter(recognitionPayment));
        } else if ((this.rating >= 3.6) && (this.rating <= 3.9)) {
            double recognitionAmount = (percentage1 / 100) * this.salary;
            if (recognitionAmount > secondRecognitionPayment) {
                System.out.println("No performance bonus for you, but your efforts have been recognized.\n"
                        + "Your performance recognition payment is: " + currencyFormatter(recognitionAmount));
            } else {
                System.out.println("No performance bonus for you, but your efforts have been recognized..\n"
                        + "Your performance recognition payment is: " + currencyFormatter(recognitionPayment));
            }
        } else if ((this.rating >= 4) && (this.rating <= 4.9)) {
            double bonusAmount = (percentage2 / 100) * this.salary;
            if (bonusAmount > bonus) {
                System.out.println("Your bonus amount is " + currencyFormatter(bonusAmount));
            } else {
                System.out.println("Your bonus amount is " + currencyFormatter(bonus));
            }

        } else if ((this.rating == 5) ) {
            double bonusAmount = (percentage3 / 100) * this.salary;
            if (bonusAmount > bonus2) {
                System.out.println("Your bonus amount is: " + currencyFormatter(bonusAmount));
            } else {
                System.out.println("Your bonus amount is: " + currencyFormatter(bonus2));
            }
        }
    }

    private String currencyFormatter(double money) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(money);
    }
}

