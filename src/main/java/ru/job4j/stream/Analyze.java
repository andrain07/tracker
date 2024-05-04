package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(), averageScore(Stream.of(pupil))))
                .toList();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        var subjectsWithAverageScore = stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        Collectors.averagingInt(Subject::score)));
        return subjectsWithAverageScore
                .entrySet()
                .stream()
                .map(entrySet -> new Tuple(entrySet.getKey(), entrySet.getValue()))
                .toList();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(),
                        pupil.subjects()
                                .stream()
                                .mapToInt(Subject::score)
                                .sum()))
                .reduce((left, right) -> left.score() > right.score() ? left : right)
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        var subjectsWithTotalScore = stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        Collectors.summingInt(Subject::score)));
        return subjectsWithTotalScore
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .orElse(null);
    }
}