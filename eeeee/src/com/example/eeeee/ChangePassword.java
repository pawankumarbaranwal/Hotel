package com.example.eeeee;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends Activity implements OnClickListener{

	EditText oldPassword,newPassword,confirmPasword;
	Button submit;
	SQLiteDatabase db;
	final Context context=this;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changepassword);
		oldPassword=(EditText)findViewById(R.id.oldPassword);
		newPassword=(EditText)findViewById(R.id.newPassword);
		confirmPasword=(EditText)findViewById(R.id.confirmPassword);
		submit=(Button)findViewById(R.id.submit);
		submit.setOnClickListener(this);
		Log.i("ChangePassword","beforeDB");			
		db=openOrCreateDatabase("UsersDB", Context.MODE_PRIVATE, null);
		Log.i("ChangePassword","afterDB");			
	}

	@Override
	public void onClick(View view) {

		Cursor c=db.rawQuery("SELECT * FROM users WHERE userName='"+Login.userId+"'", null);
		Log.i("ChangePassword","entered");
		if(c.moveToNext()){
			if (oldPassword.getText().toString().equals(c.getString(3))){
				if (newPassword.getText().toString().equals(confirmPasword.getText().toString())) {
					if((newPassword.getText().toString().length()==0)||(newPassword.getText().toString()==null)){
						showMessage("New Password or Confirm Password cannot be blank");
					}else if(newPassword.getText().toString().length()<5){
						showMessage("New Password cannot be less than 5 Character");
					}else if(newPassword.getText().toString().length()<5){
						showMessage("Confirm Password cannot be less than 5 Character");
					}else if(confirmPasword.getText().toString().equals(oldPassword.getText().toString())){
						showMessage("Confirm Password or Old Password cannot be same");
					}else{
						db.execSQL("UPDATE users SET password='"+newPassword.getText()+"'WHERE UserName='"+Login.userId+"'");
						showMessage("Your Password is modified successfully");
					}
				}else{
					showMessage("New Password and confirm password should be same");
				}
			}
			else{
				showMessage("Please Enter correct old password");
			}
		}
	}
	private void showMessage(String message) {
		Toast.makeText(context, message, 3).show();
	}
}
