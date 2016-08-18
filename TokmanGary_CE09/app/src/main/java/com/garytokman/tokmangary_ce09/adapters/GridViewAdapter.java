package com.garytokman.tokmangary_ce09.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.garytokman.tokmangary_ce09.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gtokman1 on 8/18/16.
 */
public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private List mJsonData;

    public GridViewAdapter(Context context, List jsonData) {
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

            viewHolder = new ViewHolder(mContext);

            // Set for reuse
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        // Set UI



        return null;
    }

    private static class ViewHolder {
        @BindView(R.id.book_image)
        ImageView mBookImage;

        @BindView(R.id.book_text_view)
        EditText mBookTitle;

        public ViewHolder(Context context) {
            ButterKnife.bind((Activity) context);
        }
    }
}
