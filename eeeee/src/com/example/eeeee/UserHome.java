package com.example.eeeee;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

 
public class UserHome extends Activity implements OnClickListener{

	Button placeAnOrder,viewPreviousOrders,changePassword,userHomeLogout;
	TextView welcomeMessage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.userhome);
		welcomeMessage=(TextView)findViewById(R.id.welcomeMessage);
		userHomeLogout=(Button)findViewById(R.id.userHomeLogout);
		placeAnOrder=(Button) findViewById(R.id.placeAnOrder);
		viewPreviousOrders=(Button) findViewById(R.id.viewPreviousOrders);
		changePassword=(Button) findViewById(R.id.changePassword);
		placeAnOrder.setOnClickListener(this); 
		viewPreviousOrders.setOnClickListener(this); 
		changePassword.setOnClickListener(this);
		userHomeLogout.setOnClickListener(this);
		welcomeMessage.setText("Welcome "+Login.userId);
	}
	@Override
	public void onClick(View view) {
		final Context context = this;
		if (view==placeAnOrder) {
			Log.i("UserHome","placeAnOrder");
			Intent intent = new Intent(context, TypesOfFoodList.class);
			startActivity(intent);   
		}else if (view==viewPreviousOrders) {
			Log.i("UserHome","viewPreviousOrders");
			Intent intent = new Intent(context, PreviousOrders.class);
			startActivity(intent);   
		}else if (view==changePassword) {
			Log.i("UserHome","changePassword");			
			Intent intent = new Intent(context, ChangePassword.class);
			startActivity(intent);   
		}else if (view==userHomeLogout) {
			Log.i("UserHome","userHomeLogout");			
			Intent intent = new Intent(context, MainActivity.class);
			startActivity(intent);   
		}
	}
}
