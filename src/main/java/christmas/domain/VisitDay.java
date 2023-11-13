package christmas.domain;

import christmas.util.validate.IllegalArgumentExceptionType;

public class VisitDay {
    private static final int EVENT_START_DAY = 1;
    private static final int EVENT_END_DAY = 31;

    private final int day;

    public VisitDay(String day){
        validate(day);
        this.day = Integer.parseInt(day);
    }

    private void validate(String input){
        checkIsNumeric(input);
        checkInRange(input);
    }

    private void checkIsNumeric(String input){
        if(!input.matches("\\d+")){
            throw IllegalArgumentExceptionType.DAY_INPUT_ERROR.getException();
        }
    }

    private void checkInRange(String input){
        int day = Integer.parseInt(input);
        if(day < EVENT_START_DAY || day > EVENT_END_DAY){
            throw IllegalArgumentExceptionType.DAY_INPUT_ERROR.getException();
        }
    }
}