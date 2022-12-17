package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0D;
        List<Label> list = averageScoreByPupil(pupils);
        for (Label label : list) {
            rsl += label.score();
        }
        return rsl / list.size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            rsl.add(new Label(pupil.name(), sum / pupil.subjects().size()));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> scoreBySubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreBySubject.putIfAbsent(subject.name(), 0);
                scoreBySubject.put(subject.name(), scoreBySubject.get(subject.name()) + subject.score());
            }
        }
        for (String key : scoreBySubject.keySet()) {
            rsl.add(new Label(key, scoreBySubject.get(key) / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            rsl.add(new Label(pupil.name(), sum));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> scoreBySubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreBySubject.putIfAbsent(subject.name(), 0);
                scoreBySubject.put(subject.name(), scoreBySubject.get(subject.name()) + subject.score());
            }
        }
        for (String key : scoreBySubject.keySet()) {
            rsl.add(new Label(key, scoreBySubject.get(key)));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }
}
