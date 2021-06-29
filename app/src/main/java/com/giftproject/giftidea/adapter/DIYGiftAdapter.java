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

import java.util.List;

public class DIYGiftAdapter extends RecyclerView.Adapter<DIYGiftAdapter.ViewHolder> {
    private List<Gift> christmasGiftList;
    private Context context;

    public DIYGiftAdapter(List<Gift> christmasGiftList, Context context) {
        this.christmasGiftList = christmasGiftList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gift_diy,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Gift diyGift = christmasGiftList.get(position);

//        Picasso.get().load(christmasGift.getFullListGiftImg()).into(holder.giftImg);
//        holder.giftPriceTv.setText(christmasGift.getGiftPrice());
//        holder.giftTitleTv.setText(christmasGift.getGiftTitle());
    }

    @Override
    public int getItemCount() {
        return christmasGiftList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView giftTitleTv,giftPriceTv;
        private Button buyGiftBtn;
        private ImageView giftImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            giftImg = itemView.findViewById(R.id.fullListGiftIvId);
//            giftTitleTv = itemView.findViewById(R.id.fullListGiftTitleTvId);
//            giftPriceTv = itemView.findViewById(R.id.fullListGiftPriceTvId);
//            buyGiftBtn = itemView.findViewById(R.id.fullListGiftBuyBtnId);

        }
    }
}
