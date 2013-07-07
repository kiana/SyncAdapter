package com.ktt.sync.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SyncAdapterService extends Service {

	private static final Object syncLock = new Object();
	private static KTTSyncAdapter adapter = null;
	
	@Override
	public void onCreate() {
		Log.i("kttsync", "SyncAdapterService oncreate");
		synchronized(syncLock) {
			adapter = new KTTSyncAdapter(getApplicationContext(), true);
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.i("kttsync", "SyncAdapterService onBind");
		return adapter.getSyncAdapterBinder();
	}

}
