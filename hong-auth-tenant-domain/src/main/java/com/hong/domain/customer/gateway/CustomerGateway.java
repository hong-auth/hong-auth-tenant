package com.hong.domain.customer.gateway;

import com.hong.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
