package com.example.eeeee;

import java.util.ArrayList; 
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

public class PreviousOrders extends Activity {
	final Context context=this;
	static String message;
	Button orderId;
	SQLiteDatabase db;
	List<FoodDetails> orderMenuList=new ArrayList<FoodDetails>();
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.previousorderlistview);
		//orderId=(Button)findViewById(R.id.orderId);
		db=openOrCreateDatabase("UsersDB", Context.MODE_PRIVATE, null);
		Cursor c=db.rawQuery("SELECT * FROM foodorder", null);
		FoodDetails foodDetails=new FoodDetails();
		/*Integer min=0;
		if(c.moveToFirst()){
			min=Integer.parseInt(c.getString(3));
			foodDetails=new FoodDetails();
			foodDetails.setFoodName(c.getString(0));
			foodDetails.setPrice(Integer.parseInt(c.getString(1)));
			foodDetails.setQuantity(Integer.parseInt(c.getString(2)));
			foodDetails.setOrderId(c.getString(3));
			foodDetails.setUsername(c.getString(4));
			orderMenuList.add(foodDetails);
		}*/
		while(c.moveToNext()){
			foodDetails=new FoodDetails();
			foodDetails.setFoodName(c.getString(0));
			foodDetails.setPrice(Integer.parseInt(c.getString(1)));
			foodDetails.setQuantity(Integer.parseInt(c.getString(2)));
			foodDetails.setOrderId(c.getString(3));
			foodDetails.setUsername(c.getString(4));
			Log.i("PreviousOrders",c.getString(3));

			/*if ((Integer.parseInt(c.getString(3)))<min) {
				min=Integer.parseInt(c.getString(3));
			}*/	
			orderMenuList.add(foodDetails);
		}
		/*	List<FoodDetails> list=new ArrayList<FoodDetails>();
		int count=0;
		while(count!=orderMenuList.size()){
			for(int i=0;i<orderMenuList.size();i++){
				Log.i("PreviousOrders" ,orderMenuList.get(i).getOrderId()+"Pawan");
				if((orderMenuList.get(i).getOrderId()).equals(min+"")){
					foodDetails=orderMenuList.get(i);
					list.add(foodDetails);
					count++;
				}
			}
			orderId.setText(min+"");
			min=min+1;*/
		ListView previousOrderListview = (ListView) findViewById(R.id.previousOrderListview);
		Log.i("PreviousOrders", orderMenuList.size()+"size");

		CustomAdapterForPreviousOrder customAdapterForConfirmOrder = new CustomAdapterForPreviousOrder(this,orderMenuList);
		previousOrderListview.setAdapter(customAdapterForConfirmOrder);
	}
}