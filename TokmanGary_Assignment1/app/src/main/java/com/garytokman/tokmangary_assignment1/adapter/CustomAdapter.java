package com.garytokman.tokmangary_assignment1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.garytokman.tokmangary_assignment1.R;
import com.garytokman.tokmangary_assignment1.model.Person;

import java.util.List;

/**
 * Created by gtokman1 on 8/20/16.
 */
public class CustomAdapter extends BaseAdapter {

    private Context mContext;
    private List<Person> mPersonList;

    public CustomAdapter(Context context, List<Person> personList) {
        mContext = context;
        mPersonList = personList;
    }

    @Override
    public int getCount() {
        return mPersonList.size();
    }

    @Override
    public Object getItem(int i) {
        return mPersonList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.custom_item, null);

            viewHolder = new ViewHolder(view);

            view.setTag(viewHolder);

        } else {
           viewHolder = (ViewHolder) view.getTag();
        }

        // Set UI
        viewHolder.mNameTextView.setText(mPersonList.get(i).getName());
        viewHolder.mAgeTextView.setText(String.format("Age: %d", mPersonList.get(i).getAge()));
        viewHolder.mImageView.setImageResource(mPersonList.get(i).getProfileImage());


        return view;
    }

    private static class ViewHolder {
        private TextView mNameTextView;
        private TextView mAgeTextView;
        private ImageView mImageView;

        public ViewHolder(View view) {
            mNameTextView = (TextView) view.findViewById(R.id.name_text_view);
            mAgeTextView = (TextView) view.findViewById(R.id.age_text_view);
            mImageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
