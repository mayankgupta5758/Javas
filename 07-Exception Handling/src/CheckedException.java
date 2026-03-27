class InvalidAgeException extends Exception {

    InvalidAgeException(String message) {
        super(message);
    }
}

/*
 * 👉 Compiler force karega handle karne ke liye 
 * 👉 throws ya try-catch mandatory
 * throws InvalidAgeException likhna compulsory hai.
 * ✔ Business validation → Checked
 */

public class CheckedException {

    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18+");
        }
        System.out.println("Valid age");
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}