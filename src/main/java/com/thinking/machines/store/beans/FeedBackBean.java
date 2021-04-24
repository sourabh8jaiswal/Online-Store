package com.thinking.machines.store.beans;
import org.springframework.format.annotation.*;
import com.thinking.machines.store.dl.pojo.*;
import com.fasterxml.jackson.annotation.*;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedBackBean implements java.io.Serializable
{
private Long id;
@DateTimeFormat(pattern="yyyy-MM-dd")
private java.util.Date givenOn;
private Long productCode;
private Long customerCode;
private String feedBack;
private Product product;
private Customer customer;
public FeedBackBean()
{
}
public void setId(Long id)
{
this.id=id;
}
public Long getId()
{
return this.id;
}
public void setGivenOn(java.util.Date givenOn)
{
this.givenOn=givenOn;
}
public java.util.Date getGivenOn()
{
return this.givenOn;
}
public void setProductCode(Long productCode)
{
this.productCode=productCode;
}
public Long getProductCode()
{
return this.productCode;
}
public void setCustomerCode(Long customerCode)
{
this.customerCode=customerCode;
}
public Long getCustomerCode()
{
return this.customerCode;
}
public void setFeedBack(String feedBack)
{
this.feedBack=feedBack;
}
public String getFeedBack()
{
return this.feedBack;
}
public void setProduct(Product product)
{
this.product=product;
}
public Product getProduct()
{
return this.product;
}
public void setCustomer(Customer customer)
{
this.customer=customer;
}
public Customer getCustomer()
{
return this.customer;
}
}