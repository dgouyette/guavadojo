package guavadojo;

import static org.fest.assertions.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheTest {
  
  private Car car1 = new Car("foo", "blue", true);
  
  @Test
  public void cache() throws Exception {
    LoadingCache<String,Car> cache = CacheBuilder.newBuilder()//
        .maximumSize(1000)//
        .expireAfterWrite(10, TimeUnit.MINUTES) //
        .build(new CacheLoader<String,Car>() {
          public Car load(String brand) {
            return loadCarByBrand(brand);
          }
        });
    
    assertThat(cache.getUnchecked("foo")).isEqualTo(car1);
  }
  
  private Car loadCarByBrand(String brand) {
    // return carDao.loadCar(brand);
    return car1;
  }
}
