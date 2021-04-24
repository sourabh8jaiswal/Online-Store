package com.thinking.machines.store.beans;
import java.math.*;
import com.fasterxml.jackson.annotation.*;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductBean implements java.io.Serializable
{
private Long code;
private String name;
private BigDecimal price;
private Boolean isAvailable;
public ProductBean()
{
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