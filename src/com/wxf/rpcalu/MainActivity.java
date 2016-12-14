package com.wxf.rpcalu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_name;
	private RadioGroup rg_group;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_name = (EditText) findViewById(R.id.et_name);
		Button bt_calu = (Button) findViewById(R.id.bt_calu);
		rg_group = (RadioGroup) findViewById(R.id.rg_group);
	}

	public void click(View v) {
		String name = et_name.getText().toString().trim();
		if(TextUtils.isEmpty(name)){
			Toast.makeText(getApplicationContext(), "名字不能为空", 1).show();
			return;
		}
		int checkedRadioButtonId = rg_group.getCheckedRadioButtonId();
		int sex=0;
		switch (checkedRadioButtonId) {
		case R.id.rb_male:
			sex=1;
			break;
		case R.id.rb_female:
			sex=2;
			break;
		case R.id.rb_other:
			sex=3;
			break;

		}
		if(sex==0){
			Toast.makeText(getApplicationContext(), "请选择性别", 1).show();
			return;
		}
           Intent intent = new Intent(this,ResultActivity.class);
           intent.putExtra("name", name);
           intent.putExtra("sex", sex);
           startActivity(intent);
           
	}
}
