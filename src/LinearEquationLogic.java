import java.util.Scanner;
public class LinearEquationLogic {

    private final Scanner scan;

    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }

    public void start() {
        calculate();
    }

    private void calculate() {
        System.out.println("Hello and welcome to the Linear Equation Calculator!");
        String repeat = "y";
        while (repeat.equals("y")) {
            System.out.print("Enter your first coordinate: ");
            String c1 = scan.nextLine();
            System.out.print("Enter your second coordinate: ");
            String c2 = scan.nextLine();

            int comma1 = c1.indexOf(",");
            int comma2 = c2.indexOf(",");
            int x1 = Integer.parseInt(c1.substring(1, comma1));
            int y1 = Integer.parseInt(c1.substring(comma1 + 2, c1.length() - 1));
            int x2 = Integer.parseInt(c2.substring(1, comma2));
            int y2 = Integer.parseInt(c2.substring(comma2 + 2, c2.length() - 1));

            if (x1 == x2) {
                System.out.println("Error. Please submit 2 points that would exist on a linear function.\nThey must have different x-coordinates.");
            } else {
                LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
                System.out.println("The two points are " + c1 + " and " + c2);
                System.out.println(equation.lineInfo());
                System.out.print("Enter an x-value to insert into the equation: ");
                double x = scan.nextDouble();
                System.out.println("The corresponding y-value for the x-value of " + x + " is: " + equation.coordinateForX(x));
            }
            scan.nextLine();
            System.out.print("Would you like to go again? y/n ");
            repeat = scan.nextLine();
        }
    }
}