package com.giftproject.giftidea.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

public class FullGiftListActivity extends AppCompatActivity {

    private int positionNum;
    private RecyclerView fullLisGiftRv;
    private List<Gift> fullGiftList;
    private FullGiftListAdapter fullGiftListAdapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_gift_list);


        init();

        positionNum = getIntent().getIntExtra("positionNumber",0);

        configRV();

        getGiftItem();
    }




    private void init() {
        fullLisGiftRv = findViewById(R.id.fullListGiftRvId);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Gifts");
        fullGiftList = new ArrayList<>();
        fullGiftListAdapter = new FullGiftListAdapter(fullGiftList,FullGiftListActivity.this);
    }

    private void configRV() {
        fullLisGiftRv.setLayoutManager(new GridLayoutManager(this,2));
        fullLisGiftRv.setAdapter(fullGiftListAdapter);
    }

    private void getGiftItem() {
        if(positionNum == 0){
            setTitle("Anniversary Gift");
            DatabaseReference showAnniversaryGiftRef = databaseReference.child("Anniversary Gift");

            showAnniversaryGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
        if(positionNum == 1){
            setTitle("Birthday Gift");
            DatabaseReference showBirthdayGiftRef = databaseReference.child("Birthday Gift");
            showBirthdayGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
        if(positionNum == 2){
            setTitle("Baby and Child Gift");
            DatabaseReference showBaby_andChildGiftRef = databaseReference.child("Baby and Child Gift");
            showBaby_andChildGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
        if(positionNum == 3){
            setTitle("Christmas Gift");
            DatabaseReference showBFtoGF_GFtoBFGiftRef = databaseReference.child("Christmas Gift");
            showBFtoGF_GFtoBFGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
        if(positionNum == 4){
            setTitle("Couple Gift");
            DatabaseReference showChristmasGiftRef = databaseReference.child("Couple Gift");
            showChristmasGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
        if(positionNum == 5){
            setTitle("Friendship Gift");
            DatabaseReference showCoupleGiftRef = databaseReference.child("Festival Gift");
            showCoupleGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
        if(positionNum == 6){
            setTitle("Festival Gift");
            DatabaseReference showHoneymoonGiftRef = databaseReference.child("Friendship Gift");
            showHoneymoonGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
        if(positionNum == 7){
            setTitle("New Year Gift");
            DatabaseReference showNewYearGiftRef = databaseReference.child("New Year Gift");
            showNewYearGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
        if(positionNum == 8){
            setTitle("Parents Gift");
            DatabaseReference showParentsGiftRef = databaseReference.child("Parents Gift");
            showParentsGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
        if(positionNum == 9){
            setTitle("Romantic Gift");
            DatabaseReference showRomanticGiftRef = databaseReference.child("Romantic Gift");
            showRomanticGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
        if(positionNum == 10){
            setTitle("Valentine Gift");
            DatabaseReference showValentineGiftRef = databaseReference.child("Valentine  Gift");
            showValentineGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
        if(positionNum == 11){
            setTitle("Wedding Gift");
            DatabaseReference showWeddingGiftRef = databaseReference.child("Wedding Gift");
            showWeddingGiftRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        fullGiftList.clear();
                        for (DataSnapshot data:dataSnapshot.getChildren()){
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
}
