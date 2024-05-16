package web.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testQ1_Valid() {
        assertEquals(5.0, MathQuestionService.q1Addition("2", "3"), 0.001);
    }

    @Test
    public void testQ1_NegativeNumbers() {
        assertEquals(-1.0, MathQuestionService.q1Addition("-4", "3"), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ1_OneEmptyInput() {
        MathQuestionService.q1Addition("", "3");
    }

    @Test(expected = NumberFormatException.class)
    public void testQ1_InvalidInputs() {
        MathQuestionService.q1Addition("aa", "bb");
    }

    @Test
    public void testQ2_Valid() {
        assertEquals(-1.0, MathQuestionService.q2Subtraction("2", "3"), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ2_OneEmptyInput() {
        MathQuestionService.q2Subtraction("", "3");
    }

    @Test(expected = NumberFormatException.class)
    public void testQ2_InvalidInputs() {
        MathQuestionService.q2Subtraction("aa", "bb");
    }

    @Test
    public void testQ3_Valid() {
        assertEquals(6.0, MathQuestionService.q3Multiplication("2", "3"), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ3_OneEmptyInput() {
        MathQuestionService.q3Multiplication("", "3");
    }

    @Test(expected = NumberFormatException.class)
    public void testQ3_InvalidInputs() {
        MathQuestionService.q3Multiplication("aa", "bb");
    }
}
