package webApplication.web.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tool {
//check string on have letters
	public int onlyDigits(String str) {
		if (str.length() == 0) {
			return -1;
		}
		int count = 0;
		Pattern pattern = Pattern.compile("\\D");
		Matcher matcher = pattern.matcher(str);

		while (matcher.find()) {
			count++;
		}
		return count;
	}
	//check string on have digits
	public int onlyLetters(String str) {
		if (str.length() == 0) {
			return -1;
		}
		int count = 0;
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = pattern.matcher(str);

		while (matcher.find()) {
			count++;
		}
		return count;
	}
	//check validation email
	public int valideEmail(String email) {
		int count = 0;
		Pattern pattern = Pattern.compile("(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6})");
		Matcher matcher = pattern.matcher(email);

		while (matcher.find()) {
			count++;
		}
		return count;
	}
}
