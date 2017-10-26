package com.example.antonshevchuk.testingmvp;

import org.junit.Before;
import org.junit.Test;

import rx.observers.TestSubscriber;

import static org.junit.Assert.*;

/**
 * Created by Anton Shevchuk on 19.10.2017.
 */
public class ProfileModelTest {
	private static final String USER = "USERNAME";
	ProfileModel interactor;

	@Before
	public void setUp() {
		interactor = new ProfileModelImpl();
	}

	@Test
	public void testGetUserProfile() throws Exception {
		TestSubscriber<UserProfile> subscriber = TestSubscriber.create();
		interactor.stateObservable().subscribe(subscriber);
		subscriber.assertNoErrors();
		subscriber.assertCompleted();
		assertEquals(USER, subscriber.getOnNextEvents().get(0).getName());
	}
}