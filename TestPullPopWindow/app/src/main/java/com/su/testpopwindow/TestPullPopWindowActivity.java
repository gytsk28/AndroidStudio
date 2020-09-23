package com.su.testpopwindow;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class TestPullPopWindowActivity extends Activity {
	private PopMenu popMenu;
	private Context context;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		context = TestPullPopWindowActivity.this;
		popMenu = new PopMenu(context);
		popMenu.addItems(new String[] { "停发", "延期", "删除", "备注", "修改" });
		// 菜单项点击监听器
		popMenu.setOnItemClickListener(popmenuItemClickListener);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				popMenu.showAsDropDown(v);
			}
		});

	}

	// 弹出菜单监听器
	OnItemClickListener popmenuItemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Toast.makeText(TestPullPopWindowActivity.this,String.valueOf(position), Toast.LENGTH_LONG).show();
			//System.out.println("下拉菜单点击" + position);
			popMenu.dismiss();
		}
	};
}