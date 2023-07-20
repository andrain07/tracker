package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddDuplicateCitizen() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen duplicateCitizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        boolean isCitizenExist = office.add(duplicateCitizen);
        assertThat(isCitizenExist).isFalse();
    }
}