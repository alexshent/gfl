package ua.gfl.task01;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void functionXisOne() {
        // given
        double a = -0.5;
        double b = 2.0;
        double x = 1.0;
        double expected = 0.0;
        double delta = 0.000001;
        // when
        double actual = Main.function(x, a, b);
        // then
        assertEquals(expected, actual, delta);
    }

    @org.junit.jupiter.api.Test
    void functionXisZero() {
        // given
        double a = -0.5;
        double b = 2.0;
        double x = 0.0;
        double expected = 1.0;
        double delta = 0.000001;
        // when
        double actual = Main.function(x, a, b);
        // then
        assertEquals(expected, actual, delta);
    }

    @org.junit.jupiter.api.Test
    void stepsXisFromZeroToThree() {
        // given
        double a = -0.5;
        double b = 2.0;
        double start = 0.0;
        double end = 3.0;
        double stepDelta = 0.004;
        int expected = 751;
        // when
        int actual = Main.steps(stepDelta, start, end);
        // then
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void stepsXisFromOneToFive() {
        // given
        double a = -0.5;
        double b = 2.0;
        double start = 1.0;
        double end = 5.0;
        double stepDelta = 0.004;
        int expected = 1001;
        // when
        int actual = Main.steps(stepDelta, start, end);
        // then
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void functionValuesIndex175() {
        // given
        double a = -0.5;
        double b = 2.0;
        double start = 0.0;
        double end = 3.0;
        double stepDelta = 0.004;
        int index = 175;
        double expectedX = 0.700000;
        double expectedY = 0.087385;
        double delta = 0.000001;
        // when
        FunctionValues actual = Main.functionValues(stepDelta, start, end, a, b);
        double actualX = actual.getX(index);
        double actualY = actual.getY(index);
        // then
        assertEquals(expectedX, actualX, delta);
        assertEquals(expectedY, actualY, delta);
    }

    @org.junit.jupiter.api.Test
    void functionValuesIndex350() {
        // given
        double a = -0.5;
        double b = 2.0;
        double start = 0.0;
        double end = 3.0;
        double stepDelta = 0.004;
        int index = 350;
        double expectedX = 1.400000;
        double expectedY = -0.467893;
        double delta = 0.000001;
        // when
        FunctionValues actual = Main.functionValues(stepDelta, start, end, a, b);
        double actualX = actual.getX(index);
        double actualY = actual.getY(index);
        // then
        assertEquals(expectedX, actualX, delta);
        assertEquals(expectedY, actualY, delta);
    }

    @org.junit.jupiter.api.Test
    void functionValuesIndex750() {
        // given
        double a = -0.5;
        double b = 2.0;
        double start = 0.0;
        double end = 3.0;
        double stepDelta = 0.004;
        int index = 750;
        double expectedX = 3.000000;
        double expectedY = 0.214242;
        double delta = 0.000001;
        // when
        FunctionValues actual = Main.functionValues(stepDelta, start, end, a, b);
        double actualX = actual.getX(index);
        double actualY = actual.getY(index);
        // then
        assertEquals(expectedX, actualX, delta);
        assertEquals(expectedY, actualY, delta);
    }

    @org.junit.jupiter.api.Test
    void indexOfMaximumFunctionValue() {
        // given
        double a = -0.5;
        double b = 2.0;
        double start = 0.0;
        double end = 3.0;
        double stepDelta = 0.004;
        int expected = 0;
        // when
        int actual = Main.indexOfMaximumFunctionValue(stepDelta, start, end, a, b);
        // then
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void indexOfMinimumFunctionValue() {
        // given
        double a = -0.5;
        double b = 2.0;
        double start = 0.0;
        double end = 3.0;
        double stepDelta = 0.004;
        int expected = 362;
        // when
        int actual = Main.indexOfMinimumFunctionValue(stepDelta, start, end, a, b);
        // then
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void sumOfFunctionValues() {
        // given
        double a = -0.5;
        double b = 2.0;
        double start = 0.0;
        double end = 3.0;
        double stepDelta = 0.004;
        double expected = 117.892889;
        double delta = 0.000001;
        // when
        double actual = Main.sumOfFunctionValues(stepDelta, start, end, a, b);
        // then
        assertEquals(expected, actual, delta);
    }

    @org.junit.jupiter.api.Test
    void meanOfFunctionValues() {
        // given
        double a = -0.5;
        double b = 2.0;
        double start = 0.0;
        double end = 3.0;
        double stepDelta = 0.004;
        double expected = 0.156981;
        double delta = 0.000001;
        // when
        double actual = Main.meanOfFunctionValues(stepDelta, start, end, a, b);
        // then
        assertEquals(expected, actual, delta);
    }
}