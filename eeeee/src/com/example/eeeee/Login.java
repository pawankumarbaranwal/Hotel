package com.example.eeeee;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

	public EditText  userName=null;
	private EditText  password=null;
	private TextView attempts;
	private Button login;
	static String userId;
	SQLiteDatabase db;
	int counter = 6;
	final Context context = this;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		userName = (EditText)findViewById(R.id.userName);
		password = (EditText)findViewById(R.id.password);
		attempts = (TextView)findViewById(R.id.attempts);
		attempts.setText(Integer.toString(counter));
		login = (Button)findViewById(R.id.login);
		db=openOrCreateDatabase("UsersDB", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS users(UserName VARCHAR,name VARCHAR,age VARCHAR,password VARCHAR,usertype VARCHAR);");

	}

	public void login(View view){
		if(userName.getText().toString().length()==0){
			Toast.makeText(getApplicationContext(), "User Name Cannot be empty",Toast.LENGTH_SHORT).show();
		}else{
			final Cursor c=db.rawQuery("SELECT * FROM users WHERE userName='"+userName.getText()+"'", null);
			int temp=0;
			while(c.moveToNext()){
				if(userName.getText().toString().equals(c.getString(0))){
					temp=1;
					if (password.getText().toString().equals(c.getString(3))) {
						userId=userName.getText()+"";
						Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
						login.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View arg0) {
								if(c.getString(4).equals("user")){
									Intent intent = new Intent(context, UserHome.class);
									startActivity(intent);   
								}
							}
						});
						break;
					}
					else{
						Toast.makeText(getApplicationContext(), "Please Enter correct password",
								Toast.LENGTH_SHORT).show();
						attempts.setBackgroundColor(Color.RED);	
						counter--;
						attempts.setText(Integer.toString(counter));
						if(counter==0){
							login.setEnabled(false);
						}
					}
				}
			}
			if(temp==0){
				Toast.makeText(getApplicationContext(), "Please Enter correct Username", Toast.LENGTH_SHORT).show();
				attempts.setBackgroundColor(Color.RED);	
				counter--;
				attempts.setText(Integer.toString(counter));
			}
		}
	}
}