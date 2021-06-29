package com.giftproject.giftidea.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.giftproject.giftidea.R;
import com.giftproject.giftidea.activity.FullGiftListActivity;
import com.giftproject.giftidea.model.Gift;

import java.util.List;

public class GiftCategoryAdapter extends RecyclerView.Adapter<GiftCategoryAdapter.ViewHolder> {
   private List<Gift> giftList;
   private Context context;

    public GiftCategoryAdapter(List<Gift> giftList, Context context) {
        this.giftList = giftList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gift_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Gift giftCategory = giftList.get(position);
        holder.giftCategoryImg.setImageResource(giftCategory.getGiftCategoryImg());
        holder.giftCategoryName.setText(giftCategory.getGiftCategoryName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullGiftListActivity.class);
                intent.putExtra("positionNumber",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return giftList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView giftCategoryName;
        private ImageView giftCategoryImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            giftCategoryName = itemView.findViewById(R.id.giftCategoryTvId);
            giftCategoryImg = itemView.findViewById(R.id.giftCategoryIvId);
        }
    }
}
