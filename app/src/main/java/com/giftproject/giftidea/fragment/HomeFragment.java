package com.giftproject.giftidea.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.giftproject.giftidea.R;
import com.giftproject.giftidea.adapter.GiftCategoryAdapter;
import com.giftproject.giftidea.model.Gift;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private List<Gift> giftList;
    private RecyclerView homeGiftRv;
    private GiftCategoryAdapter giftCategoryAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        init(view);

        configRv();

        getData();
    return view;
    }





    private void init(View view) {
        giftList = new ArrayList<>();
        homeGiftRv = view.findViewById(R.id.homeGiftRvId);
        giftCategoryAdapter = new GiftCategoryAdapter(giftList,getContext());
    }

    private void configRv() {
        homeGiftRv.setLayoutManager(new GridLayoutManager(getActivity().getBaseContext(),2));
        homeGiftRv.setAdapter(giftCategoryAdapter);
    }

    private void getData() {
        Gift giftCategory1 = new Gift("Anniversary Gift",R.drawable.anniversary_gift);
        Gift giftCategory2 = new Gift("Birthday Gift",R.drawable.birthday_gift);
        Gift giftCategory3 = new Gift("Baby and Child Gift",R.drawable.baby_and_childe_gift);
        Gift giftCategory4 = new Gift("Christmas Gift",R.drawable.christmas_gift);
        Gift giftCategory5 = new Gift("Couple Gift",R.drawable.couple_gift);
        Gift giftCategory6 = new Gift("Friendship Gift",R.drawable.friendship_gift);
        Gift giftCategory7 = new Gift("Festival Gift",R.drawable.festival_gift);
        Gift giftCategory8 = new Gift("New Year Gift",R.drawable.new_year_gift);
        Gift giftCategory9 = new Gift("Parents Gift",R.drawable.parents_gift);
        Gift giftCategory10 = new Gift("Romantic Gift",R.drawable.romantic_gift);
        Gift giftCategory11 = new Gift("Valentine  Gift",R.drawable.valentine_gift);
        Gift giftCategory12 = new Gift("Wedding Gift",R.drawable.wedding_gift);

        giftList.add(giftCategory1);
        giftList.add(giftCategory2);
        giftList.add(giftCategory3);
        giftList.add(giftCategory4);
        giftList.add(giftCategory5);
        giftList.add(giftCategory6);
        giftList.add(giftCategory7);
        giftList.add(giftCategory8);
        giftList.add(giftCategory9);
        giftList.add(giftCategory10);
        giftList.add(giftCategory11);
        giftList.add(giftCategory12);
    }
}
