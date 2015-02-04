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

public class SignUp extends Activity implements OnClickListener{
	EditText userName,name,age,password;
	Button submit,signUpHome;
	SQLiteDatabase db;
	Context context=this;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		userName=(EditText) findViewById(R.id.userName);
		name=(EditText) findViewById(R.id.name);
		age=(EditText) findViewById(R.id.age);
		password=(EditText) findViewById(R.id.password);
		submit= (Button) findViewById(R.id.submit);
		signUpHome=(Button)findViewById(R.id.signUpHome);
		submit.setOnClickListener(this); 
		signUpHome.setOnClickListener(this);
		db=openOrCreateDatabase("UsersDB", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS users(UserName VARCHAR,name VARCHAR,age VARCHAR,password VARCHAR,usertype VARCHAR);");

	}
	@Override
	public void onClick(View view) {
		Intent intent=new Intent(context,MainActivity.class);
		Integer integer = 0;
		if (view==signUpHome) {
			startActivity(intent);
		}else if(view==submit)  {
			Validator validator=new Validator();
			Log.i("SignUp",age.getText()+"Age");
			if((age.getText().toString()==null)||(age.getText().toString().length()==0	)){
				integer=0;
			}else{
				integer=Integer.parseInt(age.getText().toString());
			}
			if (view==submit) {
				if(validator.isInvalidUserId(userName.getText().toString())){
					showMessage("User Name should contain atleast 5 characters","");
				}else if(validator.isInvalidUserName(name.getText().toString())){
					showMessage("Name should contain atleast 5 characters","");
				}else if(validator.isInvalidUserAge(integer)){
					showMessage("Age should be between 15 & 120","");
				}else if(validator.isInvalidUserPassword(password.getText().toString())){
					showMessage("Password should  contain atleast 5 characters","");
				}else{
					db.execSQL("INSERT INTO users VALUES('"+userName.getText()+"','"+name.getText()+"','"+age.getText()+
							"','"+password.getText()+"','"+"user"+"');");
					Login.userId=name.getText()+"";
					intent=new Intent(context, UserHome.class);
					startActivity(intent);
					//Cursor c=db.rawQuery("SELECT * FROM users WHERE userName='"+userName.getText()+"'", null);
					//showMessage(userName.getText().toString(), "is registered successfully");

				}
			}
		}
	}
	private void showMessage(String title, String message) {
		Toast.makeText(context, title+" "+message, Toast.LENGTH_SHORT).show();
	}
}
