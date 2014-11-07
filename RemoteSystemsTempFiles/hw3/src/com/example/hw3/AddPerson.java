// This program will allow the user to add a new current contact.The contact  //
// is saved to file after the user completes filling all the field.The action // 
// bar has button for clearing and saving the contact.						  //

package com.example.hw3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddPerson extends Activity {

	private PersonList c;
	private EditText fname, lname, email, phone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);

		// Getting the details from other activity
		c = (PersonList) getIntent().getSerializableExtra("19101992");
		if (c == null) {
			c = new PersonList();
		}
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.addmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_add) {
			saveContact();
		}
		if (id == R.id.action_discard) {
			clear();
		}
		return super.onOptionsItemSelected(item);
	}

	// Clearing all the editable fields
	public void clear() {

		fname.setText("");
		lname.setText("");
		phone.setText("");
		email.setText("");
	}

	// Initializing all the editing fields
	public void init() {
		fname = (EditText) findViewById(R.id.FName);
		lname = (EditText) findViewById(R.id.LName);
		phone = (EditText) findViewById(R.id.Phone);
		email = (EditText) findViewById(R.id.Email);
	}

	// Saves the user details to the bundle for passing to other activities
	public void saveContact() {

		Intent mIntent = new Intent(this, MainActivity.class);
		Bundle mBundle = new Bundle();

		String t = fname.getText().toString();
		if ((t == "") || (t == " ") || (t.isEmpty()==true)) {
			Toast.makeText(getApplicationContext(),
					"Enter First Name and then save", Toast.LENGTH_LONG).show();
		} else {
			c.add(new Person(fname.getText().toString(), lname.getText()
					.toString(), phone.getText().toString(), email.getText()
					.toString()));
			mBundle.putSerializable("19101992", c);
			mIntent.putExtras(mBundle);

			startActivity(mIntent);
			finish();
		}
	}
}
