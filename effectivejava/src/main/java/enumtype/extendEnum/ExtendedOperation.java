package enumtype.extendEnum;

public enum ExtendedOperation implements Operation{
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String operation;

    ExtendedOperation(String operation) {
        this.operation = operation;
    }
}
