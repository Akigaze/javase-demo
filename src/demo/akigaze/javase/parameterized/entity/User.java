package demo.akigaze.javase.parameterized.entity;

import java.util.Date;

public class User {
  private String id;
  private String name;
  private String password;
  private boolean deleted;
  private Date createdTime;
  private Date updatedTime;

  public User() {
  }

  public User(String id, String name, String password, boolean deleted, Date createdTime, Date updatedTime) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.deleted = deleted;
    this.createdTime = createdTime;
    this.updatedTime = updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
