package com.lucas.specterbungee.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ReflectionUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(Object obj, String fieldname) {
		Class<?> clazz = obj.getClass();
		do {
			try {
				Field field = clazz.getDeclaredField(fieldname);
				field.setAccessible(true);
				return (T) field.get(obj);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException t) {
			}
		} while ((clazz = clazz.getSuperclass()) != null);
		return null;
	}

	public static void setFieldValue(Object obj, String fieldname, Object value) {
		Class<?> clazz = obj.getClass();
		do {
			try {
				Field field = clazz.getDeclaredField(fieldname);
				field.setAccessible(true);
				field.set(obj, value);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException t) {
			}
		} while ((clazz = clazz.getSuperclass()) != null);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getStaticFieldValue(Class<?> clazz, String fieldname) {
		do {
			try {
				Field field = clazz.getDeclaredField(fieldname);
				field.setAccessible(true);
				return (T) field.get(null);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException t) {
			}
		} while ((clazz = clazz.getSuperclass()) != null);
		return null;
	}

	public static void invokeMethod(Object obj, String methodname, Object... args) {
		Class<?> clazz = obj.getClass();
		do {
			try {
				for (Method method : clazz.getDeclaredMethods()) {
					if (method.getName().equals(methodname) && method.getParameterTypes().length == args.length) {
						method.setAccessible(true);
						method.invoke(obj, args);
					}
				}
			} catch (SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException t) {
			}
		} while ((clazz = clazz.getSuperclass()) != null);
	}

}
