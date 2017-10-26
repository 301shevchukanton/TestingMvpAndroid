package com.example.antonshevchuk.testingmvp;

import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by AntonShevchuk on 19.10.2017.
 */

public class ProfileModelImpl implements ProfileModel {

	private BehaviorSubject<UserProfile> state = BehaviorSubject.create();

	@Override
	public Observable<UserProfile> stateObservable() {
		return state;
	}

	public void loadUserInfo() {
		state.onNext(new UserProfile("USERNAME"));
	}
}
