package com.example.eeeee;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class AddOrder extends Activity{

	final Context context=this;
	static String message;
	@Override
	public void onCreate(Bundle savedInstanceState) {



		super.onCreate(savedInstanceState);
		setContentView(R.layout.addorderlistview);
		Button other_order=(Button)findViewById(R.id.other_order);
		TextView menuId=(TextView)findViewById(R.id.menuID);
		ListView listView = (ListView) findViewById(R.id.food_lists);

		if(TypesOfFoodList.item.equals("chapati")){
			menuId.setText("Chapati Items");
		}else if(TypesOfFoodList.item.equals("starters")){
			menuId.setText("Starters");
		}else if(TypesOfFoodList.item.equals("nonVegCurries")){
			menuId.setText("Non Veg Curries");
		}
		CustomAdapter customAdapter = new CustomAdapter(this);
		listView.setAdapter(customAdapter);
		other_order.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, TypesOfFoodList.class);
				startActivity(intent);
			}
		});
	}    
}