package com.ruben.trabajo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class CkBox extends Activity
{
	CheckBox chkBoxCycling;
	CheckBox chkBoxTeaching;
	CheckBox chkBoxBlogging;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ckbox);

		initialUISetup();
	}

	public void initialUISetup()
	{
		chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
		chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
		chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
	}

	public void getHobbyClick(View v)
	{
		String strMessage = "";

		if(chkBoxCycling.isChecked())
		{
			strMessage+=" Fresa";
		}

		if(chkBoxTeaching.isChecked())
		{
			strMessage+=" Limón";
		}

		if(chkBoxBlogging.isChecked())
		{
			strMessage+=" Mango";
		}
		
		

		showTextNotification(strMessage);
	}

	public void showTextNotification(String msgToDisplay)
	{
	    	Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
	}
}