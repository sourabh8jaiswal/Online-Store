package com.thinking.machines.store.dl;
import com.thinking.machines.store.dl.pojo.*;
import org.springframework.data.repository.*;
public interface CustomerRepository extends CrudRepository<Customer,Long>
{
public Customer findByEmailId(String emailId);
}