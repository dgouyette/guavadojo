import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static com.google.common.base.Predicates.and;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.trim;
import static org.fest.assertions.Assertions.assertThat;

public class PredicatesTest {


    List<Car> cars = Lists.newArrayList(new Car("ferrari", "red", true), new Car("peugeot", "white", false), new Car("renault", "blue", false));


    private static Predicate<Car> carIsRedPredicate = new Predicate<Car>() {
        @Override
        public boolean apply(Car car) {
            if (car == null || isEmpty(car.getColor())) return false;
            return trim(car.getColor()).equalsIgnoreCase("red");
        }
    };

    private static Predicate<Car> sportCarPredicate = new Predicate<Car>() {
        @Override
        public boolean apply(Car car) {
            if (car == null) return false;
            return car.isSportCar();
        }
    };


    @Test
    public void should_be_true_when_car_is_blue() {
        assertThat(carIsRedPredicate.apply(cars.get(0))).isEqualTo(true);
        assertThat(carIsRedPredicate.apply(cars.get(1))).isEqualTo(false);
    }


    @Test
    public void should_filter_blue_cars() {

        Collection<Car> redCars = Collections2.filter(cars, carIsRedPredicate);

        assertThat(redCars).hasSize(1);
        assertThat(redCars.iterator().next().getColor()).isEqualToIgnoringCase("red");
    }


    @Test
    public void should_filter_red_sports_car() {
        Collection<Car> redSportCars = Collections2.filter(cars, and(carIsRedPredicate, sportCarPredicate));
        assertThat(redSportCars).hasSize(1);

    }


}
