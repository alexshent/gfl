package ua.gfl.task01;

public class FunctionValues {
    private final double[] x;
    private final double[] y;

    public FunctionValues(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    public double getX(int i) {
        return x[i];
    }

    public double getY(int i) {
        return y[i];
    }
}
