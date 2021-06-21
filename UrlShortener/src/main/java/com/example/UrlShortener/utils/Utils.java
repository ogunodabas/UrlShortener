package com.example.UrlShortener.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.security.crypto.codec.Hex;

public class Utils {

	// referance
	// https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
	public static int random(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	// referance
	// https://stackoverflow.com/questions/15735079/convert-from-one-base-to-another-in-java
	public static String convertFromBaseToBase(String str, int fromBase, int toBase) {
		return Integer.toString(Integer.parseInt(str, fromBase), toBase);
	}

	//refarance
	//https://www.baeldung.com/sha-256-hashing-java
	public static String encryptSHA256(String str) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(
				str.getBytes(StandardCharsets.UTF_8));
		String sha256hex = new String(Hex.encode(hash));
		sha256hex=convertFromBaseToBase(sha256hex, 16, 10);
		return sha256hex;
	}
}
