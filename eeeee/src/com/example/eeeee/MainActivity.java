package com.example.eeeee;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	Button signIn;
	Button signUp;
	final Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		signIn=(Button)findViewById(R.id.signIn);
		signUp=(Button)findViewById(R.id.signUp);	
		signIn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, Login.class);
				startActivity(intent);    
			} 
		});	
		signUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, SignUp.class);
				startActivity(intent);    
			} 
		});
	}
}
