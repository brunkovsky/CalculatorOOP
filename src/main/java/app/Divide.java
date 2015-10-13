package app;

public class Divide implements Operations{
    @Override
    /**
     * <p>Операция деления</p>
     *
     * @param a Операнд a
     * @param b Операнд b
     * @return Частное (a / b)
     */
    public double operation(double a, double b) {
        return a / b;
    }
}
