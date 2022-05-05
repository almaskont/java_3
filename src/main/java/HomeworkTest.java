import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    @BeforeAll
    static void mainStart() {
        System.out.println("MAIN START");
    }

    @AfterAll
    static void mainEnd() {
        System.out.println("MAIN END");
    }

    @BeforeEach
    void startUp() {
        System.out.println("Test starts");
    }

    @AfterEach
    void shutdown() {
        System.out.println("Test ends");
    }

    @DisplayName("Parametrized test of checking balance")
    @ParameterizedTest
    @MethodSource("dataForBalance")
    void paramTest(int[] a) {
        Assertions.assertTimeout(Duration.ofSeconds(2), () -> {
            Assertions.assertTrue(Homework.checkBalance(a));
        });
    }

    static Stream<Arguments> dataForBalance() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 2, 2, 1, 2, 2, 10, 1}),
                Arguments.arguments(new int[]{1, 1, 1, 2, 1},
                        Arguments.arguments(new int[]{2, 2, 2, 1, 3, 2, 10, 1}),
                        Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1, 1, 1}),
                        Arguments.arguments(new int[]{8, 9, 5, 4, 1, 2, 15, 6})
                ));
    }

    @DisplayName("Parametrized test of checking shifting")
    @ParameterizedTest
    @MethodSource("dataForShift")
    void paramTest(int[] expected, int[] a, int b) {
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            Assertions.assertArrayEquals(expected, Homework.shiftArray(a, b));
        });
    }

    static Stream<Arguments> dataForShift() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 1, 2}, new int[]{1, 2, 3}, 1),
                Arguments.arguments(new int[]{2, 3, 1}, new int[]{1, 2, 3}, 2),
                Arguments.arguments(new int[]{2, 3, 1}, new int[]{1, 2, 3}, -1),
                Arguments.arguments(new int[]{6, 1, 3, 5 }, new int[]{3, 5, 6, 1}, -2),
                Arguments.arguments(new int[]{3, 1, 2}, new int[]{1, 2, 3}, 1000)
        );
    }
}