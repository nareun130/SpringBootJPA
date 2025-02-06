package jpabook.jpashoop.exception;

//* 오버라이드 할 때 이것들 다 오버라이드!! -> 근원적인 Exception을 파악할 때도 도움
public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException() {
        super();
    }

    public NotEnoughStockException(String message) {
        super();
    }

    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }
    //* cause : 이 예외가 발생하게 된 원인이 되는 다른 예외 객체 */
    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }
    //* boolean enableSuppression : 예외 억제 기능을 활성화할 지 여부
    //* boolean writableStackTrace : 스택 트레이스를 출력할 지 여부
    public NotEnoughStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
