package com.giftproject.giftidea.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.giftproject.giftidea.R;
import com.giftproject.giftidea.model.Gift;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FullGiftListAdapter extends RecyclerView.Adapter<FullGiftListAdapter.ViewHolder> {
    private List<Gift> fullGiftList;
    private Context context;

    public FullGiftListAdapter(List<Gift> fullGiftList, Context context) {
        this.fullGiftList = fullGiftList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gift_full_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Gift fullListGift = fullGiftList.get(position);

        Picasso.get().load(fullListGift.getFullListGiftImg()).into(holder.giftImg);
        holder.giftPriceTv.setText(fullListGift.getGiftPrice());
        holder.giftTitleTv.setText(fullListGift.getGiftTitle());
    }

    @Override
    public int getItemCount() {
        return fullGiftList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView giftTitleTv,giftPriceTv;
        private Button buyGiftBtn;
        private ImageView giftImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            giftImg = itemView.findViewById(R.id.fullListGiftIvId);
            giftTitleTv = itemView.findViewById(R.id.fullListGiftTitleTvId);
            giftPriceTv = itemView.findViewById(R.id.fullListGiftPriceTvId);
            buyGiftBtn = itemView.findViewById(R.id.fullListGiftBuyBtnId);
        }
    }
}
