public class LinearEquationRunner {
    public static void main(String[] args) {
        LinearEquation test = new LinearEquation(-1,5,3,10);
        System.out.println(test.slope());
        System.out.println(test.yIntercept());
    }
}
