package com.ktt.sync.syncadapter;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

public class KTTSyncAdapter extends AbstractThreadedSyncAdapter {

	private final Context context;
	private final AccountManager accountManager;
	
	public KTTSyncAdapter(Context context, boolean autoInitialize) {
		super(context, autoInitialize);
		this.context = context;
		this.accountManager = AccountManager.get(context);
		Log.i("kttsync", "KTTSyncAdapter Constructor");
	}

	@Override
	public void onPerformSync(Account account, Bundle extras, String authority,
			ContentProviderClient provider, SyncResult syncResult) {

		Log.i("kttsync", "KTTSyncAdapter onPerformSync: " + account.name);
		
		// step 1: build httprequest object
		// step 2: connect to [??? from Effective Android HTTP Part 2]:3000/customers.json
		// step 3: parse json response
		// step 4: input to contacts contentprovider
	}

}
