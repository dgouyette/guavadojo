package guavadojo;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

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
