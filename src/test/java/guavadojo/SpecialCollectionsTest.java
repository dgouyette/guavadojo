package guavadojo;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class SpecialCollectionsTest {
  
  private Car car1 = new Car("foo", "blue", true);
  private Car car2 = new Car("bar", "green", false);
  
  @Test
  public void biMap() throws Exception {
    BiMap<String,Car> brandToCar = HashBiMap.create();
    brandToCar.put(car1.getBrand(), car1);
    brandToCar.put(car2.getBrand(), car2);
    
    BiMap<Car,String> carToBrand = brandToCar.inverse();
    assertThat(carToBrand.get(car1)).isEqualTo("foo");
  }
  
  @Test
  public void multiMap() throws Exception {
    Multimap<String,Car> brandToCars = HashMultimap.create();
    brandToCars.put("brand", car1);
    brandToCars.put("brand", car2);
    
    assertThat(brandToCars.get("brand")).isEqualTo(Sets.newHashSet(car1, car2));
  }
}
