package com.example.operations;

import com.example.utils.Logger;

public class Modulus implements Operation {
    private static final Logger log = Logger.getInstance();


@Override
public int execute(int n, int m) {
    try {
    return (int) (n % m);
    } catch (Exception e) {
        log.logUnsupportedOperation(Number.class);
        throw new UnsupportedOperationException();
    }
}




    /**
 * Performs modulus operation on two given numbers and returns the result.
 *
 * @param n the dividend
 * @param m the divisor
 * @return the result of the modulus operation
 * @throws UnsupportedOperationException if the given numbers are not integers
 */

    // @SuppressWarnings("unchecked") //Remove this if in the future we use something else than just an int.
    // @Override
    // public T execute(T n, T m) {
    //     if (n instanceof Integer && m instanceof Integer) {
    //         return (T) Integer.valueOf(n.intValue() % m.intValue());
    //     } 
    //     //Use an elseif to add other data types, for now we only support integers 
    //     else {
    //         log.logUnsupportedOperation(Number.class);
    //         throw new UnsupportedOperationException();
    //     }   
    
    // }
}
