package web.service;

public class MathQuestionService {

    /**
     * Calculate Q1 result.
     *
     * @param number1
     * @param number2
     * @return
     * @throws NumberFormatException if either number1 or number2 is not a valid number
     */
    public static double q1Addition(String number1, String number2) throws NumberFormatException {
        if (number1.isEmpty() || number2.isEmpty()) {
            throw new IllegalArgumentException("Empty input");
        }
        double result = Double.parseDouble(number1) + Double.parseDouble(number2);
        return result;
    }

    /**
     * Calculate Q2 result.
     *
     * @param number1
     * @param number2
     * @return
     * @throws NumberFormatException if either number1 or number2 is not a valid number
     */
    public static double q2Subtraction(String number1, String number2) throws NumberFormatException {
        if (number1.isEmpty() || number2.isEmpty()) {
            throw new IllegalArgumentException("Empty input");
        }
        double result = Double.parseDouble(number1) - Double.parseDouble(number2);
        return result;
    }

    /**
     * Calculate Q3 result.
     *
     * @param number1
     * @param number2
     * @return
     * @throws NumberFormatException if either number1 or number2 is not a valid number
     */
    public static double q3Multiplication(String number1, String number2) throws NumberFormatException {
        if (number1.isEmpty() || number2.isEmpty()) {
            throw new IllegalArgumentException("Empty input");
        }
        double result = Double.parseDouble(number1) * Double.parseDouble(number2);
        return result;
    }
}

