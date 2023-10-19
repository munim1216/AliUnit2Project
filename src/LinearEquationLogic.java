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

    public LinearEquationLogic() {
        start();
    }

    public void start() {
        welcome();
    }

    public void welcome() {
        System.out.println("Hello User!");
        System.out.print("Type your first coordinate, in format (x, y): ");
        coordinate1 = scan.nextLine();
        System.out.println(Integer.parseInt(coordinate1));
    }
}
