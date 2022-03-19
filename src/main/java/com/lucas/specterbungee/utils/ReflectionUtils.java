package com.lucas.specterbungee.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ReflectionUtils {
    public static <T> T getFieldValue(Object obj, String fieldname) {
        Class<?> clazz = obj.getClass();
        while (true) {
            try {
                Field field = clazz.getDeclaredField(fieldname);
                field.setAccessible(true);
                return (T)field.get(obj);
            } catch (NoSuchFieldException|SecurityException|IllegalArgumentException|IllegalAccessException noSuchFieldException) {
                if ((clazz = clazz.getSuperclass()) == null)
                    return null;
            }
        }
    }

    public static void setFieldValue(Object obj, String fieldname, Object value) {
        Class<?> clazz = obj.getClass();
        do {
            try {
                Field field = clazz.getDeclaredField(fieldname);
                field.setAccessible(true);
                field.set(obj, value);
            } catch (NoSuchFieldException|SecurityException|IllegalArgumentException|IllegalAccessException noSuchFieldException) {}
        } while ((clazz = clazz.getSuperclass()) != null);
    }

    public static <T> T getStaticFieldValue(Class<?> clazz, String fieldname) {
        while (true) {
            try {
                Field field = clazz.getDeclaredField(fieldname);
                field.setAccessible(true);
                return (T)field.get((Object)null);
            } catch (NoSuchFieldException|SecurityException|IllegalArgumentException|IllegalAccessException noSuchFieldException) {
                if ((clazz = clazz.getSuperclass()) == null)
                    return null;
            }
        }
    }

    public static void invokeMethod(Object obj, String methodname, Object... args) {
        Class<?> clazz = obj.getClass();
        do {
            try {
                byte b;
                int i;
                Method[] arrayOfMethod;
                for (i = (arrayOfMethod = clazz.getDeclaredMethods()).length, b = 0; b < i; ) {
                    Method method = arrayOfMethod[b];
                    if (method.getName().equals(methodname) && (method.getParameterTypes()).length == args.length) {
                        method.setAccessible(true);
                        method.invoke(obj, args);
                    }
                    b = (byte)(b + 1);
                }
            } catch (SecurityException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException securityException) {}
        } while ((clazz = clazz.getSuperclass()) != null);
    }
}