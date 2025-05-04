package dev.jino.calculator.Lv3;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType find(char symbol) {
        for (OperatorType operator : OperatorType.values()) {
            if (operator.symbol == symbol) {
                return operator;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + symbol);
    }
}