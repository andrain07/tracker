package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {
    @Test
    public void whenFactorial0ThenEx() {
        Fact fact = new Fact();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> fact.calc(-1));
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    public void whenFactorial1Then1() {
        int num = 1;
        int expected = 1;
        int actual = new Fact().calc(num);
        assertThat(actual).isEqualTo(expected);
    }
}