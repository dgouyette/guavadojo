package guavadojo;

import static org.fest.assertions.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Optional;

public class OptionalTest {
  
  public Optional<Integer> stringToInt(String intValue) {
    if (StringUtils.isNumeric(intValue)) {
      return Optional.of(Integer.valueOf(intValue));
    } else {
      return Optional.absent();
    }
  }
  
  @Test
  public void should_return_none_when_non_numeric_value() {
    assertThat(stringToInt("AAA").isPresent()).isFalse();
  }
  
  @Test
  public void should_return_Integer_value_when_numeric_value() {
    assertThat(stringToInt("123").isPresent()).isTrue();
    assertThat(stringToInt("123").get()).isEqualTo(123);
  }
  
}
