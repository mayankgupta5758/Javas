
public class EnumExample {

	public static void main(String[] args) {
//		Java me enum (Enumeration) ek special data type hota hai jisme hum fixed set of constants define karte hain.

		enum Day {
			MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
		}

		Day today = Day.MONDAY;
		today = Day.TUESDAY;
		System.out.println(today);
		
		

		enum Status {
			SUCCESS, FAILED, PENDING
		}

		Status s = Status.SUCCESS;

		switch (s) {
		case SUCCESS:
			System.out.println("Operation Successful");
			break;
		case FAILED:
			System.out.println("Operation Failed");
			break;
		case PENDING:
			System.out.println("Operation Pending");
			break;
		}

	}

}
