package app;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.addOperation(new Calculator.Divide(), ':');          // так можно добавлять знаки для существующих операций
        calculator.addOperation(new Calculator.Multiply(), 'x');        // так можно добавлять знаки для существующих операций
        calculator.addOperation(new Calculator.Operations() {
            @Override
            public double operation(double a, double b) {
                return Math.pow(a, b);
            }
        }, '^');// так можно добавлять новых операции

        calculator.runCalculator();
    }
}
