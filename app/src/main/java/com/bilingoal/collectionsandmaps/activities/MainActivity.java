package com.bilingoal.collectionsandmaps.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.adapters.TabAdapter;
import com.bilingoal.collectionsandmaps.fragments.CollectionsFragment;
import com.bilingoal.collectionsandmaps.fragments.MapsFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.tab_layout) TabLayout tabLayout;
    private CollectionsFragment collectionsFragment;
    private MapsFragment mapsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if(getSupportFragmentManager().getFragments().isEmpty()){
            collectionsFragment = new CollectionsFragment();
            collectionsFragment.setSpanCount(3);
            mapsFragment = new MapsFragment();
            mapsFragment.setSpanCount(2);
        }
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(getResources().getString(R.string.tab_title_collections), collectionsFragment);
        tabAdapter.addFragment(getResources().getString(R.string.tab_title_maps),  mapsFragment);

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}