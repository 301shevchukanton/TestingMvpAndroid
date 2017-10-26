package com.example.antonshevchuk.testingmvp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

/**
 * Created by AntonShevchuk on 19.10.2017.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(manifest = "app/src/main/AndroidManifest.xml", constants = BuildConfig.class, sdk=21)
public class MainActivityTest {

	public static final String USERNAME = "USERNAME";

	private MainActivity profileView;

	@Mock
	ProfilePresenter presenter;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
        this.profileView = Robolectric.buildActivity(MainActivity.class).create().start().resume().visible().get();
		this.profileView.setPresenter(this.presenter);
	}

	@Test
	public void testLeaveView() throws Exception {
		this.profileView.onStop();
		verify(this.presenter).dettachView();
	}

	@Test
	public void testReturnToView() throws Exception {
		reset(this.presenter);
		this.profileView.onStart();
		verify(this.presenter).attachView(this.profileView);
	}

	@Test
	public void testDisplay() throws Exception {
		UserProfile user = new UserProfile(USERNAME);
		this.profileView.display(user);
		assertEquals(USERNAME, this.profileView.getText());
	}
}