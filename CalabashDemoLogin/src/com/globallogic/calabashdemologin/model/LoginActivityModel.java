package com.globallogic.calabashdemologin.model;

import com.globallogic.calabashdemologin.listener.LoginActivityListerner;

public class LoginActivityModel {
	private LoginActivityListerner view;
	
	
	public LoginActivityModel(LoginActivityListerner view) {
		this.view=view;
	}

	public void requestLogin( final String user, final String pass){
		Thread request = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					if(user.equals("pepe")&&pass.equals("123")){
						view.finishSuccessful();
					}else{
						view.finishError();
					}
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		request.start();
	}
}
