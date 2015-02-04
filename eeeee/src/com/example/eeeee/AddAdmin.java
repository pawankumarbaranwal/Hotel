package com.example.eeeee;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAdmin extends Activity{
	EditText addAdminName,addAdminUserName,addAdminPassword,addAdminAge;
	Button addAdminSubmit,addAdminHome;
	final Context context=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addadmin);
		addAdminName=(EditText)findViewById(R.id.addAdminName);
		addAdminUserName=(EditText)findViewById(R.id.addAdminUserName);
		addAdminAge=(EditText)findViewById(R.id.addAdminAge);
		addAdminPassword=(EditText)findViewById(R.id.addAdminPassword);
		addAdminSubmit=(Button)findViewById(R.id.addAdminSubmit);
		addAdminHome=(Button)findViewById(R.id.addAdminHome);
		final SQLiteDatabase db;
		db=openOrCreateDatabase("UsersDB", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS users(UserName VARCHAR,name VARCHAR,age VARCHAR,password VARCHAR,usertype VARCHAR);");
		addAdminSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent=new Intent(context,AdminHome.class);
				Integer age = 0;
				if (view==addAdminHome) {
					startActivity(intent);
				}else if(view==addAdminSubmit)  {
					Validator validator=new Validator();
					if((addAdminAge.getText().toString()==null)||(addAdminAge.getText().toString().length()==0	)){
						age=0;
					}else{
						age=Integer.parseInt(addAdminAge.getText().toString());
					}
					if (view==addAdminSubmit) {
						Log.i("AdminHome",(validator.isInvalidUserId(addAdminUserName.getText().toString())).toString());
						if(validator.isInvalidUserId(addAdminUserName.getText().toString())){
							Log.i("AddAdmin","1"+addAdminName.getText()+2+addAdminUserName.getText());
							showMessage("UserName should contain atleast 5 characters","");
						}else if(validator.isInvalidUserName(addAdminName.getText().toString())){
							Log.i("AddAdmin","2");							
							showMessage("Name should contain atleast 5 characters","");
						}else if(validator.isInvalidUserAge(age)){
							showMessage("Age should be between 15 & 120","");
						}else if(validator.isInvalidUserPassword(addAdminPassword.getText().toString())){
							showMessage("Password should  contain atleast 5 characters","");
						}else{
							db.execSQL("INSERT INTO users VALUES('"+addAdminUserName.getText()+"','"+addAdminName.getText()+"','"+addAdminAge.getText()+
									"','"+addAdminPassword.getText()+"','"+"admin"+"');");
							//Login.userId=name.getText()+"";
							intent=new Intent(context, AdminHome.class);
							startActivity(intent);
						}
					}
				}				
			}
		});
	}
	private void showMessage(String title, String message) {
		Toast.makeText(context, title+" "+message, Toast.LENGTH_SHORT).show();
	}
}
