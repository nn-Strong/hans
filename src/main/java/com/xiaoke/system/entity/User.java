package com.xiaoke.system.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends BaseEntity{

  @Id
  private long id;
  private String name;
  private String mob;
  private String email;
  private long valid;
  private String pticket;
  private long roleId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getMob() {
    return mob;
  }

  public void setMob(String mob) {
    this.mob = mob;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public long getValid() {
    return valid;
  }

  public void setValid(long valid) {
    this.valid = valid;
  }


  public String getPticket() {
    return pticket;
  }

  public void setPticket(String pticket) {
    this.pticket = pticket;
  }


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }



  public User() {
  }
}
