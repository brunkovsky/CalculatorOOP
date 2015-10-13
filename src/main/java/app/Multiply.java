package app;

public class Multiply implements Operations{
    @Override
    /**
     * <p>Операция умножения</p>
     *
     * @param a Операнд a
     * @param b Операнд b
     * @return Произведение (a * b)
     */
    public double operation(double a, double b) {
        return a * b;
    }
}
