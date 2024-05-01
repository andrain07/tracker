package ru.job4j.hmap;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        return pupils.stream()
                .flatMap(pupil -> pupil.subjects().stream())
                .mapToDouble(Subject::score)
                .average()
                .orElse(0);

    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        return pupils.stream()
                .map(pupil -> new Label(
                        pupil.name(),
                        pupil.subjects().stream()
                                .mapToDouble(Subject::score)
                                .average()
                                .orElse(0)))
                .toList();
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        return pupils.stream()
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.toMap(Subject::name, Subject::score, Integer::sum))
                .entrySet().stream()
                .map(entry -> new Label(entry.getKey(), (double) entry.getValue() / pupils.size()))
                .toList();
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return pupils.stream()
                .map(pupil -> new Label(
                        pupil.name(),
                        pupil.subjects().stream()
                                .mapToDouble(Subject::score)
                                .sum()))
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .findAny()
                .orElse(null);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return pupils.stream()
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.toMap(
                        Subject::name,
                        Subject::score,
                        Integer::sum))
                .entrySet().stream()
                .map(entry -> new Label(entry.getKey(), entry.getValue()))
                .max(Comparator.comparingDouble(Label::score))
                .orElse(null);
    }
}