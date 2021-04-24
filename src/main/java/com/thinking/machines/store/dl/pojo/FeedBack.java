package com.thinking.machines.store.dl.pojo;
import javax.persistence.*;
@Entity(name="feed_back")
public class FeedBack
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private Long id;
@Column(name="given_on")
private java.sql.Date givenOn;
@ManyToOne
@JoinColumn(name="product_code",referencedColumnName="code")
private Product product;
@ManyToOne
@JoinColumn(name="customer_code",referencedColumnName="code")
private Customer customer;
@Column(name="feed_back")
private String feedBack;
public FeedBack()
{
}
public FeedBack(java.sql.Date givenOn,Product product,Customer customer,String feedBack)
{
this.givenOn=givenOn;
this.product=product;
this.customer=customer;
this.feedBack=feedBack;
}
public void setId(Long id)
{
this.id=id;
}
public Long getId()
{
return this.id;
}
public void setGivenOn(java.sql.Date givenOn)
{
this.givenOn=givenOn;
}
public java.sql.Date getGivenOn()
{
return this.givenOn;
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
public void setFeedBack(String feedBack)
{
this.feedBack=feedBack;
}
public String getFeedBack()
{
return this.feedBack;
}
}