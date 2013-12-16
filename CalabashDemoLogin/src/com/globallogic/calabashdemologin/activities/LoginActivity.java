package com.globallogic.calabashdemologin.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.globallogic.calabashdemologin.R;
import com.globallogic.calabashdemologin.listener.LoginActivityListerner;
import com.globallogic.calabashdemologin.model.LoginActivityModel;

public class LoginActivity extends Activity implements LoginActivityListerner{
	
	private LoginActivityModel model;
	private EditText user;
	private EditText password;
	private Button button;
	private RelativeLayout containerForm;
	private ProgressBar progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		button=(Button)findViewById(R.id.login_button_login);
		user=(EditText)findViewById(R.id.login_user_input);
		password=(EditText)findViewById(R.id.login_password_input);		
		containerForm=(RelativeLayout)findViewById(R.id.login_container_form);
		progress=(ProgressBar)findViewById(R.id.login_progress);
		model= new LoginActivityModel(this);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				containerForm.setVisibility(View.GONE);
				progress.setVisibility(View.VISIBLE);
				model.requestLogin(user.getText().toString(), password.getText().toString());
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public void finishSuccessful() {
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				containerForm.setVisibility(View.VISIBLE);
				progress.setVisibility(View.GONE);
				Intent intent= new Intent(LoginActivity.this, HomeActivity.class);
				startActivity(intent);
				finish();
				
			}
		});
		
	}

	@Override
	public void finishError() {
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				containerForm.setVisibility(View.VISIBLE);
				progress.setVisibility(View.GONE);
				Toast.makeText(LoginActivity.this, "Usuario o Password incorrecto", Toast.LENGTH_LONG).show();
				
			}
		});
		
	}

}
