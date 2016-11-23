package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.icu.util.*;
import android.widget.DatePicker.*;
import android.widget.CalendarView.*;
import android.widget.AdapterView.*;
import android.content.*;

public class create_id extends Activity
{
	Spinner spin;
	ArrayAdapter<CharSequence> adapter;
	
	EditText ET_FN,ET_LN,ET_EID,ET_PW,ET_DOB,ET_MOB,ET_ADDRT;
	
	
	/*Calendar cal = Calendar.getInstance();
	
	TextView tv_dobview;*/
	
	//public static final String PERSOPREF = "Userdata";
	//public static final String Firstnamme = "fname";
	//public static final String Lastname = "lname";
	//public static final String Email = "email";
	//public static final String Passwordi = "password";
	
	
	 SharedPreferences sharepref;
	 
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_id);
		ET_FN = (EditText)findViewById(R.id.et_reg_firstname);
		ET_LN = (EditText)findViewById(R.id.et_reg_lastname);
		
		ET_EID= (EditText)findViewById(R.id.et_reg_email);
		ET_PW = (EditText)findViewById(R.id.et_reg_passwd);
		
		spin = (Spinner)findViewById(R.id.spinner_reg_aoi);
		adapter= ArrayAdapter.createFromResource(this,R.array.aoi,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(adapter);
		
		sharepref = getSharedPreferences("PERSOPREF",Context.MODE_PRIVATE);
		
		
		
		
		
		
		spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
			{

				@Override
				public void onItemSelected(AdapterView<?> parent, View p2, int posi, long p4)
				{
					Toast.makeText(getBaseContext(),parent.getItemAtPosition(posi)+"",Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
				
			
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO: Implement this method
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu,menu);
		return super.onCreateOptionsMenu(menu);
		
		
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
	switch(item.getItemId())
	{
		case R.id.tick_done:
			
		String f =  ET_FN.getText().toString();
		String l = ET_LN.getText().toString();
		
			String e =  ET_EID.getText().toString();
			String p =  ET_PW.getText().toString();
			
			String m =  ET_MOB.getText().toString();
		
		SharedPreferences.Editor editdata = sharepref.edit();
		
		    editdata.putString("Firstnamme",f);
		    editdata.putString("Lastname",l);
			editdata.putString("Mobile",m);
			editdata.putString("Email",e);
			editdata.putString("Passwordi",p);
			
		editdata.commit();
		
		Toast.makeText(this,"Profile Created!Login now.\n",Toast.LENGTH_LONG).show();
		break;
			
		
	}
		return super.onOptionsItemSelected(item);
	}
		
		
		
		/*public void Adata(){
		
       Button  dpd = (Button)findViewById(R.id.butt_reg_dob);
		 tv_dobview =(TextView)findViewById(R.id.tv_reg_dob);
		 
		 
		 dpd.setOnClickListener(new View.OnClickListener()
			{

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					new DatePickerDialog(create_id.this,listener,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));
				}
				
			 
		 });
		 
	}

	DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener()
	{

		@Override
		public void onDateSet(DatePicker view, int year, int month, int dayofmonth)
		{
			// TODO: Implement this method
			tv_dobview.setText(" " + dayofmonth + "/"  + (month+1) + "/" + year);
		}
		
		
	};
	
	*/
	
	
}
