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

    // getter methods
    public int getX1() {return x1;}
    public int getX2() {return x2;}
    public int getY1() {return y1;}
    public int getY2() {return y2;}

    public void start() {
        welcome();
    }

    public void welcome() {
        System.out.println("Hello User!");
        System.out.print("Type your first coordinate, in format (x, y): ");

        // does the program once, then makes sure that the format is correct so the program does not crash
        do {
            coordinate1 = scan.nextLine().trim();
            correctFormat = formatChecker(coordinate1);
            if (!correctFormat) {
                System.out.print("Please use the correct format of (x, y): ");
            } else {
                // parsing bc right format
                x1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf("(") + 1, coordinate1.indexOf(",")).trim());
                y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(",") + 1, coordinate1.indexOf(")")).trim());
                System.out.println(x1);
                System.out.println(y1);
            }
        } while (!correctFormat);

        // resetting it
        correctFormat = false;
        System.out.print("Type your second coordinate, in format (x, y): ");

        // does the program once, then makes sure that the format is correct so the program does not crash
        do {
            coordinate2 = scan.nextLine().trim();
            correctFormat = formatChecker(coordinate2);
            if (!correctFormat) {
                System.out.print("Please use the correct format of (x, y): ");
            } else {
                // parsing bc right format
                x2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf("(") + 1, coordinate2.indexOf(",")).trim());
                y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(",") + 1, coordinate2.indexOf(")")).trim());
                System.out.println(x2);
                System.out.println(y2);
            }
        } while (!correctFormat);
        LinearEquation linearEquation = new LinearEquation(x1,y1,x2,y2);
    }

    public void menu() {
        System.out.print("--- Menu ---\n1 = Line Info\n 2 = Slope\n3 = ");
    }
    public boolean formatChecker(String coordinate) {
        // used to make sure user does right format
        int idxOpenParenthesis = coordinate.indexOf("(");
        int idxCloseParenthesis = coordinate.indexOf(")");
        int idxComma = coordinate.indexOf(",");
        int idxSpace = coordinate.indexOf(" ");

        if (idxOpenParenthesis != 0) {
            return false;
        } else if (idxCloseParenthesis != coordinate.length() - 1) {
            return false;
        } else if (idxComma + 1 == idxCloseParenthesis) {
            return false;
        } else return idxOpenParenthesis + 1 != idxComma;
    }
}
