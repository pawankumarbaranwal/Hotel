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

public class AddMenu extends Activity{
	Button submitFood;
	EditText foodType,foodName,foodPrice;
	SQLiteDatabase db;
	private Context context=this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addmenu);
		foodType=(EditText)findViewById(R.id.foodType);
		foodName=(EditText)findViewById(R.id.foodName);
		foodPrice=(EditText)findViewById(R.id.foodPrice);
		submitFood=(Button)findViewById(R.id.submitFood);
		db=openOrCreateDatabase("UsersDB", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS foodtype(foodType VARCHAR);");
		db.execSQL("CREATE TABLE IF NOT EXISTS fooddetails1(foodname VARCHAR,price VARCHAR,foodtype VARCHAR);");

		submitFood.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Validator validator=new Validator();
				Integer price;
				if((foodPrice.getText().toString()==null)||(foodPrice.getText().toString().length()==0	)){
					price=0;
				}else{
					price=Integer.parseInt(foodPrice.getText().toString());
				}
				Log.i("AddMenu", price+"");
				if (validator.isInvalidFoodName(foodName.getText().toString())) {
					Toast.makeText(context, "FoodType should contain atleast 5 char", Toast.LENGTH_SHORT).show();
					Log.i("AddMenu", 1+"");
				}else if (validator.isInvalidFoodName(foodName.getText().toString())) {
					Toast.makeText(context, "FoodName should contain atleast 5 char", Toast.LENGTH_SHORT).show();
					Log.i("AddMenu", 2+"");
				}else if (validator.isInvalidFoodPrice(price)) {
					Toast.makeText(context, "FoodPrice should be greater than Rs.40 & less than Rs.1000", Toast.LENGTH_SHORT).show();
					Log.i("AddMenu", 3+"");
				}
				else{
					Cursor c=db.rawQuery("SELECT * FROM foodtype WHERE foodType ='"+foodType.getText()+"'",null);
					if (c.moveToFirst()) {
						Toast.makeText(context, "This Food Type is already added", Toast.LENGTH_SHORT).show();	
					}else{
						db.execSQL("INSERT INTO foodtype VALUES('"+foodType.getText()+"');");
						db.execSQL("INSERT INTO fooddetails1 VALUES('"+foodName.getText()+"','"+foodPrice.getText()+"','"+foodType.getText()+"');");
						Toast.makeText(context, "Food Details has been added successfully", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
	}
}
