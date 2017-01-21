package utils;

/**
 * Created by Project0rion on 21.01.2017.
 */
public class StringUtils {

    public static String ensureStartLower(String s) {
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }

    public static String ensureStartUpper(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
