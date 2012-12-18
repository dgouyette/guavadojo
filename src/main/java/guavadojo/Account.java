package guavadojo;

import com.google.common.base.Objects;

import java.io.Serializable;

public class Account implements Serializable {
  
  private String name;
  
  private int balance;
  
  public Account(String name, int balance) {
    this.name = name;
    this.balance = balance;
  }
  
  public String getName() {
    return name;
  }
  
  public int getBalance() {
    return balance;
  }
  
  @Override
  public int hashCode() {
    // Default generated code (eclipse :)
    
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + balance;
    // result = prime * result + ((name == null) ? 0 : name.hashCode());
    // return result;
    
    return Objects.hashCode(name, balance);
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj instanceof Account) {
      Account other = (Account) obj;
      return Objects.equal(this.getName(), other.getName()) && Objects.equal(this.getBalance(), other.getBalance());
    }
    return false;
  }
  
}
