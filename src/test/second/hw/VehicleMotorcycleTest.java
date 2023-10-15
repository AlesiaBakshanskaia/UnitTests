package second.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleMotorcycleTest {
    Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        motorcycle = new Motorcycle("Minsk", "ММВЗ-3.115", 1980);
    }


    /** Проверить, что объект Motorcycle создается с 2-мя колесами. */
    @Test
    void motorcycleHasTwoWheels() {
        Assertions.assertEquals(motorcycle.getNumWheels(), 2);
    }
    /** Проверить, что объект Motorcycle развивает скорость
     * 75 в режиме тестового вождения (используя метод testDrive()). */
    @Test
    void motorcycleSpeedTestMode() {
        motorcycle.testDrive();
        Assertions.assertEquals(motorcycle.getSpeed(), 75);
    }

    /** Проверить, что в режиме парковки (сначала testDrive, потом park,
     * т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
     */
    @Test
    void motorcycleSpeedParkMode() {
        motorcycle.testDrive();
        motorcycle.park();
        Assertions.assertEquals(motorcycle.getSpeed(), 0);
    }
}