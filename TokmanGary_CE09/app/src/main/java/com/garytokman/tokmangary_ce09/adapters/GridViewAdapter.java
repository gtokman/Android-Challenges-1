package com.garytokman.tokmangary_ce09.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.garytokman.tokmangary_ce09.R;
import com.garytokman.tokmangary_ce09.model.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gtokman1 on 8/18/16.
 */
public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<Book> mJsonData;

    public GridViewAdapter(Context context, List<Book> jsonData) {
        mContext = context;
        mJsonData = jsonData;
    }

    @Override
    public int getCount() {
        return mJsonData.size();
    }

    @Override
    public Object getItem(int i) {
        return mJsonData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view == null) {

            view = LayoutInflater.from(mContext).inflate(R.layout.grid_items, null);

            viewHolder = new ViewHolder(view);

            // Set for reuse
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        // Set UI
        viewHolder.mBookTitle.setText(mJsonData.get(i).getTitle());
        Picasso.with(mContext).load(mJsonData.get(i).getImage()).into(viewHolder.mBookImage);

        return view;
    }

    private static class ViewHolder {

        ImageView mBookImage;
        TextView mBookTitle;

        public ViewHolder(View view) {

            mBookTitle = (TextView) view.findViewById(R.id.book_text_view);
            mBookImage = (ImageView) view.findViewById(R.id.book_image);

        }
    }
}
