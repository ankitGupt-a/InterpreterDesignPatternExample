public class NumberExpression implements Expression{
    private final int number;

    public NumberExpression(final int number) {
        this.number = number;
    }

    public int interpreter() {
        return number;
    }
}
