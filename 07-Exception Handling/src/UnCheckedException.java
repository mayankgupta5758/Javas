class InvalidAmountException extends RuntimeException {

    InvalidAmountException(String message) {
        super(message);
    }
}

//👉 Compiler force nahi karega
//👉 throws optional
//Yaha throws likhna zaruri nahi hai.
//✔ Logical programming error → Unchecked

public class UnCheckedException {

	static void withdraw(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be positive");
        }
        System.out.println("Withdrawal successful");
    }

    public static void main(String[] args) {
        withdraw(-100);
    }
}
