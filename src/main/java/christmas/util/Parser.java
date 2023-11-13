package christmas.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public List<String> parseSplitByCriterion(String input, String criterion){
        return new ArrayList<>(Arrays.asList(input.split(criterion)));
    }
}
