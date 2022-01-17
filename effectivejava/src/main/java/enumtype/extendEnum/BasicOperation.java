package enumtype.extendEnum;

public enum BasicOperation implements Operation{
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            if (y == 0) {
                throw new ArithmeticException();
            }
            return x / y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    };

    private final String operation;

    BasicOperation(String operation) {
        this.operation = operation;
    }
}
