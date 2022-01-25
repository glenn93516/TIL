package lambdas;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    DIVIDE("/", (x, y) -> x / y),
    TIMES("*", (x, y) -> x * y);

    private final String operation;
    private final DoubleBinaryOperator expression;

    Operation(String operation, DoubleBinaryOperator expression) {
        this.operation = operation;
        this.expression = expression;
    }

    public double apply(double x, double y) {
        return expression.applyAsDouble(x, y);
    };
}
