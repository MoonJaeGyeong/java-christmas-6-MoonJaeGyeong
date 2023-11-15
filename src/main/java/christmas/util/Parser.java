package christmas.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 기준 단어를 받은 후 그 기준으로 나누어 List<String> 으로 반환하는 클래스 */
public class Parser {
    public List<String> parseSplitByCriterion(String input, String criterion){
        return new ArrayList<>(Arrays.asList(input.split(criterion)));
    }
}
