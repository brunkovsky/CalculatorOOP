package app;

public class Plus implements Operations{
    @Override
    /**
     * <p>Операция сложения</p>
     *
     * @param a Операнд a
     * @param b Операнд b
     * @return Сумма (a + b)
     */
    public double operation(double a, double b) {
        return a + b;
    }
}
