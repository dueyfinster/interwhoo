package com.ngrogan.customer_distance;

import java.util.Comparator;

import com.ngrogan.customer_distance.model.Customer;

public class CustomerComparator  implements Comparator<Customer> {
    
    @Override
    public int compare(final Customer c1, final Customer c2) {
        final int c1id = c1.getUserId();
        final int c2id =  c2.getUserId();

        if(c1id > c2id){
            return 1;
        }else if(c1id == c2id){
            return 0;
        } else {
            return -1;
        }
    }
}
