package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.Validator;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        Validator.validateIsDuplicate(getCarNames(cars));

        this.cars = cars;
    }

    private List<String> getCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> findWinner() {
        Car maxDistanceCar = cars.stream()
                .max(Car::compareTo)
                .orElse(cars.get(0));

        return cars.stream()
                .filter(car -> car.isWinner(maxDistanceCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }


    public void tryToMoveCars() {
        for (Car car : cars) {
            car.moveOrStay();
        }
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public List<String> getCarsNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}