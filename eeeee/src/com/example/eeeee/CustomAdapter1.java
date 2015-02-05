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
import android.widget.TextView;

public class CustomAdapter1 extends BaseAdapter{

	List<String> list=new ArrayList<String>();
	public static LayoutInflater inflater = null;


	public CustomAdapter1(Activity a) {
		inflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		list.add("pawan");
		Log.i("CustomAdapter1", "Constructor");
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int index, View view,final ViewGroup parent) {
		View tempView = view;
		Header header;
		Log.i("CustomAdapter1", "1");
		String s=list.get(index);
		//header.name=L
		if (view==null) {
			tempView = inflater.inflate(R.layout.customadapter1, parent, false);	
			header = new Header();
			header.name=(TextView)tempView.findViewById(R.id.name1);
			Log.i("CustomAdapter1", "getViewEnd");
		}
		else{
			header = (Header) tempView.getTag();
		}
		if(list.size() < 1)
		{
			header.name.setText("No Items Found");
		}else
		{
			header.name.setText(s);
		}
		return tempView;
	}

	public static class Header{
		TextView name;
	}
}
