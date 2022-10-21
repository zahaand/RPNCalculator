package ru.zahaand;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import sun.awt.geom.AreaOp;

class CalculatorTest {
    @Test
    void returnAnswerToSimpleMathExpression() {
        Calculator calculator = new Calculator();
        double answer = calculator.calculate();
        Assert.assertEquals(10.0, answer);
    }
}
