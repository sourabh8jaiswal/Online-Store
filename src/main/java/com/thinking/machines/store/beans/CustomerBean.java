package com.thinking.machines.store.beans;
import org.springframework.format.annotation.*;
import com.fasterxml.jackson.annotation.*;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerBean implements java.io.Serializable
{
private Long code;
private String name;
private String emailId;
private String password;
@DateTimeFormat(pattern="yyyy-MM-dd")
private java.util.Date dateOfRegistration;
public CustomerBean()
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
public void setEmailId(java.lang.String emailId)
{
this.emailId=emailId;
}
public java.lang.String getEmailId()
{
return this.emailId;
}
public void setPassword(java.lang.String password)
{
this.password=password;
}
public java.lang.String getPassword()
{
return this.password;
}
public void setDateOfRegistration(java.util.Date dateOfRegistration)
{
this.dateOfRegistration=dateOfRegistration;
}
public java.util.Date getDateOfRegistration()
{
return this.dateOfRegistration;
}

}
