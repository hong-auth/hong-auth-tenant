package com.hong.domain.customer.gateway;

import com.hong.domain.customer.Customer;
import com.hong.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
