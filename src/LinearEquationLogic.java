import java.util.Scanner;
public class LinearEquationLogic {
    // instance variables
    String coordinate1;
    String coordinate2;
    boolean correctFormat;
    int x1;
    int y1;
    int x2;
    int y2;
    Scanner scan = new Scanner(System.in);

    public LinearEquationLogic() {
        start();
    }

    public void start() {
        welcome();
    }
    public int getX1() {return x1;}
    public int getX2() {return x2;}
    public int getY1() {return y1;}
    public int getY2() {return y2;}

    public void welcome() {
        System.out.println("Hello User!");
        System.out.print("Type your first coordinate, in format (x, y): ");
        do {
            coordinate1 = scan.nextLine();
            correctFormat = formatChecker(coordinate1);
            if (!correctFormat) {
                System.out.print("Please use the correct format of (x, y): ");
            } else {
                x1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf("(") + 1, coordinate1.indexOf(",")));
                y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(",") + 2, coordinate1.indexOf(")")));
                System.out.println(x1);
                System.out.println(y1);
            }
        } while (!correctFormat);

        // resetting it
        correctFormat = false;

        System.out.print("Type your second coordinate, in format (x, y): ");
        do {
            coordinate2 = scan.nextLine();
            correctFormat = formatChecker(coordinate2);
            if (!correctFormat) {
                System.out.print("Please use the correct format of (x, y): ");
            } else {
                x2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf("(") + 1, coordinate2.indexOf(",")));
                y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(",") + 2, coordinate2.indexOf(")")));
                System.out.println(x2);
                System.out.println(y2);
            }
        } while (!correctFormat);
    }
// use .trim() on x and y strings
    public boolean formatChecker(String coordinate) {
        // used to make sure user does right format
        int idxOpenParenthesis = coordinate.indexOf("(");
        int idxCloseParenthesis = coordinate.indexOf(")");
        int idxComma = coordinate.indexOf(",");
        int idxNegativeSign1 = coordinate.indexOf("-");
        int idxNegativeSign2 = coordinate.lastIndexOf("-");
        int idxSpace = coordinate.indexOf(" ");

        if (idxOpenParenthesis != 0) {
            return false;
        } else if (idxCloseParenthesis != coordinate.length() - 1) {
            return false;
        } else if (idxComma + 1 == idxCloseParenthesis) {
            return false;
        } else if (idxOpenParenthesis + 1 == idxComma) {
            return false;
        } else if (idxComma + 2 == idxCloseParenthesis) {
            return false;
        } else if (idxComma + 1 != idxSpace){
            return false;
        } else if (idxComma + 1 == idxNegativeSign1) {
            return false;
        } else return idxComma + 1 != idxNegativeSign2;
    }
}
