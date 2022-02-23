package com.lucas.specterbungee.utils;

import java.util.*;
import java.security.*;

public class RandomString {
	public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String lower;
	public static final String digits = "0123456789";
	public static final String alphanum;
	private final Random random;
	private final char[] symbols;
	private final char[] buf;

	static {
		lower = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase(Locale.ROOT);
		alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + RandomString.lower + "0123456789";
	}

	public String nextString() {
		for (int idx = 0; idx < this.buf.length; ++idx) {
			this.buf[idx] = this.symbols[this.random.nextInt(this.symbols.length)];
		}
		return new String(this.buf);
	}

	public RandomString(final int length, final Random random, final String symbols) {
		if (length < 1) {
			throw new IllegalArgumentException();
		}
		if (symbols.length() < 2) {
			throw new IllegalArgumentException();
		}
		this.random = Objects.requireNonNull(random);
		this.symbols = symbols.toCharArray();
		this.buf = new char[length];
	}

	public RandomString(final int length, final Random random) {
		this(length, random, RandomString.alphanum);
	}

	public RandomString(final int length) {
		this(length, new SecureRandom());
	}

	public RandomString() {
		this(21);
	}
}
