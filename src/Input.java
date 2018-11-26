import java.util.Scanner;

public class Input {
        private Scanner sc;
        public Input(Scanner sc) {
            this.sc = sc;
        }

        public String getString(){
            return this.sc.nextLine();
        }
        public Boolean yesNo(){
            String answer = sc.next();
            return (answer.equals("yes") || answer.equals("y"));
        }
        public int getInt(int min, int max){
            int input;
            do {
                System.out.println("Please enter a valid number");
                input = sc.nextInt();
            } while (input >= min && input <= max);
            return input;
        }

        public int getInt(){
            int output;
            try {
                output = Integer.valueOf(getString());
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. please try again.");
                return getInt();
            }
            return output; }

        public double getDouble(double min, double max) {
            double input;
            System.out.println("enter a decimal integer");
            input = sc.nextDouble();
            if (input >= min && input <= max){
                System.out.println("You are within range!");
            } else {
                return getDouble(min, max);
            }
            return input;
        }
}
