public class Main {
    public static void main(String[] args) {
        String expression = "( 3 + 9 * 2 ) * ( 3 - 8 / 4 )";

        Expression parseExpression = ExpressionParser.parse(expression);

        int result = parseExpression.interpreter();
        System.out.println("Expression: " + expression);
        System.out.println("Value: " + result);
    }
}