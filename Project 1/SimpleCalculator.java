import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("Simple Calculator (Type 'exit' to quit)");

        while (continueCalculating) {
            try {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char operator = scanner.next().charAt(0);

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            System.out.println("Error! Division by zero is not allowed.");
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Invalid operator! Please use +, -, *, or /.");
                        continue;
                }

                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter numbers correctly.");
                scanner.next(); // Clear invalid input
            }

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                continueCalculating = false;
            }
        }

        System.out.println("Calculator Closed.");
        scanner.close();
    }
}
