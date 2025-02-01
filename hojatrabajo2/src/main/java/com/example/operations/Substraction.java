package com.example.operations;

import com.example.utils.Logger;

public class Substraction<T extends Number>  implements Operation<T>{
    private static Logger log = Logger.getInstance();
    @SuppressWarnings("unchecked") //Remove this if in the future we use something else than just an int.
    @Override
    public T execute(T n, T m) {
        if (n instanceof Integer && m instanceof Integer) {
            return (T) Integer.valueOf(n.intValue() - m.intValue());
        } 
        //Use an elseif to add other data types, for now we only support integers 
        else {
            log.logUnsupportedOperation(Number.class);
            throw new UnsupportedOperationException();
        }
    }
}
