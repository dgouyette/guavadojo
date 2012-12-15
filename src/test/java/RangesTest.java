import com.google.common.collect.Range;
import com.google.common.collect.Ranges;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RangesTest {


    private Range<Integer> unACent = Ranges.closedOpen(1, 100);


    @Test
    public void range_should_contain_value(){
         assertThat(unACent.contains(45)).isEqualTo(true);
         assertThat(unACent.contains(101)).isEqualTo(false);
    }
}
