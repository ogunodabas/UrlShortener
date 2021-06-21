package com.example.UrlShortener.utils;

import java.util.ArrayList;
import java.util.List;

public class URLShortener {
	private int keyLength;
	private List<Character> charactersRandom;

	public URLShortener() {
		final String charactersWORD = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final String charactersTR = charactersWORD + "ıĞğÜüŞşİÖöÇç";
		this.charactersRandom = this.createRandomCharacters(charactersTR);
		this.keyLength = 8;
	}

	public URLShortener(final int keyLength) {
		this();
		this.keyLength = keyLength;

	}

	private List<Character> createRandomCharacters(String charactersStr) {
		final int charactersLength = charactersStr.length();
		final List<Character> characters = new ArrayList<Character>(charactersLength);
		final List<Character> charactersRandom = new ArrayList<Character>(charactersLength);

		for (char c : charactersStr.toCharArray())
			characters.add(c);

		int counter = 0;
		while (counter < charactersLength) {
			int random = Utils.random(0, charactersLength - 1 - counter);
			System.out.println("counter:" + counter);
			System.out.println("random[0," + (charactersLength - 1 - counter) + "]:" + random);
			charactersRandom.add(characters.get(random));
			characters.remove(random);
			counter++;
		}
		System.out.println(characters);
		System.out.println(charactersRandom);

		return charactersRandom;

	}

	public String shortenUrl(String url) {
		String shortUrl = "";
		for (int i = 0; i < keyLength; i++) {
			shortUrl += charactersRandom.get(Utils.random(0, charactersRandom.size()));
		}
		return shortUrl;
	}

}
