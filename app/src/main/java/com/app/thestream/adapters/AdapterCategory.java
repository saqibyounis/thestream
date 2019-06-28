package com.app.thestream.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.thestream.Config;
import com.app.thestream.R;
import com.app.thestream.models.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import info.awesomedevelopment.tvgrid.library.TVGridView;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.ViewHolder> {

    private List<Category> items = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;
    private OnKeyListener mOnKeyListerner;
    private TVGridView tvGridView;

    public interface OnItemClickListener {
        void onItemClick(View view, Category obj, int position);
    }

    public interface OnKeyListener{

        void onItemClick(View view, Category obj, int position);
    }
     public void setmOnKeyListerner(final OnKeyListener keyListerner){

        this.mOnKeyListerner=keyListerner;
     }
    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterCategory(Context context, List<Category> items,TVGridView tvGridView) {
        this.items = items;
        this.tvGridView=tvGridView;
        ctx = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView category_name;
        public ImageView category_image;
        public LinearLayout lyt_parent;

        public ViewHolder(View v) {
            super(v);
            category_name = (TextView) v.findViewById(R.id.category_name);
            category_image = (ImageView) v.findViewById(R.id.category_image);
            lyt_parent = (LinearLayout) v.findViewById(R.id.lyt_parent);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lsv_item_category, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Category c = items.get(position);
        holder.itemView.setFocusable(true); holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(final View view, final boolean b) {
                tvGridView.selectView(view, b);
            }
        });
        holder.category_name.setText(c.category_name);

        Picasso.with(ctx)
                .load(Config.ADMIN_PANEL_URL + "/upload/category/" + c.category_image)
                .placeholder(R.drawable.ic_thumbnail)
                .into(holder.category_image);

        holder.lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, c, position);
                }
            }
        });

        holder.lyt_parent.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(KeyEvent.KEYCODE_DPAD_CENTER==keyCode)
                    mOnKeyListerner.onItemClick(v,c,position);

                return false;
            }
        });
    }

    public void setListData(List<Category> items){
        this.items = items;
        notifyDataSetChanged();
    }

    public void resetListData() {
        this.items = new ArrayList<>();
        notifyDataSetChanged();
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

}