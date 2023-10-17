public class LinearEquation {
    // instance variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return Math.round(100 * Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))) / 100.0;
    }

    public double slope() {
        return Math.round(100 * ((double)(y2 - y1) / (x2 - x1))) / 100.0;
    }

    public double unroundedSlope() {
        return (double) (y2 - y1) / (x2 - x1);
    }

    public double yIntercept() {
        return  Math.round(100 * (slope() * -x1 + y1)) / 100.0;
    }
    public String equation() {
        if (slope() == 0 && yIntercept() % 1 == 0) {
            // checking for horizontal slope of 0 & whole number intercept
            return "y = " + (int)yIntercept();
        } else if (slope() == 0) {
            // checking for horizontal slope of 0 & not whole number intercept
            return "y = " + (int)yIntercept();
        } else if (yIntercept() % 1 == 0) {
            // checking for whole number intercept
            return "y = " + fractionMaker((y2 - y1), (x2 - x1)) + "x + " + (int)yIntercept();
        } else {
            // all other cases
            return "y = " + fractionMaker((y2 - y1), (x2 - x1)) + "x + " + yIntercept();
        }

    }

    public String fractionMaker(int numerator, int denominator) {
        // checking for horizontal slope of 0
        if (slope() == 0) {
            return "";
        }
        // fraction making
        if (numerator % denominator == 0 && numerator / denominator != 1) {
            return "" + numerator;
        } else if (numerator % denominator == 0 && numerator / denominator == 1) {
            return "";
        } else {
            return numerator + "/" + denominator;
        }
    }

    public String coordinateForX(int x) {
        return "(" + x + ", " + (unroundedSlope() * x + yIntercept()) + ")";
    }
}