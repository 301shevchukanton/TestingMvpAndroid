package com.example.antonshevchuk.testingmvp;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by AntonShevchuk on 19.10.2017.
 */


public class ProfilePresenter {
	private final ProfileModel model;
	private ProfileView view;

	private Subscription subscription;

	public ProfilePresenter(ProfileModel model) {
		this.model = model;
	}

	public void attachView(ProfileView view) {
		this.view = view;
		subscribeOnModel();
	}

	public void dettachView() {
		if (subscription != null && !subscription.isUnsubscribed()) {
			subscription.unsubscribe();
		}
	}

	private void subscribeOnModel() {

		subscription = model
				.stateObservable()
				.subscribe(new Action1<UserProfile>() {
					@Override
					public void call(UserProfile userProfile) {
						if (view != null) {
							view.display(userProfile);
						}
					}
				});
	}

	public void onLoadClicked() {
		model.loadUserInfo();
	}
}