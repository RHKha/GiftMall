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
public class AnniversaryGiftFragment extends Fragment {

    private RecyclerView anniversaryRv;
    private FullGiftListAdapter fullGiftListAdapter;
    private List<Gift> fullGiftList;
    private DatabaseReference databaseReference;
    public AnniversaryGiftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anniversary_gift_, container, false);

        init(view);

        configRv();

        getGiftItem();

        return view;
    }




    private void init(View view) {
        anniversaryRv = view.findViewById(R.id.anniversaryGiftRvId);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Gifts");
        fullGiftList = new ArrayList<>();
        fullGiftListAdapter = new FullGiftListAdapter(fullGiftList,getContext());
    }

    private void configRv() {
        anniversaryRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        anniversaryRv.setAdapter(fullGiftListAdapter);
    }

    private void getGiftItem() {
        DatabaseReference showAnniversaryGiftRef = databaseReference.child("Anniversary Gift");

        showAnniversaryGiftRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    fullGiftList.clear();
                    for (DataSnapshot data:dataSnapshot.getChildren()){
                        fullGiftList.clear();
                        Gift gift = data.getValue(Gift.class);
                        fullGiftList.add(gift);
                        fullGiftListAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
