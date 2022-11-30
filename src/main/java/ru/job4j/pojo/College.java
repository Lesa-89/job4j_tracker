package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ларичев Сергей Александрович");
        student.setGroup("11М");
        student.setAdmission(new Date());

        System.out.println("ФИО: " + student.getName() + System.lineSeparator()
                + "Группа: " + student.getGroup() + System.lineSeparator()
                + "Дата поступления: " + student.getAdmission());
    }
}
