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

    public void start() {
        System.out.println("Hello User!");
        changeLinearEquation();
        menu();
    }

    public void changeLinearEquation() {

        System.out.print("Type your first coordinate, in format (x, y): ");
        do {
            // getting user input
            coordinate1 = scan.nextLine().trim();
            if (formatChecker(coordinate1)) {
                // parsing bc right format
                x1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf("(") + 1, coordinate1.indexOf(",")).trim());
                y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(",") + 1, coordinate1.indexOf(")")).trim());
            } else {
                // forcing user to put in correct format
                System.out.print("Please use the correct format of (x, y): ");
            }
        } while (!formatChecker(coordinate1));

        System.out.print("Type your second coordinate, in format (x, y): ");

        // does the program once, then makes sure that the format is correct so the program does not crash
        do {
            // getting user input
            coordinate2 = scan.nextLine().trim();
            if (formatChecker(coordinate2)) {
                // parsing bc right format
                x2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf("(") + 1, coordinate2.indexOf(",")).trim());
                y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(",") + 1, coordinate2.indexOf(")")).trim());
            } else {
                // forcing user to put in correct format
                System.out.print("Please use the correct format of (x, y): ");
            }
        } while (!formatChecker(coordinate2));

        // to make sure coordinate one is to the left of coordinate two, to make  my program not mess up
        if (x2 < x1) {
            int xtemp = x1;
            int ytemp = y1;
            x1 = x2;
            y1 = y2;
            x2 = xtemp;
            y2 = ytemp;
        }
        equation = new LinearEquation(x1,y1,x2,y2);
    }

    // menu for the user to choose what they want to do
    public void menu() {
        String userInput;
        int userInputNum;
        System.out.print("\n--- Menu ---\n1 = Line info\n2 = Slope\n3 = Distance between points\n4 = Coordinate of an x-value\n5 = New linear equation\n6 = End program\n\nType your choice: ");
        userInput = scan.nextLine();
        if (typeOfInput(userInput)) {
            userInputNum = Integer.parseInt(userInput);

            // if statement checks what int the userInputNum is, and decides which option it aligns with if any
            if (userInputNum < 0 || userInputNum > 7) {
                System.out.println("Error, please try again");
                menu();
            } else if (userInputNum == 1) {
                System.out.println("\n--- Line Info ---");
                System.out.println(equation.lineInfo());
                menu();
            } else if (userInputNum == 2) {
                System.out.println("\n--- Slope ---");
                System.out.println(equation.slope());
                menu();
            } else if (userInputNum == 3) {
                System.out.println("\n--- Distance Between Points ---");
                System.out.println(equation.distance() + " units");
                menu();
            } else if (userInputNum == 4) {
                System.out.print("What is the X value?: ");
                userInput = scan.nextLine();
                // needs to make sure it's the right kind of input
                if (typeOfInput(userInput)) {
                    System.out.println("\n--- Coordinate Of X ---");
                    System.out.println(equation.coordinateForX(Integer.parseInt(userInput)));
                } else {
                    System.out.println("Error, please try again");
                }
                menu();
            } else if (userInputNum == 5) {
                System.out.println("\n--- New Equation ---");
                changeLinearEquation();
                menu();
            } else if (userInputNum == 6) {
                System.out.println("Goodbye!");
            }
        } else {
            System.out.println("Error, please try again");
            menu();
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
        } else if (idxOpenParenthesis + 1 == idxComma) {
            return false;
        } else return typeOfInput(coordinate.substring(idxOpenParenthesis, idxComma)) && typeOfInput(coordinate.substring(idxComma) + 1); // checking if there is any letters or other unauthorized characters
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
