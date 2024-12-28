import java.util.Stack;

public class ExpressionParser {
    public static Expression parse(String input) {
        String[] tokens = input.split(" ");
        Stack<Expression> values = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (String token: tokens) {
            if (isNumber(token)) {
                values.push(new NumberExpression(Integer.parseInt(token)));
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    Expression right = values.pop();
                    Expression left = values.pop();
                    String op = operators.pop();
                    values.push(applyOperator(left, right, op));
                }
                operators.pop();
            } else if (isOperator(token)){
                while (!operators.isEmpty() && precedence(token) <= precedence(operators.peek())) {
                    Expression right = values.pop();
                    Expression left = values.pop();
                    String op = operators.pop();
                    values.push(applyOperator(left, right, op));
                }
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            Expression right = values.pop();
            Expression left = values.pop();
            String op = operators.pop();
            values.push(applyOperator(left, right, op));
        }

        return values.pop();
    }

    private static boolean isNumber(String number) {
        return number.matches("\\d+");
    }

    private static boolean isOperator(String operator) {
        return "+-/*".contains(operator);
    }

    private static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    private static Expression applyOperator(Expression left, Expression right, String op) {
        return switch (op) {
            case "+" -> new AddExpression(left, right);
            case "-" -> new SubstractExpression(left, right);
            case "*" -> new MultiplyExpression(left, right);
            case "/" -> new DivideExpression(left, right);
            default -> throw new IllegalArgumentException("Invalid Operator: " + op);
        };
    }
}
