// This program will a contact by filling in the name and phone number.//

package com.example.hw3;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Person> {

	public CustomAdapter(Context context, ArrayList<Person> users) {
		super(context, 0, users);

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Person p = getItem(position);

		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.listadapter, parent, false);
		}

		TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
		TextView tvphNumber = (TextView) convertView.findViewById(R.id.tvPhone);

		tvName.setText(p.getFname() + " " + p.getLname());
		tvphNumber.setText(p.getPhone());

		return convertView;
	}
	}