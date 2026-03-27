import java.util.Scanner;

public class Examples {
	public static void takingInput() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Enter number: ");
			int num = sc.nextInt();
			System.out.println("You entered: " + num);
		} catch (Exception e) {
			System.out.println("Invalid input! Please enter integer only.");
		}

		sc.close();
	}

	public static void withReturn() {
		try {
			int num = 10 / 0;
			return;
		} catch (ArithmeticException e) {
			System.out.println("Exception caught");
			return;
		} finally {
			System.out.println("Finally always runs");
		}
	}

	public static void nestedTryCatch() {
		try {
			int arr[] = { 10, 20, 30 };

			try {
				System.out.println(arr[5]); 
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Array index invalid");
			} finally {
				System.out.println("Internal Finally...");
			}

			int a = 10 / 0; 

		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero");
		} finally {
			System.out.println("Outer Finally...");
		}

		System.out.println("Program continues...");
	}
	
	public static void nestedTryWITHFinally() {
		try {
            System.out.println("Outer try start");

            try {
                System.out.println("Inner try start");
                int a = 10 / 0;   // Exception here
                System.out.println("Inner try end");
            } catch (ArithmeticException e) {
                System.out.println("Inner catch");
            } finally {
                System.out.println("Inner finally");
            }

            System.out.println("Outer try end");

        } catch (Exception e) {
            System.out.println("Outer catch");
        } finally {
            System.out.println("Outer finally");
        }
	}
	
	static void method1() {
        int a = 10 / 0;
    }

    static void method2() {
        method1();
    }

	public static void main(String[] args) {
//		takingInput();
//		withReturn();
//		nestedTryCatch();
		try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled in main()");
        }
	}
}
