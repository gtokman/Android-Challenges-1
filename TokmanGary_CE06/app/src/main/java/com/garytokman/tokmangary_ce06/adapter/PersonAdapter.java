package com.garytokman.tokmangary_ce06.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.garytokman.tokmangary_ce06.R;
import com.garytokman.tokmangary_ce06.model.Person;

import java.util.List;

/**
 * Created by gtokman1 on 8/11/16.
 */
public class PersonAdapter extends BaseAdapter {

    private Context mContext;
    private List<Person> mPeople;

    public PersonAdapter(Context context, List<Person> people) {
        mContext = context;
        mPeople = people;
    }

    @Override
    public int getCount() {
        return mPeople.size();
    }

    @Override
    public Object getItem(int i) {
        return mPeople.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder;


        if (view == null) {

            view = LayoutInflater.from(mContext).inflate(R.layout.custom_adapter, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
           viewHolder = (ViewHolder) view.getTag();
        }

        // Set labels & image
        viewHolder.firstName.setText(mPeople.get(i).getFirstName());
        viewHolder.lastName.setText(mPeople.get(i).getLastName());
        viewHolder.birthday.setText(mPeople.get(i).getBirthday());
        viewHolder.profileImage.setImageResource(mPeople.get(i).getPicture());


        return view;
    }

    private static class ViewHolder {
        TextView firstName;
        TextView lastName;
        TextView birthday;
        ImageView profileImage;

        public ViewHolder(View view) {
            firstName = (TextView) view.findViewById(R.id.firstNameLabel);
            lastName = (TextView) view.findViewById(R.id.lastNameLabel);
            birthday = (TextView) view.findViewById(R.id.birthdayLabel);
            profileImage = (ImageView) view.findViewById(R.id.profileImage);
        }
    }
}
