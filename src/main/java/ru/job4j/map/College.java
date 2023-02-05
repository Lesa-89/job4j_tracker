package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .map(Optional::of)
                .filter(Optional::isPresent)
                .filter(s -> s.get().account().equals(account))
                .findFirst()
                .orElse(Optional.empty());
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> a = findByAccount(account);
        if (a.isPresent()) {
            return students.get(a.get())
                    .stream()
                    .map(Optional::of)
                    .filter(Optional::isPresent)
                    .filter(s -> s.get().name().equals(name))
                    .findFirst()
                    .orElse(Optional.empty());
        }
        return Optional.empty();
    }

}
