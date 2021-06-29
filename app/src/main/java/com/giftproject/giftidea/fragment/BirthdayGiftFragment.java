package com.giftproject.giftidea.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.giftproject.giftidea.R;
import com.giftproject.giftidea.adapter.FullGiftListAdapter;
import com.giftproject.giftidea.model.Gift;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BirthdayGiftFragment extends Fragment {

    private RecyclerView birthDayGiftRv;
    private List<Gift> birthdayGiftList;
    private FullGiftListAdapter birthDayGiftAdapter;
    private DatabaseReference databaseReference;

    public BirthdayGiftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_birthday_gift, container, false);

        init(view);

        configRv();

        getBirthdayItem();

        return view;
    }



    private void init(View view) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Gifts");
        birthDayGiftRv = view.findViewById(R.id.birthdayGiftRvId);
        birthdayGiftList = new ArrayList<>();
        birthDayGiftAdapter = new FullGiftListAdapter(birthdayGiftList,getContext());

    }

    private void configRv() {
        birthDayGiftRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        birthDayGiftRv.setAdapter(birthDayGiftAdapter);
    }

    private void getBirthdayItem() {
        DatabaseReference showBirthdayGiftRef = databaseReference.child("Birthday Gift");

        showBirthdayGiftRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    birthdayGiftList.clear();
                    for (DataSnapshot data:dataSnapshot.getChildren()){
                        Gift gift = data.getValue(Gift.class);
                        birthdayGiftList.add(gift);
                        birthDayGiftAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
