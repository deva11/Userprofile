package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.view.View.*;
import android.preference.*;

public class MainActivity extends Activity 
{
	Button but_log,but_reg;
	EditText et_log,et_pass;
	TextView tv_clr;
	
	//TextView x;
	SharedPreferences sharedpref;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		but_log = (Button)findViewById(R.id.logsc_logbuttn);
		but_reg = (Button)findViewById(R.id.logsc_regbuttn);
		et_log = (EditText)findViewById(R.id.logscreen_email);
		et_pass = (EditText)findViewById(R.id.logscreen_passwd);
		tv_clr = (TextView)findViewById(R.id.logsc_clrtv);
		
		
        
		
		
		but_log.setOnClickListener(new View.OnClickListener()
			{
				

				@Override
				public void onClick(View p1)
				{
					sharedpref = getSharedPreferences("PERSOPREF",Context.MODE_PRIVATE);
					String username = sharedpref.getString("Email"," ");
					String password = sharedpref.getString("Passwordi"," ");
					
					if((et_log.getText().toString() == null) || (et_pass.getText().toString()== null))
					{
						Toast.makeText(MainActivity.this,"Enter both fields",Toast.LENGTH_SHORT).show();
					}
					
					if((et_log.getText().toString() == username) && (et_pass.getText().toString()== password))

					{
						Intent intente = new Intent(MainActivity.this,loggedin.class);
					startActivity(intente) ;
						Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
					//sharedpref = getSharedPreferences("PERSOPREF",Context.MODE_PRIVATE);
					
					
					// TODO: Implement this method
					
				}
				else
				{
					Toast.makeText(MainActivity.this,"Incorrrect details",Toast.LENGTH_SHORT).show();
				}
			
		}
		
		}
		);
		/*but_reg.setOnClickListener( new View.OnClickListener()
			{

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					
					Intent intent_reg = new Intent(MainActivity.this,create_id.class);
					startActivity(intent_reg);
				}
				
			
		});*/
    }
	public void onREGbutclick(View view) 
    {
    	Intent intent = new Intent(this,create_id.class);
    	startActivity(intent) ;
	}
	
}
