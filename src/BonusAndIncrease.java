public class BonusAndIncrease {

    private double salary;
    private final double rating;
    private double percentageIncrease;

    public BonusAndIncrease(double salary, double rating, double percentageIncrease) {
        this.percentageIncrease = percentageIncrease / 100;
        this.salary = salary;
        this.rating = rating;

        double minimumSalary = 112908.00;
        if (salary < minimumSalary) {
            salary = 0;
            System.out.println("Invalid salary amount. Minimum salary is " + "R" + minimumSalary);
        }
        System.out.println("Your current salary is: " + "R" + salary);
        System.out.println("Your performance rating is: " + rating);
    }

    public void increaseCalculator() {

        double minimumSalary = 112908.00;
        if (this.salary < minimumSalary) {
            this.salary = 0.0;
        }
        if (this.percentageIncrease < 0) {
            this.percentageIncrease = 0;
            System.out.println("**********************************");
            System.out.println("Percentage cannot be less than 0.");
            System.out.println("**********************************");
        }

        if (this.rating <= 0 || this.rating > 5) {
            System.out.println("Invalid rating! Increase not calculated!");
        } else if (this.rating >= 1 && this.rating < 3) {
            System.out.println("No increase for you!");

        } else if ((this.rating >= 3) && (this.rating <= 3.5)) {

            double increaseAmount = (this.percentageIncrease * salary);
            double newSalary = (increaseAmount + this.salary);
            System.out.println("Your salary was increased by " + (this.percentageIncrease * 100) + "%.\n"
                    + "Your new salary is " + "R" + String.format("%.2f", newSalary));
        } else if ((this.rating >= 3.6) && (this.rating <= 3.9)) {
            double increaseAmount = (this.percentageIncrease * this.salary);
            double newSalary = (increaseAmount + this.salary);
            System.out.println("Your salary was increased by " + (this.percentageIncrease * 100) + "%.\n"
                    + "Your new salary is " + "R" + String.format("%.2f", newSalary));

        } else if ((this.rating >= 4) && (this.rating <= 4.9)) {
            double increaseAmount = (this.percentageIncrease * this.salary);
            double newSalary = (increaseAmount + this.salary);
            System.out.println("Your salary was increased by " + (this.percentageIncrease * 100) + "%.\n"
                    + "Your new salary is " + "R" + String.format("%.2f", newSalary));

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
        if (this.salary < minimumSalary) {
            System.out.println("Invalid salary amount, bonus not calculated");
        } else

        if (this.rating <= 0 || this.rating > 5) {
            System.out.println("Invalid rating! Bonus not calculated!");
        } else if (this.rating >= 1 && this.rating < 3) {
            System.out.println("No bonus for you.");
        } else if ((this.rating >= 3) && (this.rating <= 3.5)) {
            System.out.println("No performance bonus for you, but your efforts have been recognized.\n"
                    + "Your performance recognition payment is: " + "R" + recognitionPayment
            );
        } else if ((this.rating >= 3.6) && (this.rating <= 3.9)) {
            double recognitionAmount = (percentage1 / 100) * this.salary;
            if (recognitionAmount > secondRecognitionPayment) {
                System.out.println("No performance bonus for you, but your efforts have been recognized.\n"
                        + "Your performance recognition payment is: " + "R" + recognitionAmount);
            } else {
                System.out.println("No performance bonus for you, but your efforts have been recognized..\n"
                        + "Your performance recognition payment is: " + "R" + secondRecognitionPayment);
            }
        } else if ((this.rating >= 4) && (this.rating <= 4.9)) {
            double bonusAmount = (percentage2 / 100) * this.salary;
            if (bonusAmount > bonus) {
                System.out.println("Your bonus amount is " + "R" + bonusAmount);
            } else {
                System.out.println("Your bonus amount is " + "R" + bonus);
            }

        } else if ((this.rating == 5) ) {
            double bonusAmount = (percentage3 / 100) * this.salary;
            if (bonusAmount > bonus2) {
                System.out.println("Your bonus amount is: " + "R" + bonusAmount);
            } else {
                System.out.println("Your bonus amount is: " + "R" + bonus2);
            }
        } else {
            System.out.println("Invalid rating");
        }
    }
}

