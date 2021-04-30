package com.johnny.java.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class ReferenceAtomicFieldUpdater {

    public static void main(String[] args) {
        AtomicReferenceFieldUpdater<School, Student> updater = AtomicReferenceFieldUpdater.newUpdater(School.class,
                Student.class, "first");

        Student s1 = new Student("s1");
        School school = new School();
        school.setFirst(s1);
        System.out.println("school = " + school);

        Student s2 = new Student("s2");
        updater.compareAndSet(school, s1, s2);
        System.out.println("school = " + school);
    }

    static class School {
        public volatile Student first;

        public void setFirst(Student first) {
            this.first = first;
        }

        @Override
        public String toString() {
            return "School{" +
                    "first=" + first +
                    '}';
        }
    }

    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
