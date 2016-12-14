package com.wxf.rpcalu;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends Activity {

	private TextView tv_name;
	private TextView tv_sex;
	private TextView tv_result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		tv_name = (TextView) findViewById(R.id.tv_name);
		tv_sex = (TextView) findViewById(R.id.tv_sex);
		tv_result = (TextView) findViewById(R.id.tv_result);
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		tv_name.setText(name);
		int sex = intent.getIntExtra("sex", 0);
		byte[] bytes =null;
		try {
			switch (sex) {
			case 1:
				tv_sex.setText("ÄÐ");
				bytes = name.getBytes("gbk");
				break;
			case 2:
				tv_sex.setText("Å®");
				bytes = name.getBytes("utf-8");
				break;
			case 3:
				tv_sex.setText("ÈËÑý");
				bytes = name.getBytes("iso-8859-1");
				break;

			}
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		int num=0;
		
		for (byte b : bytes) {
			 num = b & 0xff %100;
		}
		if(num>90){
			tv_result.setText("good");
		}else if(num>40){
			tv_result.setText("nice");
		}else if(num>10){
			tv_result.setText("terrible");
		}else{
			tv_result.setText("......");
		}
	}

}
