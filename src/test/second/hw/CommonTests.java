package second.hw;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.stream.Stream;


class CommonTests {

    @ParameterizedTest
    @ArgumentsSource(VehicleArgumentsProvider.class)
    void vehicleSpeed(Vehicle vehicle, int speed) {
        vehicle.testDrive();
        Assertions.assertEquals(vehicle.getSpeed(), speed);
    }
    @ParameterizedTest
    @ArgumentsSource(VehicleArgumentsProvider.class)
    void vehiclePark(Vehicle vehicle) {
        vehicle.testDrive();
        vehicle.park();
        Assertions.assertEquals(vehicle.getSpeed(), 0);
    }

    static class VehicleArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(new Car("Lada", "Largus", 2020), 60),
                    Arguments.of(new Motorcycle("Minsk", "ММВЗ-3.115", 1980), 75)
            );
        }
    }

}