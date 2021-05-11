package com.johnny.java.lang.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakReferenceTest {

    public static void main(String[] args) throws Exception {
        ReferenceQueue<Person> q = new ReferenceQueue<>();
        Person p = new Person("aaa");
        Person p1 = new Person("bbb");
        WeakReference<Person> test = new WeakReference<>(p, q);
        WeakReference<Person> test1 = new WeakReference<>(p1, q);

        System.out.println("=======before======");
        System.out.println("test reference = " + test);
        System.out.println("test1 reference = " + test1);
        System.out.println("test referent = " + test.get());
        System.out.println("test1 referent = " + test1.get());
        System.out.println("=======before======");

        List<byte[]> bytes = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            byte[] bytes1 = new byte[1024 * 1024];
            bytes.add(bytes1);
        }

        System.out.println("=======after======");
        System.out.println("test reference = " + test);
        System.out.println("test1 reference = " + test1);
        System.out.println("test referent = " + test.get());
        System.out.println("test1 referent = " + test1.get());
        System.out.println("=======after======");

        while (true) {
            WeakReference<Person> reference = (WeakReference<Person>) q.poll();
            if (reference != null) {
                System.out.println(reference);
                break;
            }
        }
        Thread.sleep(100000000);
    }


    protected static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("name = " + name + ", finalize");
        }
    }

}
