package com.ktt.sync.authenticator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AuthService extends Service {

	private AccountAuthenticator authenticator = null;
	
	@Override
	public void onCreate() {
		Log.i("kttsync", "AuthService onCreate");
		authenticator = new AccountAuthenticator(this);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.i("kttsync", "AuthService onBind");
		return authenticator.getIBinder();
	}

}
