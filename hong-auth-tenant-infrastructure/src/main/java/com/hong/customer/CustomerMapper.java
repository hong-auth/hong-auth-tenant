package com.hong.customer;

//import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface CustomerMapper{

  public CustomerDO getById(String customerId);
}
