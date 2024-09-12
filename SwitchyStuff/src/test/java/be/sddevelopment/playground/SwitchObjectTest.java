package be.sddevelopment.playground;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SwitchObjectTest implements WithAssertions {

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -66, -21})
    void negativeAgeThrowsError(int age) {
        assertThatThrownBy(() -> SwitchObject.evaluate(age))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("You might be born yesterday, but you can't be negative years old");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17})
    void isKidBeforeEighteen(int age) {
        var result = SwitchObject.evaluate(age);

        assertThat(result).isEqualTo("kid");
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 19, 20})
    void isAdultAfterEighteen(int age) {
        var result = SwitchObject.evaluate(age);

        assertThat(result).isEqualTo("adult");
    }

    @ParameterizedTest
    @ValueSource(ints = {21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 99, 132})
    void americansCanDrinkAfterTwentyOne(int age) {
        var result = SwitchObject.evaluate(age);

        assertThat(result).isEqualTo("adult can drink");
    }
}