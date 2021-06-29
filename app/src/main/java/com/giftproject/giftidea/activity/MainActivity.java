package com.giftproject.giftidea.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


import com.giftproject.giftidea.R;
import com.giftproject.giftidea.fragment.BirthdayGiftFragment;
import com.giftproject.giftidea.fragment.ChristmasGiftFragment;
import com.giftproject.giftidea.fragment.GiftCardFragment;
import com.giftproject.giftidea.fragment.AnniversaryGiftFragment;
import com.giftproject.giftidea.fragment.HomeFragment;
import com.giftproject.giftidea.fragment.RomanticGiftFragment;
import com.giftproject.giftidea.fragment.ValentineGiftFragment;
import com.google.android.ads.mediationtestsuite.MediationTestSuite;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity /*implements MaxAdViewAdListener*/ {
    private BottomNavigationView navView;
    private RelativeLayout singleFrameLayout,multiFrameLayout;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

//        adMobBannerAd();

        setTitle("Giftidea");
        replaceFragment(new HomeFragment());

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        AppLovinSdk.getInstance( this ).setMediationProvider( "max" );
//        AppLovinSdk.initializeSdk( this, new AppLovinSdk.SdkInitializationListener() {
//            @Override
//            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
//            {
//                // AppLovin SDK is initialized, start loading ads
//                createBannerAd();
//            }
//        } );
    }




    private void init() {
        navView = findViewById(R.id.nav_view);
        singleFrameLayout = findViewById(R.id.singleFragReLayoutId);
        multiFrameLayout = findViewById(R.id.multiFragReLayoutId);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           switch (item.getItemId()){
               case R.id.navigation_home:
                   setTitle("Giftidea");
                   multiFrameLayout.setVisibility(View.GONE);
                   singleFrameLayout.setVisibility(View.VISIBLE);
                   replaceFragment(new HomeFragment());
                   return true;

               case R.id.navigation_category:
                   setTitle("Popular Gift");
                   singleFrameLayout.setVisibility(View.GONE);
                   multiFrameLayout.setVisibility(View.VISIBLE);
                   multiReplaceFragment(new AnniversaryGiftFragment(), new BirthdayGiftFragment(),
                           new ChristmasGiftFragment(), new RomanticGiftFragment(), new ValentineGiftFragment());
                   return true;

//               case R.id.navigation_diy_gift:
//                   multiFrameLayout.setVisibility(View.GONE);
//                   singleFrameLayout.setVisibility(View.VISIBLE);
//                   replaceFragment(new DIYFragment());
//                   return true;

               case R.id.navigation_gift_card:
                   setTitle("Gift Card");
                   multiFrameLayout.setVisibility(View.GONE);
                   singleFrameLayout.setVisibility(View.VISIBLE);
                   replaceFragment(new GiftCardFragment());
                   return true;
           }
            return false;
        }
    };

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
        fT.replace(R.id.frameLayoutId,fragment);
        fT.commit();
    }

    private void multiReplaceFragment(Fragment fragment1, Fragment fragment2, Fragment fragment3, Fragment fragment4, Fragment fragment5){
        FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
        fT.replace(R.id.anniversaryGiftFrameLayoutId,fragment1);
        fT.replace(R.id.birthdayGiftFrameLayoutId,fragment2);
        fT.replace(R.id.christmasGiftFrameLayoutId,fragment3);
        fT.replace(R.id.romanticGiftFrameLayoutId,fragment4);
        fT.replace(R.id.valentineGiftFrameLayoutId,fragment5);
        fT.commit();
    }

//    private void createBannerAd() {
//        adView = new MaxAdView( "9ec5c977eb26ee89", this );
//        adView.setListener( this );
//
//        // Stretch to the width of the screen for banners to be fully functional
////        int width = ViewGroup.LayoutParams.MATCH_PARENT;
//
//        // Banner height on phones and tablets is 50 and 90, respectively
//
//        // Set background or background color for banners to be fully functional
//
//        ViewGroup rootView = findViewById( android.R.id.content );
//        rootView.addView( adView );
//
//        // Load the ad
//        adView.loadAd();
//    }

    // MAX Ad Listener
//    @Override
//    public void onAdLoaded(final MaxAd maxAd) {}
//
//    @Override
//    public void onAdLoadFailed(final String adUnitId, final MaxError error) {}
//
//    @Override
//    public void onAdDisplayFailed(final MaxAd maxAd, final MaxError error) {}
//
//    @Override
//    public void onAdClicked(final MaxAd maxAd) {}
//
//    @Override
//    public void onAdExpanded(final MaxAd maxAd) {}
//
//    @Override
//    public void onAdCollapsed(final MaxAd maxAd) {}
//
//    @Override
//    public void onAdDisplayed(final MaxAd maxAd) { /* DO NOT USE - THIS IS RESERVED FOR FULLSCREEN ADS ONLY AND WILL BE REMOVED IN A FUTURE SDK RELEASE */ }
//
//    @Override
//    public void onAdHidden(final MaxAd maxAd) { /* DO NOT USE - THIS IS RESERVED FOR FULLSCREEN ADS ONLY AND WILL BE REMOVED IN A FUTURE SDK RELEASE */ }

    private void adMobBannerAd() {
        MobileAds.initialize(this, initializationStatus ->  {});
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
//        MediationTestSuite.launch(MainActivity.this);
    }
}
