package com.thinking.machines.store.dl.pojo;
import javax.persistence.*;
import java.math.*;
@Entity(name="product")
public class Product
{
@GeneratedValue(strategy=GenerationType.AUTO)
@Id
@Column(name="code")
private Long code;
@Column(name="name")
private String name;
@Column(name="price")
private BigDecimal price;
@Column(name="is_available")
private Boolean isAvailable;
public Product()
{
}
public Product(String name,BigDecimal price,Boolean isAvailable)
{
this.name=name;
this.price=price;
this.isAvailable=isAvailable;
}
public void setCode(java.lang.Long code)
{
this.code=code;
}
public java.lang.Long getCode()
{
return this.code;
}
public void setName(java.lang.String name)
{
this.name=name;
}
public java.lang.String getName()
{
return this.name;
}
public void setPrice(java.math.BigDecimal price)
{
this.price=price;
}
public java.math.BigDecimal getPrice()
{
return this.price;
}
public void setIsAvailable(java.lang.Boolean isAvailable)
{
this.isAvailable=isAvailable;
}
public java.lang.Boolean getIsAvailable()
{
return this.isAvailable;
}

}