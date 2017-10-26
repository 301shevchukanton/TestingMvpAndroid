package com.example.antonshevchuk.testingmvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import rx.Observable;

import static org.mockito.Mockito.verify;

/**
 * Created by AntonShevchuk on 19.10.2017.
 */
public class ProfilePresenterTest {
	@Mock
	ProfileModel model;
	@Mock
	ProfileView view;
	private ProfilePresenter presenter;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Mockito.when(model.stateObservable()).thenReturn(Observable.just(new UserProfile("USERNAME")));
		presenter = new ProfilePresenter(model);
		presenter.attachView(view);
	}

	@Test
	public void testDisplayCalled() {
		presenter.onLoadClicked();
		verify(view).display(Mockito.any(UserProfile.class));
	}
}
