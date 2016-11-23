package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.*;

public class loggedin extends Activity
{
	TextView loggedview_name;
	TextView loggedview_email;
	TextView loggedview_mobilenumber;
	
SharedPreferences sharedpref;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loggedin);
		
		
		loggedview_name = (TextView)findViewById(R.id.profile_name);
		loggedview_email = (TextView)findViewById(R.id.profile_email);
		loggedview_email = (TextView)findViewById(R.id.profile_mobile);

		sharedpref = getSharedPreferences("PERSOPREF",Context.MODE_PRIVATE);
		String disp_name =sharedpref.getString("Firstnamme"," ");
		String disp_email =sharedpref.getString("Email"," ");
		String disp_mobile =sharedpref.getString("Mobile"," ");

		loggedview_name.setText(disp_name);
		loggedview_email.setText(disp_email);
		loggedview_mobilenumber.setText(disp_mobile);
		
	}
	
}
