import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class TestGarageTest {


    @ParameterizedTest
    @MethodSource("dataTestValidCars")
    void testAddValidCar(String model, int year) {
    }
}