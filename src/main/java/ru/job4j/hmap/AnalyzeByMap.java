package ru.job4j.hmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        int subjectsCount = 0;
        for (Pupil pupil : pupils) {
            subjectsCount += pupil.subjects().size();
            for (Subject subjects : pupil.subjects()) {

                totalScore += subjects.score();
            }
        }
        return totalScore / subjectsCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> pupilLabels = new ArrayList<>();
        double totalSubjectsScore;
        for (Pupil pupil : pupils) {
            totalSubjectsScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalSubjectsScore += subject.score();
            }
            pupilLabels.add(new Label(pupil.name(), totalSubjectsScore / pupil.subjects().size()));
        }
        return pupilLabels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> subjectLabels = new ArrayList<>();
        var subjectByTotalScore = new LinkedHashMap<String, Integer>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (subjectByTotalScore.containsKey(subject.name())) {
                    subjectByTotalScore.put(
                            subject.name(),
                            subject.score() + subjectByTotalScore.get(subject.name())
                    );
                } else {
                    subjectByTotalScore.put(subject.name(), subject.score());
                }
            }
        }
        for (var stringIntegerEntry : subjectByTotalScore.entrySet()) {
            subjectLabels.add(
                    new Label(
                            stringIntegerEntry.getKey(),
                            (double) stringIntegerEntry.getValue() / pupils.size()
                    )
            );
        }
        return subjectLabels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        var pupilLabels = new ArrayList<Label>();
        double totalScore;
        for (Pupil pupil : pupils) {
            totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            pupilLabels.add(new Label(pupil.name(), totalScore));
        }
        pupilLabels.sort(Comparator.naturalOrder());
        return pupilLabels.get(pupilLabels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        var subjectLabels = new ArrayList<Label>();
        var subjectByTotalScore = new LinkedHashMap<String, Integer>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (subjectByTotalScore.containsKey(subject.name())) {
                    subjectByTotalScore.put(
                            subject.name(),
                            subject.score() + subjectByTotalScore.get(subject.name())
                    );
                } else {
                    subjectByTotalScore.put(subject.name(), subject.score());
                }
            }
        }
        for (var subjectByTotalScoreEntry : subjectByTotalScore.entrySet()) {
            subjectLabels.add(
                    new Label(
                            subjectByTotalScoreEntry.getKey(),
                            subjectByTotalScoreEntry.getValue()
                    )
            );
        }
        subjectLabels.sort(Comparator.naturalOrder());
        return subjectLabels.get(subjectLabels.size() - 1);
    }
}