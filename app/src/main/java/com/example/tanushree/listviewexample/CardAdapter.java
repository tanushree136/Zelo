package com.example.tanushree.listviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanu shree on 28-11-2015.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> implements ItemTouchHelperAdapter{

    List<AndroidVersion> mItems;

    public CardAdapter(Context context) {
        super();

        mItems = new ArrayList<AndroidVersion>();
        AndroidVersion version = new AndroidVersion();
        version.setName("Alpha");
        version.setThumbnail(R.drawable.android);
        mItems.add(version);

        version = new AndroidVersion();
        version.setName("Beta");
        version.setThumbnail(R.drawable.android);
        mItems.add(version);

        version = new AndroidVersion();
        version.setName("CupCake");
        version.setThumbnail(R.drawable.cupcake);
        mItems.add(version);

        version = new AndroidVersion();
        version.setName("Donut");
        version.setThumbnail(R.drawable.donut);
        mItems.add(version);

        version = new AndroidVersion();
        version.setName("Eclair");
        version.setThumbnail(R.drawable.eclair);
        mItems.add(version);

        version = new AndroidVersion();
        version.setName("Froyo");
        version.setThumbnail(R.drawable.froyo);
        mItems.add(version);

        version = new AndroidVersion();
        version.setName("Gingerbread");
        version.setThumbnail(R.drawable.gingerbread);
        mItems.add(version);

        version = new AndroidVersion();
        version.setName("HoneyComb");
        version.setThumbnail(R.drawable.honeycomb);
        mItems.add(version);

        version = new AndroidVersion();
        version.setName("Ice Cream Sandwich");
        version.setThumbnail(R.drawable.icecreamsandwich);
        mItems.add(version);

        version = new AndroidVersion();
        version.setName("Kitkat");
        version.setThumbnail(R.drawable.kitkat);
        mItems.add(version);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ls_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        AndroidVersion version = mItems.get(i);
        viewHolder.tvVersion.setText(version.getName());
        viewHolder.imgThumbnail.setImageResource(version.getThumbnail());
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }


    public void addItemAt(int position)
    {
        AndroidVersion version = new AndroidVersion();
        version.setName("New Item");
        version.setThumbnail(R.drawable.android);
        mItems.add(position,version);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder{

        public ImageView imgThumbnail;
        public TextView tvVersion;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvVersion = (TextView)itemView.findViewById(R.id.tv_nature);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }

    }

}
