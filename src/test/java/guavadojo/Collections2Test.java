package guavadojo;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class Collections2Test {
  
  private List<Account> accounts = Lists.newArrayList();
  
  @Before
  public void setup() {
    accounts.add(new Account("bob", -2000));
    accounts.add(new Account("john", 565));
    accounts.add(new Account("Bill", 1000000));
  }
  
  private Function<Account,Account> multiplyBy2Function = new Function<Account,Account>() {
    @Override
    public Account apply(Account input) {
      return new Account(input.getName(), input.getBalance() * 2);
    }
  };
  
  @Test
  public void should_multiply_by_2_balances() {
    List<Account> multipliedAccounts = Lists.newArrayList(Collections2.transform(accounts, multiplyBy2Function));
    assertThat(multipliedAccounts.get(0).getBalance()).isEqualTo(-4000);
    assertThat(multipliedAccounts.get(1).getBalance()).isEqualTo(1130);
    assertThat(multipliedAccounts.get(2).getBalance()).isEqualTo(2000000);
  }
  
}
