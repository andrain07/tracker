package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenComparatorByName() {
        var jobAscByName = new JobAscByName();
        int actual = jobAscByName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(actual).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameDesc() {
        var jobAscByName = new JobDescByName();
        int actual = jobAscByName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(actual).isLessThan(0);
    }    @Test
    public void whenComparatorByPriority() {
        var jobAscByName = new JobAscByPriority();
        int actual = jobAscByName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(actual).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        var jobAscByName = new JobDescByPriority();
        int actual = jobAscByName.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 0)
        );
        assertThat(actual).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityDescAndNameDesc() {
        var jobAscByName = new JobDescByPriority().thenComparing(new JobDescByName());
        int actual = jobAscByName.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(actual).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityDesc() {
        var jobAscByName = new JobAscByName().thenComparing(new JobDescByPriority());
        int actual = jobAscByName.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 1)
        );
        assertThat(actual).isEqualTo(0);
    }
}