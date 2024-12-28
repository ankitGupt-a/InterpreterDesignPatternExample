public class DivideExpression implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;

    public DivideExpression(final Expression leftExpression, final Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public int interpreter() {
        if (rightExpression.interpreter() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return leftExpression.interpreter() / rightExpression.interpreter();
    }
}
