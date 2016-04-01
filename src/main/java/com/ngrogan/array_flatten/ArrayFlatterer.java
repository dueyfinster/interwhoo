package com.ngrogan.array_flatten;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class ArrayFlatterer {
    private List<Integer> resultArray = new ArrayList<Integer>();

    public List<Integer> flattenNestedArrays(final List<Object> arrays){
        for (Object o : arrays) {
            checkInteger(o);
        }

        return resultArray;
    }

    private void checkInteger(final Object o) {

        if (isArray(o)) {
            for (int i = 0; i < Array.getLength(o); i++) {
                checkInteger(Array.get(o, i));
            }
        } else if (o instanceof Integer) {
            resultArray.add((Integer) o);
        }

    }

    private boolean isArray(final Object obj) {
        return obj != null && obj.getClass().isArray();
    }

}
