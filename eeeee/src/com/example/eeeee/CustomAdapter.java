package com.example.eeeee;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter {
	ArrayList<FoodDetails> menu;
	Button increment,decrement;
	public static LayoutInflater inflater = null;
	EditText displayCount;
	public static List<FoodDetails> orderMenuList=new ArrayList<FoodDetails>();
	public Button other_order;

	public CustomAdapter(Activity a) {
		Log.i("CustomAdapter",TypesOfFoodList.item);

		inflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		menu = new ArrayList<FoodDetails>();
		if(TypesOfFoodList.item.equals("chapati")){
			menu.add(new FoodDetails("Tandoori Roti", 10, 0));
			menu.add(new FoodDetails("Naan", 20, 0));
			menu.add(new FoodDetails("Aloo Paratha", 25, 0));
		}else if(TypesOfFoodList.item.equals("starters")){
			menu.add(new FoodDetails("Gobi Manchurian", 70, 0));
			menu.add(new FoodDetails("ChillyPaneer", 120, 0));
			menu.add(new FoodDetails("Veg Cutlet", 50, 0));
		}else if(TypesOfFoodList.item.equals("nonVegCurries")){
			menu.add(new FoodDetails("Chicken Hyderabadi", 170, 0));
			menu.add(new FoodDetails("Chicken dopyaza", 200, 0));
		}

	}

	@Override
	public int getCount() {
		return menu.size();    
	}

	@Override
	public Object getItem(int i) {
		return menu.get(i);   
	}

	@Override
	public long getItemId(int i) {
		return i;                  
	}

	public static class MyListItem{
		public TextView name;
		public TextView price;
		public Button btnDec;
		public EditText textValue;
		public Button btnInc;

	}

	@Override
	public View getView(int index, View view, final ViewGroup parent) {

		View tempView = view;
		MyListItem myLI;
		FoodDetails currentData = menu.get(index);

		if (view == null) {
			tempView = inflater.inflate(R.layout.addorderview, parent, false);	
			myLI = new MyListItem();
			myLI.name = (TextView) tempView.findViewById(R.id.food_name);
			myLI.price =(TextView) tempView.findViewById(R.id.food_price);
			myLI.btnInc = (Button) tempView.findViewById(R.id.increment);
			myLI.btnDec = (Button) tempView.findViewById(R.id.decrement);
			myLI.textValue = (EditText) tempView.findViewById(R.id.count);
			other_order=(Button) tempView.findViewById(R.id.other_order);
			tempView.setTag(myLI);
		}
		else{
			myLI = (MyListItem) tempView.getTag();
		}		if(menu.size() < 1)
		{
			myLI.name.setText("No Items Found");
		}else
		{
			myLI.name.setText(currentData.getFoodName());
			myLI.price.setText("Rs."+currentData.getPrice());
		}


		myLI.btnInc.setOnClickListener(new View.OnClickListener() {


			//Boolean temp=false;
			@Override
			public void onClick(final View view) {
				FoodDetails foodDetails=new FoodDetails();;
				TextView foodName=(TextView)(((ViewGroup)view.getParent()).getChildAt(0));
				TextView foodPrice=(TextView)(((ViewGroup)view.getParent()).getChildAt(1));
				EditText quantity = (EditText)(((ViewGroup)view.getParent()).getChildAt(3));
				String[] price=foodPrice.getText().toString().split("\\.");			
				int count=Integer.parseInt(quantity.getText().toString())+1;
				Boolean temp=false;
				quantity.setText("" + count);
				foodDetails=new FoodDetails();
				foodDetails.setFoodName(foodName.getText()+"");
				foodDetails.setQuantity(count);	
				foodDetails.setPrice(Integer.parseInt(price[1]));
				for(int i=0;i<orderMenuList.size();i++){
					if(((orderMenuList.get(i).getFoodName()).equals(foodName.getText()+""))||(count==0)){

						Log.i("CustomAdapter", orderMenuList.get(i).getFoodName()+"");
						Log.i("CustomAdapter", foodName.getText()+"");
						Log.i("CustomAdapter", "Count :"+count);
						orderMenuList.remove(i);
						if(count==0){
							temp=true;
						}
					}
				}if (temp==false) {
					orderMenuList.add(foodDetails);
				}
				Log.i("CustomAdapter", "Size :"+orderMenuList.size()+"");
			}
		});
		myLI.btnDec.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View view) {
				int i=0;
				FoodDetails foodDetails=new FoodDetails();
				TextView foodName=(TextView)(((ViewGroup)view.getParent()).getChildAt(0));
				TextView foodPrice=(TextView)(((ViewGroup)view.getParent()).getChildAt(1));
				EditText quantity = (EditText)(((ViewGroup)view.getParent()).getChildAt(3));
				String[] price=foodPrice.getText().toString().split("\\.");				
				int count=Integer.parseInt(quantity.getText().toString())-1;
				Boolean temp=false;
				if(count>=0){
					quantity.setText("" + count);
				}else{
					count++;
					quantity.setText("" + count);	
				}
				foodDetails=new FoodDetails();
				foodDetails.setFoodName(foodName.getText()+"");
				foodDetails.setQuantity(count);	
				foodDetails.setPrice(Integer.parseInt(price[1]));
				for(i=0;i<orderMenuList.size();i++){
					if((orderMenuList.get(i).getFoodName()).equals(foodName.getText()+"")){

						Log.i("CustomAdapter", orderMenuList.get(i).getFoodName()+"");
						Log.i("CustomAdapter", foodName.getText()+"");
						Log.i("CustomAdapter", "Count :"+count);
						if(count==0){
							orderMenuList.remove(i);
							temp=true;
							break;
						}
					}
				}	
				Log.i("CustomAdapter", "Size :"+orderMenuList.size()+"");
			}
		});
		return tempView;
	}
}