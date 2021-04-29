package com.johnny.core.lang.classloader;

public class ClassLoaders {
    public static void main(String[] args) throws Exception {
        System.out.println("aaa");
        System.out.println("java.ext.path = " + System.getProperty("java.ext.dirs"));
        System.out.println("aaa");
        ClassLoader loader = ClassLoaders.class.getClassLoader();
        Class<?> personClass = loader.loadClass("java.security.KeyStore$Builder$FileBuilder$1");
        test();
    }

    private static void test() {
        int[] array = new int[3];
        ClassLoader arrayClassLoader = array.getClass().getClassLoader();
        System.out.println(arrayClassLoader);

        Person[] persons = new Person[3];
        ClassLoader personsClassLoader = persons.getClass().getClassLoader();
        ClassLoader personClassLoader = Person.class.getClassLoader();
        System.out.println(personClassLoader == personsClassLoader);

    }

    public static class Person {
        public String name;
    }
}
