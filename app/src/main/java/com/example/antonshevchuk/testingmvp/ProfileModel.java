package com.example.antonshevchuk.testingmvp;

import rx.Observable;

interface ProfileModel {
	Observable<UserProfile> stateObservable();
	void loadUserInfo();
}