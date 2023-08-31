package com.bmo.reflection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Introduction {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;

        Map<String, Integer> mapObject = new HashMap<>();
        Class<?> hashMapClass = mapObject.getClass();

        Class<?> squareClass = Class.forName("com.bmo.reflection.Introduction$Square");

        printClassInfo(stringClass, hashMapClass, squareClass);

        var circleObject = new Drawable() {
            @Override
            public int numberOfCorners() {
                return 0;
            }
        };

        printClassInfo(Collection.class, boolean.class, int [][].class, Color.class, circleObject.getClass());
    }
    private static void printClassInfo(Class<?> ... classes) {
        for (Class<?> clazz : classes) {
            System.out.println(String.format(
                    "class name %s - class package name %s", clazz.getSimpleName(), clazz.getPackageName()
            ));

            if (clazz.isInterface()) {
                Class<?> superclass = clazz.getSuperclass();
                if (superclass != null)
                    System.out.println(String.format("super class %s of class %s", superclass.getSimpleName(), clazz.getSimpleName()));
            }

            Class<?>[] clazzInterfaces = clazz.getInterfaces();

            String[] x = new String[clazzInterfaces.length];

            for (Class<?> interfaceImplemented : clazzInterfaces) {
                System.out.println(
                        String.format("class %s implements %s", clazz.getSimpleName(), interfaceImplemented.getSimpleName())
                );
            }

//            if (clazz.getPackageName().contains("com.sun") || clazz.getPackageName().contains("java") || clazz.getPackageName().contains("javax") || clazz.getPackageName().contains("jdk") || clazz.getPackageName().contains("org.w3c") || clazz.getPackageName().contains("org.xml")) {
//                System.out.println(String.format("class %s - is jdk", clazz.getSimpleName()));
//            }
//            System.out.println(String.format("class %s - type %s", clazz.getSimpleName(), clazz.getTypeName()));
//            System.out.println(String.format("class %s is array %b", clazz.getSimpleName(), clazz.isArray()));
//            System.out.println(String.format("class %s is primitive %b", clazz.getSimpleName(), clazz.isPrimitive()));
//            System.out.println(String.format("class %s is enum %b", clazz.getSimpleName(), clazz.isEnum()));
//            System.out.println(String.format("class %s is interface %b", clazz.getSimpleName(), clazz.isInterface()));
//            System.out.println(String.format("class %s is anonymous %b", clazz.getSimpleName(), clazz.isAnonymousClass()));

            System.out.println("\n\n");
        }
    }
    private static class Square implements Drawable {
        @Override
        public int numberOfCorners() {
            return 4;
        }
    }
    private static interface Drawable {
        int numberOfCorners();
    }

    private enum Color {
        BLUE,
        RED,
        GREEN
    }

}
