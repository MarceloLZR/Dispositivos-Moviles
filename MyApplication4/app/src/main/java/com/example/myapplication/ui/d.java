package com.example.myapplication.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private Context mContext;
    private List<Contact> mContactList;

    public ContactAdapter(Context context, int resource, List<Contact> contactList) {
        super(context, resource, contactList);
        mContext = context;
        mContactList = contactList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item_contact, parent, false);
        }

        Contact currentContact = mContactList.get(position);

        TextView name = listItem.findViewById(R.id.textViewName);
        name.setText(currentContact.getName());

        TextView age = listItem.findViewById(R.id.textViewAge);
        age.setText(String.valueOf(currentContact.getAge()));

        TextView gender = listItem.findViewById(R.id.textViewGender);
        gender.setText(currentContact.getGender());

        return listItem;
    }
}
