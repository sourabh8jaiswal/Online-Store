package com.thinking.machines.store.services;
import com.thinking.machines.store.dl.*;
import com.thinking.machines.store.dl.pojo.*;
import com.thinking.machines.store.beans.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Controller
public class CustomerService
{
@Autowired
private CustomerRepository customerRepository;

@ResponseBody
@PostMapping("/customer/add")
public CustomerBean add(CustomerBean customerBean)
{
String name=customerBean.getName();
String emailId=customerBean.getEmailId();
String password=customerBean.getPassword();
String passwordKey=java.util.UUID.randomUUID().toString().replaceAll("-","d");
String encryptedPassword=password; // as now we are not encrypting
java.util.Date utilDateOfRegistration=customerBean.getDateOfRegistration();
java.sql.Date sqlDateOfRegistration=new java.sql.Date(utilDateOfRegistration.getYear(),utilDateOfRegistration.getMonth(),utilDateOfRegistration.getDate());

Customer customer=new Customer(name,emailId,encryptedPassword,passwordKey,sqlDateOfRegistration);
customerRepository.save(customer);
customerBean.setCode(customer.getCode());
customerBean.setPassword(null);
return customerBean;
}

@ResponseBody
@PostMapping("/customer/update")
public CustomerBean update(CustomerBean customerBean)
{
String name=customerBean.getName();
String emailId=customerBean.getEmailId();
String password=customerBean.getPassword();
String passwordKey=java.util.UUID.randomUUID().toString().replaceAll("-","d");
String encryptedPassword=password; // as now we are not encrypting
java.util.Date utilDateOfRegistration=customerBean.getDateOfRegistration();
java.sql.Date sqlDateOfRegistration=new java.sql.Date(utilDateOfRegistration.getYear(),utilDateOfRegistration.getMonth(),utilDateOfRegistration.getDate());

Customer customer=new Customer(name,emailId,encryptedPassword,passwordKey,sqlDateOfRegistration);
customer.setCode(customerBean.getCode());
customerRepository.save(customer);
customerBean.setCode(customer.getCode());
customerBean.setPassword(null);
return customerBean;
}


@ResponseBody
@PostMapping("/customer/delete")
public Boolean delete(@RequestParam("code") Long code)
{
if(!exists(code)) return false;
customerRepository.deleteById(code);
return true;
}

@ResponseBody
@GetMapping("/customer/getAll")
public List<CustomerBean> getAll()
{
List<CustomerBean> customers=new ArrayList<>();
java.util.Date utilDate=null;
java.sql.Date sqlDate=null;
for(Customer customer:customerRepository.findAll())
{
CustomerBean customerBean=new CustomerBean();
customerBean.setCode(customer.getCode());
customerBean.setName(customer.getName());
customerBean.setEmailId(customer.getEmailId());
sqlDate=customer.getDateOfRegistration();
utilDate=new java.util.Date(sqlDate.getYear(),sqlDate.getMonth(),sqlDate.getDate());
customerBean.setDateOfRegistration(utilDate);
customers.add(customerBean);
}
return customers;
}



@ResponseBody
@GetMapping("/customer/getByCode")
public CustomerBean getByCode(@RequestParam("code") Long code)
{
Customer customer=null;
Optional<Customer> customerResult=customerRepository.findById(code);
if(customerResult.isPresent()) customer=customerResult.get();
else return null;
CustomerBean customerBean=new CustomerBean();
customerBean.setCode(customer.getCode());
customerBean.setName(customer.getName());
customerBean.setEmailId(customer.getEmailId());
java.sql.Date sqlDate=customer.getDateOfRegistration();
java.util.Date utilDate=new java.util.Date(sqlDate.getYear(),sqlDate.getMonth(),sqlDate.getDate());
customerBean.setDateOfRegistration(utilDate);
return customerBean;
}

@ResponseBody
@GetMapping("/customer/getByEmailId")
public CustomerBean getCustomerByEmailId(@RequestParam("emailId")String emailId)
{
Customer customer=customerRepository.findByEmailId(emailId);
if(customer==null) return null;
java.sql.Date sqlDateOfRegistration=customer.getDateOfRegistration();
java.util.Date utilDateOfRegistration=new java.util.Date(sqlDateOfRegistration.getYear(),sqlDateOfRegistration.getMonth(),sqlDateOfRegistration.getDate());
CustomerBean customerBean=new CustomerBean();
customerBean.setCode(customer.getCode());
customerBean.setName(customer.getName());
customerBean.setEmailId(customer.getEmailId());
java.sql.Date sqlDate=customer.getDateOfRegistration();
java.util.Date utilDate=new java.util.Date(sqlDate.getYear(),sqlDate.getMonth(),sqlDate.getDate());
customerBean.setDateOfRegistration(utilDate);
return customerBean;
}

@ResponseBody
@GetMapping("/customer/exists")
public Boolean exists(@RequestParam("code") Long code)
{
return customerRepository.existsById(code);
}

@ResponseBody
@GetMapping("/customer/count")
public Long count()
{
return customerRepository.count();
}
}