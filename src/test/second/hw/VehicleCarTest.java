package second.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleCarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Lada", "Largus", 2020);
    }

    /**
     * Проверить, что экземпляр объекта Car также является экземпляром
     * транспортного средства (используя оператор instanceof).
     */
    @Test
    void carHasTypeVehicle() {
        Assertions.assertTrue(car instanceof Vehicle);
    }
    /** Проверить, что объект Car создается с 4-мя колесами. */
    @Test
    void carHasFourWheels() {
        Assertions.assertEquals(car.getNumWheels(), 4);
    }
    /** Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()). */
    @Test
    void carSpeedTestMode() {
        car.testDrive();
        Assertions.assertEquals(car.getSpeed(), 60);
    }

    /** Проверить, что в режиме парковки (сначала testDrive, потом park,
     * т.е. эмуляция движения транспорта) машина останавливается (speed = 0).
     */
    @Test
    void carSpeedParkMode() {
        car.testDrive();
        car.park();
        Assertions.assertEquals(car.getSpeed(), 0);
    }

}