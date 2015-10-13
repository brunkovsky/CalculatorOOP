package app;

public class Minus implements Operations{
    @Override
    /**
     * <p>Операция вычитания</p>
     *
     * @param a Операнд a
     * @param b Операнд b
     * @return Разность (a - b)
     */
    public double operation(double a, double b) {
        return a - b;
    }
}
