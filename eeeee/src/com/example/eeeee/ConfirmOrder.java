package com.example.eeeee;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ConfirmOrder extends Activity {
	final Context context=this;
	static String message;
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.confirmorderlistview);
		Button confirmOrderButton=(Button)findViewById(R.id.confirmOrderButton);
		Button confirmOrderLogout=(Button)findViewById(R.id.confirmOrderLogout);
		final Button rejectOrderButton=(Button)findViewById(R.id.rejectOrderButton);
		final Button modifyOrderButton=(Button)findViewById(R.id.modifyOrderButton);
		final TextView totalPrice=(TextView)findViewById(R.id.totalPrice);
		final TextView confirmOrderTextview=(TextView)findViewById(R.id.confirmOrderTextview);
		ListView confirmOrderListview = (ListView) findViewById(R.id.confirmOrderListview);

		//confirmOrderButton.setOnClickListener(this); 
		final SQLiteDatabase db;
		db=openOrCreateDatabase("UsersDB", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS users(UserName VARCHAR,name VARCHAR,age VARCHAR,password VARCHAR,usertype VARCHAR);");

		Integer sum=0;

		for(int i=0;i<CustomAdapter.orderMenuList.size();i++){
			sum=sum+((CustomAdapter.orderMenuList.get(i).getPrice())*CustomAdapter.orderMenuList.get(i).getQuantity());
		}
		totalPrice.setText("Rs. "+sum);

		CustomAdapterForConfirmOrder customAdapterForConfirmOrder = new CustomAdapterForConfirmOrder(this);
		confirmOrderListview.setAdapter(customAdapterForConfirmOrder);
		confirmOrderButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Login.userId="pawan";
				Cursor c=db.rawQuery("SELECT * FROM foodorder WHERE username='"+Login.userId+"'", null);
				Integer max=1;
				while(c.moveToNext()){
					Log.i("ConfirmOrder","Enter");
					Integer s=Integer.parseInt(c.getString(3));
					if (s>=max) {
						max=s;
					}
				}
				max=max+1;
				for(int i=0;i<CustomAdapter.orderMenuList.size();i++){
					db.execSQL("INSERT INTO foodorder VALUES('"+CustomAdapter.orderMenuList.get(i).getFoodName()+"','"+CustomAdapter.orderMenuList.get(i).getPrice()+"','"+CustomAdapter.orderMenuList.get(i).getQuantity()+"','"+max.toString()+"','"+"pawan"+"');");
				}
				CustomAdapter.orderMenuList.clear();
				confirmOrderTextview.setText("Your Order has been Submitted Successfully");
				rejectOrderButton.setEnabled(false);
				modifyOrderButton.setEnabled(false);
			}
		});
		modifyOrderButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(context, TypesOfFoodList.class);
				startActivity(intent);
			}
		});
		rejectOrderButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				CustomAdapter.orderMenuList.clear();
				Intent intent = new Intent(context, UserHome.class);
				startActivity(intent);
			}
		});
		confirmOrderLogout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CustomAdapter.orderMenuList.clear();
				Intent intent = new Intent(context, MainActivity.class);
				startActivity(intent);

			}
		});
	}
}