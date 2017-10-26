package com.example.antonshevchuk.testingmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ProfileView {

	private ProfilePresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.presenter = new ProfilePresenter(new ProfileModelImpl());
	}

	public void setPresenter(ProfilePresenter presenter) {
		if (this.presenter != null) {
			this.presenter.dettachView();
		}
		this.presenter = presenter;
		presenter.attachView(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
		presenter.attachView(this);
	}

	@Override
	protected void onStop() {
		presenter.dettachView();
		super.onStop();
	}

	@Override
	public void display(UserProfile userProfile) {
		((TextView) findViewById(R.id.userProfile)).setText(userProfile.getName());
	}

	@Override
	public String getText() {
		return ((TextView) findViewById(R.id.userProfile)).getText().toString();
	}
}
