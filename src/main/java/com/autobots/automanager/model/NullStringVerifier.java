package com.autobots.automanager.model;

public class NullStringVerifier {

	public boolean verify(String data) {
		boolean isNull = true;
		if (!(data.isBlank() || data == null)) {
			isNull = false;
		}
		return isNull;
	}
}