package com.johnny.core.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

//similar AtomicLongFieldUpdater & AtomicReferenceFieldUpdater
public class IntegerFieldDemo {

    public static void main(String[] args) {
        Person p1 = new Person(1, "yang");

        AtomicIntegerFieldUpdater<Person> updater = AtomicIntegerFieldUpdater
                .newUpdater(Person.class, "age");

        updater.compareAndSet(p1, 1, 3);

        System.out.println(p1.age);
    }

    static class Person {

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public volatile int age;
        private String name;

    }

}
