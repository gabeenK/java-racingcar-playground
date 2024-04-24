import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static int splitAndSum(String target) {
		if (StringUtils.isEmpty(target)) {
			return 0;
		}
		return calculate(toArray(target));
	}

	private static String[] toArray(String target) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(target);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return target.split("[,|:]");
	}

	private static int calculate(String[] arr) {
		return Arrays.stream(arr)
				.mapToInt(StringAddCalculator::stringToInt)
				.sum();
	}

	private static int stringToInt(String str) {
		int num = Integer.parseInt(str);
		if (num < 0) {
			throw new RuntimeException("음수 금지");
		}
		return num;
	}
}