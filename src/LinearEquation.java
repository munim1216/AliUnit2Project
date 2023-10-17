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
    public double yIntercept() {
        return  Math.round(100 * (slope() * -x1 + y1)) / 100.0;
    }
}