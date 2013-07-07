package com.ktt.sync.authenticator;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.ktt.kianasyncadapter.R;


public class AuthActivity extends AccountAuthenticatorActivity {
	
	private AccountManager accountManager;
	
    @Override
    public void onCreate(Bundle bundle) {
    	Log.i("kttsync", "AuthActivity onCreate");
    	super.onCreate(bundle);
    	setContentView(R.layout.auth_layout);
    	accountManager = AccountManager.get(this);
    }
    
    /*
     * Button in layout completes the authentication process, by calling a remote auth service
     * OR explicitly authenticating.
     */
    public void completeAuthProcess(View view) {
    	// we would probably call a remote auth service and get an authtoken to save in the account manager.
    	EditText editText = (EditText) findViewById(R.id.addUsername);
    	
    	Account kttAccount = new Account(editText.getText().toString(), "com.ktt.contacts");

    	accountManager.addAccountExplicitly(kttAccount, "", null);
    	
    	//tell the content resolver to sync this account when receiving a network tickle
    	//note ContactsContract.AUTHORITY = "com.android.contacts"
    	ContentResolver.setSyncAutomatically(kttAccount, ContactsContract.AUTHORITY, false);
    	
        final Intent intent = new Intent();
        intent.putExtra(AccountManager.KEY_ACCOUNT_NAME, kttAccount.name);
        intent.putExtra(AccountManager.KEY_ACCOUNT_TYPE, kttAccount.type);
        setAccountAuthenticatorResult(intent.getExtras());
        setResult(RESULT_OK, intent);
        finish();
    }
}
