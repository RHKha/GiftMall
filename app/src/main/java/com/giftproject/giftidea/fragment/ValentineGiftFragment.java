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
public class ValentineGiftFragment extends Fragment {

    private RecyclerView valentineGiftRv;
    private List<Gift> valentineGiftList;
    private FullGiftListAdapter valentineGiftAdapter;
    private DatabaseReference databaseReference;

    public ValentineGiftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_valentine_gift, container, false);

        init(view);

        configRv();

        getValentineItem();
        return view;
    }



    private void init(View view) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Gifts");
        valentineGiftRv = view.findViewById(R.id.valentineGiftRvId);
        valentineGiftList = new ArrayList<>();
        valentineGiftAdapter = new FullGiftListAdapter(valentineGiftList,getContext());

    }

    private void configRv() {
        valentineGiftRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        valentineGiftRv.setAdapter(valentineGiftAdapter);
    }
    private void getValentineItem() {
        DatabaseReference showBirthdayGiftRef = databaseReference.child("Valentine  Gift");

        showBirthdayGiftRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    valentineGiftList.clear();
                    for (DataSnapshot data:dataSnapshot.getChildren()){
                        Gift gift = data.getValue(Gift.class);
                        valentineGiftList.add(gift);
                        valentineGiftAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
