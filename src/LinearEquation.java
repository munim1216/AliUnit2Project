public class LinearEquation {
    // instance variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        // constructor
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return roundedToHundreth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double slope() {
        if ((x2 - x1) == 0) {
            return 0.0;
        } else {
            return roundedToHundreth((double) (y2 - y1) / (x2 - x1));
        }
    }

    public double yIntercept() {
        if (slope() != 0) {
            return roundedToHundreth(slope() * -x1 + y1);
        }
        return x1;
    }

    public String equation() {
        String equation = "y = "; // the string that stores the equation

        if (slope() == -1.0) { // if the slope is -1 there is no need to show the 1, just a -
            equation += "-x";
        } else if (slope() == 1.0) { // if the slope is 1 there is no need to add the 1
            equation += "x";
        } else if (slope() != 0 && slope() % 1 == 0) { // if the slope isn't 0 (flat line) and it's a whole number show it
            equation += cleanNum(slope()) + "x";
        } else if (slope() != 0) { // if the slope isn't 0 (flat line) show it
            equation += fractionMaker((y2 - y1), (x2 - x1)) + "x";
        } else if (slope() == 0) {
            equation = "x = ";
        }

        if (equation.equals("x = ")) { // checks if the slope is 0 or not
            if (yIntercept() != 0 && yIntercept() > 0) { // making sure that the y intercept isn't 0, and is positive
                equation += cleanNum(yIntercept());
            } else if (yIntercept() != 0 && yIntercept() < 0) {
                equation += cleanNum(yIntercept());
            }
        } else {
            if (yIntercept() != 0 && yIntercept() > 0) { // making sure that the y intercept isn't 0, and is positive
                equation += " + " + cleanNum(yIntercept());
            } else if (yIntercept() != 0 && yIntercept() < 0) {
                equation += " - " + cleanNum(yIntercept() * -1);
            }
        }
        return equation; // the final equation returned
    }


    // helper method to make whole numbers look prettier
    public String cleanNum(double toBeCleaned) {
        if ((int)toBeCleaned == toBeCleaned) {
            return "" + (int) toBeCleaned;
        } else {
            return "" + toBeCleaned;
        }
    }

    public String coordinateForX(int x) {
        return "(" + x + ", " + cleanNum((unroundedSlope() * x + yIntercept())) + ")"; // unrounded slope for max precision
    }

    private double roundedToHundreth(double toRound) {
        return Math.round(100 * toRound) / 100.0;
    }

    public String lineInfo() {
        String lineInfo = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        lineInfo += "\nThe equation of the line between these points is: " + equation();

        // checking if the slope is 0 to determine what to output
        if (slope() == 0) {
            lineInfo += "\nThe slope of this line is: 0, as it is a vertical line";
        } else {
            lineInfo += "\nThe slope of this line is: " + cleanNum(slope());
        }

        // checking if slope is 0 to determine what to output
        if (slope() == 0) {
            lineInfo += "\nThe x-intercept of this line is: (" + cleanNum(yIntercept()) + ", 0)";
        } else {
            lineInfo += "\nThe y-intercept of this line is: (0, " + cleanNum(yIntercept()) + ")";
        }
        lineInfo += "\nThe distance between these points is " + cleanNum(distance()) + " units";
        return lineInfo;
    }

    // private helper method to ensure accurate results
    private double unroundedSlope() {
        return (double) (y2 - y1) / (x2 - x1);
    }

    // private helper method that makes fractions
    private String fractionMaker(int numerator, int denominator) {
        // string that stores the fraction
        String fraction = "";
        // checking for horizontal slope of 0
        if (slope() == 0) {
            return fraction;
        }

        // simplifying the fraction
        for (int i = 1; i < Math.abs(numerator) || i < Math.abs(denominator); i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator = numerator / i;
                denominator = denominator / i;
            }
        }

        // fraction making
        if (numerator % denominator == 0 && numerator / denominator != 1) {
            fraction = "" + numerator;
        } else if (numerator % denominator == 0 && numerator / denominator == 1) {
            return fraction;
        } else {
            fraction = numerator + "/" + denominator;
            System.out.println(denominator);
        }
        // checking if the negative sign is on the denominator or numerator
        if (denominator < 0 && numerator > 0) {
            fraction = "-" + fraction.substring(0, fraction.indexOf("/") + 1) + fraction.substring(fraction.indexOf("-") + 1);
        }
        return fraction;
    }


}