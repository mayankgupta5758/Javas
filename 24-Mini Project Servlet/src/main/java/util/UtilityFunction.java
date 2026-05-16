package util;

public class UtilityFunction {

	public static boolean isValidEmail(String email) {

		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		return email.matches(emailRegex);
	}

	public static boolean isValidDuration(String duration) {

		String durationRegex = "^[1-9][0-9]*$";
		return duration.matches(durationRegex);
	}
}
