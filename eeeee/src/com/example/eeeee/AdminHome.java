package com.example.eeeee;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdminHome extends Activity{

	Button adminChangePassword,addAdmin,addMenu;
	final Context context=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adminhome);
		adminChangePassword=(Button)findViewById(R.id.adminChangePassword);
		addAdmin=(Button)findViewById(R.id.addAdmin);
		addMenu=(Button)findViewById(R.id.addMenu);
		adminChangePassword.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent=new Intent(context,ChangePassword.class);
				startActivity(intent);
			}
		} );
		addAdmin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent=new Intent(context,AddAdmin.class);
				startActivity(intent);
			}
		} );
		addMenu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent=new Intent(context,AddMenu.class);
				startActivity(intent);
			}
		} );
	}
}
