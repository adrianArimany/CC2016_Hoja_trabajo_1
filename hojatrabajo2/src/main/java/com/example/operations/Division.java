package com.example.operations;

import com.example.utils.Logger;

public class Division<T extends Number> implements Operation<T>{
    private static final Logger log = Logger.getInstance();
    
    /**
     * Performs division on two given numbers and returns the result.
     * 
     * If the result of the division is not an integer, a warning is logged and the result is rounded down to the nearest integer.
     * 
     * @param n the dividend
     * @param m the divisor
     * @return the result of the division
     * @throws ArithmeticException if the divisor is zero
     * @throws UnsupportedOperationException if the given numbers are not integers
     */
    @SuppressWarnings("unchecked") //Remove this if in the future we use something else than just an int.
    @Override
    public T execute(T n, T m) {
        // Check for division by zero
        if (m.intValue() == 0) {
            log.logWarning("Division by zero attempt: " + n + " / " + m);
            throw new ArithmeticException("Cannot divide by zero");
        }

        if (n instanceof Integer && m instanceof Integer) {
            int result = n.intValue() / m.intValue();
            int remainder = n.intValue() % m.intValue();
            if (remainder != 0) {
                log.logWarning("Non-integer division result, using integer part only: " + result);
            }
            return (T) Integer.valueOf(result);
        }
        // Use an elseif to add other data types, for now we only support integers 
        else {
            log.logUnsupportedOperation(Number.class);
            throw new UnsupportedOperationException();
        }
    }
    
}
