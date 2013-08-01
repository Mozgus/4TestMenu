package ru.nav.testmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/*
 * For GitHub realize
 * */

public class MainActivity extends Activity {
	
	// UI components
	private EditText editText1 = null;
	private TextView textView1 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// Load UI components
		editText1 = (EditText) findViewById(R.id.editText1);
		textView1 = (TextView) findViewById(R.id.textView1);
		
		// Register UI component for Context menu
		registerForContextMenu(textView1);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.context, menu);		
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.mn_clear:
				textView1.setText("");			
				return true;
	
			default: return super.onContextItemSelected(item);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// menu.add("Доп.пункт1");
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
		
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//tvText.setText(item.getTitle());
		
		switch (item.getItemId()) {
			
			// Menu "Copy"
			case R.id.mn_copy:
				// textView1.setText(item.getTitle());
				textView1.setText(editText1.getText());
				return true;
			
			// Menu "Copy all text"
			case R.id.mn_copy_all: 
				textView1.setText(editText1.getText());
				return true;
			
			// Menu "Copy first string"
			case R.id.mn_copy_first:
				String Str = editText1.getText().toString().trim();
				int pos = Str.indexOf(" ");
				if (pos != -1)
					Str = Str.substring(0, pos);
				textView1.setText(Str);
				return true;

			default:
				return super.onContextItemSelected(item);
		}		
	}
}
