package guavadojo;

import java.io.Serializable;
import java.util.Objects;

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
    
    return Objects.hash(name, balance);
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj instanceof Account) {
      Account other = (Account) obj;
      return Objects.equals(this.getName(), other.getName()) && Objects.equals(this.getBalance(), other.getBalance());
    }
    return false;
  }
  
}
