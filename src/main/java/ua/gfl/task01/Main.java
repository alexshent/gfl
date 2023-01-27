package ua.gfl.task01;

public class Main {
    public static double function(double x, double a, double b) {
        double result;
        if (x <= 0.7) {
            result = 1.0;
        } else if (x > 0.7 && x <= 1.4) {
            result = a * x * x * Math.log(x);
        } else {
            result = Math.pow(Math.E, a * x) * Math.cos(b * x);
        }
        return result;
    }

    public static int steps(double stepDelta, double start, double end) {
        double delta = 0.000001;
        int stepsCounter = 1;
        double currentStepValue = start;
        while (Math.abs(currentStepValue - end) > delta) {
            currentStepValue += stepDelta;
            stepsCounter ++;
        }
        return stepsCounter;
    }

    public static FunctionValues functionValues(double stepDelta, double start, double end, double a, double b) {
        int steps = steps(stepDelta, start, end);
        double[] xArray = new double[steps];
        double[] yArray = new double[steps];
        double x = start;
        for (int i = 0; i < steps; i ++) {
            xArray[i] = x;
            yArray[i] = function(x, a, b);
            x += stepDelta;
        }
        return new FunctionValues(xArray, yArray);
    }

    public static int indexOfMaximumFunctionValue(double stepDelta, double start, double end, double a, double b) {
        double maximumFunctionValue;
        int indexOfMaximumFunctionValue;
        int steps = steps(stepDelta, start, end);
        FunctionValues functionValues = functionValues(stepDelta, start, end, a, b);
        indexOfMaximumFunctionValue = 0;
        maximumFunctionValue = functionValues.getY(indexOfMaximumFunctionValue);
        for (int i = 0; i < steps; i ++) {
            if (functionValues.getY(i) > maximumFunctionValue) {
                maximumFunctionValue = functionValues.getY(i);
                indexOfMaximumFunctionValue = i;
            }
        }
        return indexOfMaximumFunctionValue;
    }

    public static int indexOfMinimumFunctionValue(double stepDelta, double start, double end, double a, double b) {
        double minimumFunctionValue;
        int indexOfMinimumFunctionValue;
        int steps = steps(stepDelta, start, end);
        FunctionValues functionValues = functionValues(stepDelta, start, end, a, b);
        indexOfMinimumFunctionValue = 0;
        minimumFunctionValue = functionValues.getY(indexOfMinimumFunctionValue);
        for (int i = 0; i < steps; i ++) {
            if (functionValues.getY(i) < minimumFunctionValue) {
                minimumFunctionValue = functionValues.getY(i);
                indexOfMinimumFunctionValue = i;
            }
        }
        return indexOfMinimumFunctionValue;
    }

    public static double sumOfFunctionValues(double stepDelta, double start, double end, double a, double b) {
        double sum = 0.0;
        int steps = steps(stepDelta, start, end);
        FunctionValues functionValues = functionValues(stepDelta, start, end, a, b);
        for (int i = 0; i < steps; i ++) {
            sum += functionValues.getY(i);
        }
        return sum;
    }

    public static double meanOfFunctionValues(double stepDelta, double start, double end, double a, double b) {
        double sum = sumOfFunctionValues(stepDelta, start, end, a, b);
        int steps = steps(stepDelta, start, end);
        return sum / steps;
    }

    public static void printMax(double stepDelta, double start, double end, double a, double b) {
        FunctionValues functionValues = functionValues(stepDelta, start, end, a, b);
        int index = indexOfMaximumFunctionValue(stepDelta, start, end, a, b);
        double x = functionValues.getX(index);
        double y = functionValues.getY(index);
        String string = String.format("""
                MAX
                i=%d
                x=%f
                y=%f
                """, index, x, y);
        System.out.print(string);
    }

    public static void printMin(double stepDelta, double start, double end, double a, double b) {
        FunctionValues functionValues = functionValues(stepDelta, start, end, a, b);
        int index = indexOfMinimumFunctionValue(stepDelta, start, end, a, b);
        double x = functionValues.getX(index);
        double y = functionValues.getY(index);
        String string = String.format("""
                MIN
                i=%d
                x=%f
                y=%f
                """, index, x, y);
        System.out.print(string);
    }

    public static void printSum(double stepDelta, double start, double end, double a, double b) {
        double sum = sumOfFunctionValues(stepDelta, start, end, a, b);
        String string = String.format("""
                SUM
                sum=%f
                """, sum);
        System.out.print(string);
    }

    public static void printMean(double stepDelta, double start, double end, double a, double b) {
        double mean = meanOfFunctionValues(stepDelta, start, end, a, b);
        String string = String.format("""
                MEAN
                mean=%f
                """, mean);
        System.out.print(string);
    }

    public static void printSeparator() {
        final String separator = "--------------";
        System.out.println(separator);
    }

    public static void main(String[] args) {
        final double a = -0.5;
        final double b = 2.0;
        final double start = 0.0;
        final double end = 3.0;
        final double stepDelta = 0.004;

        printMax(stepDelta, start, end, a, b);
        printSeparator();
        printMin(stepDelta, start, end, a, b);
        printSeparator();
        printSum(stepDelta, start, end, a, b);
        printSeparator();
        printMean(stepDelta, start, end, a, b);
    }
}
