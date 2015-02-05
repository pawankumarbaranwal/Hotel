package com.example.eeeee;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TypesOfFoodList  extends Activity{

	public static String order="";
	Button chapati,new_btn,starters,nonVegCurries,confirmOrder,typeOfFoodListHome;
	TextView tv1;
	final Context context=this;
	static String item;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.typesoffoodlist);
		chapati = (Button) findViewById(R.id.chapati);
		starters = (Button) findViewById(R.id.starters);
		nonVegCurries = (Button) findViewById(R.id.non_veg);
		confirmOrder = (Button) findViewById(R.id.confirmOrder);
		typeOfFoodListHome = (Button) findViewById(R.id.typeOfFoodListHome);

		chapati.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, AddOrder.class);
				item="chapati";
				Log.i("TypesOfFoodList", item);
				startActivity(intent);   
			}
		});
		starters.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, AddOrder.class);
				item="starters";
				Log.i("TypesOfFoodList", item);
				startActivity(intent);   
			}
		});
		nonVegCurries.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				item="nonVegCurries";
				Log.i("TypesOfFoodList", item);
				Intent intent = new Intent(context, AddOrder.class);
				startActivity(intent);   
			}
		});
		confirmOrder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("TypesOfFoodList", "Confirm Order");
				if(CustomAdapter.orderMenuList.size()==0){
					Toast.makeText(context, "You have not selected any item", 3).show();
				}else{
					Log.i("TypesOfFoodList", CustomAdapter.orderMenuList.size()+"");
				Intent intent = new Intent(context, ConfirmOrder.class);
				startActivity(intent);
				}
			}
		});
		typeOfFoodListHome.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, UserHome.class);
				Log.i("TypesOfFoodList", "HomePage");
				startActivity(intent);   
			}
		});
	}
}
