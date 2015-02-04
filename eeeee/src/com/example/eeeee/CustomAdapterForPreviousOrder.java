package com.example.eeeee;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CustomAdapterForPreviousOrder extends BaseAdapter {
	Button increment,decrement;
	public static LayoutInflater inflater = null;
	EditText displayCount;
	SQLiteDatabase db;
	public List<FoodDetails> orderMenuList=new ArrayList<FoodDetails>();


	public CustomAdapterForPreviousOrder(Activity a,List<FoodDetails> list) {
		inflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		orderMenuList.addAll(list);
	}
	@Override
	public int getCount() {
		return orderMenuList.size();    
	}

	@Override
	public Object getItem(int i) {
		return orderMenuList.get(i);   
	}

	@Override
	public long getItemId(int i) {
		return i;                  
	}

	public static class MyListItem{
		public TextView foodName;
		public TextView foodPrice;
		public TextView foodQuantity;
		public TextView totalPriceOfRow;
		public Button submit;

	}

	@Override
	public View getView(int index, View view, final ViewGroup parent) {

		View tempView = view;
		MyListItem myLI;
		FoodDetails currentData = orderMenuList.get(index);

		if (view == null) {
			tempView = inflater.inflate(R.layout.previousorderview, parent, false);	
			myLI = new MyListItem();
			myLI.foodName = (TextView) tempView.findViewById(R.id.previousOrderFoodName);
			myLI.foodPrice=(TextView) tempView.findViewById(R.id.previousOrderFoodPrice);
			myLI.foodQuantity = (TextView) tempView.findViewById(R.id.previousOrderFoodQuantity);
			myLI.totalPriceOfRow = (TextView) tempView.findViewById(R.id.previousOrderRowPrice);
			tempView.setTag(myLI);
		}
		else{
			myLI = (MyListItem) tempView.getTag();
		}		if(orderMenuList.size() < 1)
		{
			myLI.foodName.setText("No Items Found");
		}else
		{
			myLI.foodName.setText(currentData.getFoodName());
			myLI.foodPrice.setText("Rs."+currentData.getPrice());
			myLI.foodQuantity.setText(""+currentData.getOrderId());
			myLI.totalPriceOfRow.setText("Rs."+currentData.getPrice()*currentData.getQuantity());
		}
		return tempView;
	}
}