package christmas.view.constant;

public enum ConstantMessage {

    EVENT_MONTH("12월"),
    Greetings("안녕하세요! 우테코 식당 " + EVENT_MONTH.getMessage() + " 이벤트 플래너입니다."),
    REQUEST_DAY(EVENT_MONTH.getMessage() + " 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)"),
    REQUEST_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    EVENT_INFORMATION("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU("<주문 메뉴>"),
    TOTAL_PRICE_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    PRESENTATION_MENU("<증정 메뉴>"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT_PRICE("<총혜택 금액>"),
    TOTAL_PRICE_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<" +EVENT_MONTH.getMessage() + " 이벤트 배지>");


    private final String message;

    ConstantMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    }
