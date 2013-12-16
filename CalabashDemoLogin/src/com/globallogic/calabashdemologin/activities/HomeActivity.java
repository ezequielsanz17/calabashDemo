package com.globallogic.calabashdemologin.activities;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.globallogic.calabashdemologin.R;

public class HomeActivity extends Activity {

	private Button buttonOpenUrl;
	private Button buttonChangeBackground;
	private Button buttonLogout;
	
	private LinearLayout containerMain;
	
	private int stateColor=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		buttonOpenUrl=(Button)findViewById(R.id.home_button_01);
		buttonChangeBackground=(Button)findViewById(R.id.home_button_02);
		buttonLogout=(Button)findViewById(R.id.home_button_03);
		containerMain=(LinearLayout)findViewById(R.id.homeContainerMain);
		
		buttonOpenUrl.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
				startActivity(browserIntent);
				
			}
		});
		buttonChangeBackground.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (stateColor==0) {
					containerMain.setBackgroundColor(getResources().getColor(R.color.holo_blue));
					stateColor=1;
				}else{
					containerMain.setBackgroundColor(getResources().getColor(R.color.orange));
					stateColor=0;
				}
				
			}
		});
		buttonLogout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(HomeActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
