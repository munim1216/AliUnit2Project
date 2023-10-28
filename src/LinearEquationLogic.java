import java.util.Scanner;
public class LinearEquationLogic {
    // instance variables
    String coordinate1;
    String coordinate2;
    int x1;
    int y1;
    int x2;
    int y2;
    Scanner scan = new Scanner(System.in);
    LinearEquation equation;

    // constructor for LinearEquationLogic
    public LinearEquationLogic() {
        start();
    }

    // getter methods
    public int getX1() {return x1;}
    public int getX2() {return x2;}
    public int getY1() {return y1;}
    public int getY2() {return y2;}

    public void start() {
        System.out.println("Hello User!");
        changeLinearEquation();
    }

    public void changeLinearEquation() {


        System.out.print("Type your first coordinate, in format (x, y): ");
        do {
            // getting user input
            coordinate1 = scan.nextLine().trim();
            if (!formatChecker(coordinate1)) {
                System.out.print("Please use the correct format of (x, y): ");
            } else {
                // parsing bc right format
                x1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf("(") + 1, coordinate1.indexOf(",")).trim());
                y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(",") + 1, coordinate1.indexOf(")")).trim());
                // testing code
                System.out.println(x1);
                System.out.println(y1);
            }
        } while (!formatChecker(coordinate1));

        System.out.print("Type your second coordinate, in format (x, y): ");

        // does the program once, then makes sure that the format is correct so the program does not crash
        do {
            // getting user input
            coordinate2 = scan.nextLine().trim();
            if (!formatChecker(coordinate2)) {
                System.out.print("Please use the correct format of (x, y): ");
            } else {
                // parsing bc right format
                x2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf("(") + 1, coordinate2.indexOf(",")).trim());
                y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(",") + 1, coordinate2.indexOf(")")).trim());
                // testing code
                System.out.println(x2);
                System.out.println(y2);
            }
        } while (!formatChecker(coordinate2));
        equation = new LinearEquation(x1,y1,x2,y2);
    }

    // menu for the user to choose what they want to do
    public void menu() {
        String userInput;
        int userInputNum;
        System.out.print("--- Menu ---\n1 = Line info\n 2 = Slope\n3 = Distance between points\n4 = Coordinate of an x-value\n5 = New linear equation\n6 = End program\nType your choice:");
        userInput = scan.nextLine();
        if (typeOfInput(userInput)) {
            userInputNum = Integer.parseInt(userInput);
            if (userInputNum < 0 || userInputNum > 7) {
                System.out.println("Error, please try again");
                menu();
            } else if (userInputNum == 1) {
                equation.lineInfo();
                menu();
            } else if (userInputNum == 2) {
                equation.slope();
                menu();
            } else if (userInputNum == 3) {
                equation.distance();
                menu();
            } else if (userInputNum == 4) {
                userInput = scan.nextLine();
                if (typeOfInput(userInput)) {
                    equation.coordinateForX(Integer.parseInt(userInput));
                } else {
                    System.out.println("Error, please try again");
                }
                menu();
            } else if (userInputNum == 5) {

            } else if (userInputNum == 6) {

            }
        }
    }

    // private method used internally to check the format of a coordinate
    private boolean formatChecker(String coordinate) {
        // used to make sure user does right format
        int idxOpenParenthesis = coordinate.indexOf("(");
        int idxCloseParenthesis = coordinate.indexOf(")");
        int idxComma = coordinate.indexOf(",");

        if (idxOpenParenthesis != 0) {
            return false;
        } else if (idxCloseParenthesis != coordinate.length() - 1) {
            return false;
        } else if (idxComma + 1 == idxCloseParenthesis) {
            return false;
        } else return idxOpenParenthesis + 1 != idxComma;
    }

    // private method used internally to check the input type
    private boolean typeOfInput(String userInput) {
        try {
            int testingInt = Integer.parseInt(userInput);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
