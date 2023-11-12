package christmas.util;

import static christmas.configuration.PatternConstant.REGEX;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static List<String> splitBy(String value,String delimiter) {
        return List.of(value.replace(" ", "").split(delimiter));
    }

    public static boolean isValidPattern(String value) {
        Pattern pattern = Pattern.compile(REGEX.getValue());
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
