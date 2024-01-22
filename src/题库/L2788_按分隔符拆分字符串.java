package 题库;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class L2788_按分隔符拆分字符串 {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for (String str : words) {
            String[] strs = str.split("\\" + separator);
            result.addAll(Arrays.asList(strs).stream().filter(s -> !s.equals("")).collect(Collectors.toList()));
        }
        return result;
    }

    public static void main(String[] args) {
        L2788_按分隔符拆分字符串 test = new L2788_按分隔符拆分字符串();

        List<String> result1 = test.splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.');
        System.out.println(result1.toString());

        List<String> result2 = test.splitWordsBySeparator(Arrays.asList("$easy$", "$problem$"), '$');
        System.out.println(result2.toString());
    }
}
