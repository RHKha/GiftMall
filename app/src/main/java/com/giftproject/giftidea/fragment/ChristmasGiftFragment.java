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
public class ChristmasGiftFragment extends Fragment {

    private RecyclerView christmasGiftRv;
    private List<Gift> christmasGiftList;
    private FullGiftListAdapter christmasGiftAdapter;
    private DatabaseReference databaseReference;
    public ChristmasGiftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_christmas_gift, container, false);

        init(view);

        configRv();

        getChristmasItem();

        return view;
    }



    private void init(View view) {
        christmasGiftRv = view.findViewById(R.id.christmasGiftRvId);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Gifts");
        christmasGiftList = new ArrayList<>();
        christmasGiftAdapter = new FullGiftListAdapter(christmasGiftList,getContext());
    }

    private void configRv() {
        christmasGiftRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        christmasGiftRv.setAdapter(christmasGiftAdapter);
    }

    private void getChristmasItem() {
        DatabaseReference showChristmasGiftRef = databaseReference.child("Christmas Gift");

        showChristmasGiftRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    christmasGiftList.clear();
                    for (DataSnapshot data:dataSnapshot.getChildren()){
                        Gift gift = data.getValue(Gift.class);
                        christmasGiftList.add(gift);
                        christmasGiftAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
