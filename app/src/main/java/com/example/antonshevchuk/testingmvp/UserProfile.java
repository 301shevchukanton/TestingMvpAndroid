package com.example.antonshevchuk.testingmvp;

/**
 * Created by AntonShevchuk on 19.10.2017.
 */

class UserProfile {
	private final String username;

	public UserProfile(String username) {
		this.username = username;
	}
	public String getName() {
		return username;
	}
}
