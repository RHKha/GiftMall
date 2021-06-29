package com.giftproject.giftidea.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.giftproject.giftidea.R;
import com.giftproject.giftidea.model.GiftCard;

import java.util.List;

public class GiftCardAdapter extends RecyclerView.Adapter<GiftCardAdapter.ViewHolder> {
    private List<GiftCard> giftCardList;
    private ViewPager2 viewPager2;

    public GiftCardAdapter(List<GiftCard> giftCardList, ViewPager2 viewPager2) {
        this.giftCardList = giftCardList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gift_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final GiftCard giftCard = giftCardList.get(position);
        holder.giftCardIv.setImageResource(giftCard.getGiftCardImg());
    }

    @Override
    public int getItemCount() {
        return giftCardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView giftCardIv;
        private Button giftCardBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            giftCardIv = itemView.findViewById(R.id.itemGiftCardIvId);
            giftCardBtn = itemView.findViewById(R.id.itemGiftCardBtnId);
        }
    }
}
