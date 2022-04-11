package com.autobots.automanager.model;

public class NullStringVerifier {
	public boolean verify(String text) {
		return text == null || text.isBlank();
	}
}