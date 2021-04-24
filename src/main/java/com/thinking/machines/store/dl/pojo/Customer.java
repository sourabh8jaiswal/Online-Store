package com.thinking.machines.store.dl.pojo;
import javax.persistence.*;
import org.springframework.format.annotation.*;
@Entity(name="customer")
public class Customer
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="code")
private Long code;
@Column(name="name")
private String name;
@Column(name="email_id",unique=true)
private String emailId;
@Column(name="password")
private String password;
@Column(name="password_key")
private String passwordKey;
@Column(name="date_of_registration")
private java.sql.Date dateOfRegistration;
public Customer()
{
}
public Customer(String name,String emailId,String password,String passwordKey,java.sql.Date dateOfRegistration)
{
this.name=name;
this.emailId=emailId;
this.password=password;
this.passwordKey=passwordKey;
this.dateOfRegistration=dateOfRegistration;
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
public void setPasswordKey(java.lang.String passwordKey)
{
this.passwordKey=passwordKey;
}
public java.lang.String getPasswordKey()
{
return this.passwordKey;
}
public void setDateOfRegistration(java.sql.Date dateOfRegistration)
{
this.dateOfRegistration=dateOfRegistration;
}
public java.sql.Date getDateOfRegistration()
{
return this.dateOfRegistration;
}

}
