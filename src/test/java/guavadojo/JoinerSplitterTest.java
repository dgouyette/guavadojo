package guavadojo;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;

public class JoinerSplitterTest {
  
  List<String> countries = newArrayList("FRANCE", "UNITED-STATES", "BELGIUM", "SPAIN");
  
  String brandsCar = "Ferrari,Renault,Peugeot,Opel";
  
  @Test
  public void should_return_csv_format() {
    assertThat(Joiner.on(";").join(countries)).isEqualTo("FRANCE;UNITED-STATES;BELGIUM;SPAIN");
  }
  
  @Test
  public void should_return_brand_list_string() {
    List<String> expectedResult = newArrayList("Ferrari", "Renault", "Peugeot", "Opel");
    
    assertThat(newArrayList(Splitter.on(",").split(brandsCar))).isEqualTo(expectedResult);
  }
  
}
