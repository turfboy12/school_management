package za.ac.cput.schoolmanagement.util;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Range;


import java.time.temporal.ValueRange;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class helper {
    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }

}
