package vn.com.vti_crm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.util.Date;
import org.springframework.util.StringUtils;

public class Utils {

	public static boolean isMatchRegex(String input, String regex) {
		// validate input
		if (StringUtils.isEmpty(input)) {
			return false;
		}

		// return validation result
		return Pattern.compile(regex).matcher(input).matches();
	}

	public static Date convertStringToDateObject(String input, String pattern) throws ParseException {
		return new SimpleDateFormat(pattern).parse(input);
	}
}
