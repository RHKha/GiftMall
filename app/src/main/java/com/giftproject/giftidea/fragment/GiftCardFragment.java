package com.giftproject.giftidea.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.giftproject.giftidea.R;
import com.giftproject.giftidea.adapter.GiftCardAdapter;
import com.giftproject.giftidea.model.GiftCard;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GiftCardFragment extends Fragment {

    private ViewPager2 viewPager2;
    private List<GiftCard> giftCardList;
    private GiftCardAdapter giftCardAdapter;
    public GiftCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gift_card, container, false);

        viewPager2 = view.findViewById(R.id.giftCardViewPager2Id);
        giftCardList = new ArrayList<>();
        giftCardAdapter = new GiftCardAdapter(giftCardList,viewPager2);


        giftCardList.add(new GiftCard(R.drawable.old_navy_gift_card));
        giftCardList.add(new GiftCard(R.drawable.itunes_gift_card));
        giftCardList.add(new GiftCard(R.drawable.google_gift_card));
        giftCardList.add(new GiftCard(R.drawable.amazon_gift_card));
        giftCardList.add(new GiftCard(R.drawable.xbox_gift_card));

        viewPager2.setAdapter(giftCardAdapter);

        return view;
    }
}
