public class SubstractExpression implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;

    public SubstractExpression(final Expression leftExpression, final Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public int interpreter() {
        return leftExpression.interpreter() - rightExpression.interpreter();
    }
}
