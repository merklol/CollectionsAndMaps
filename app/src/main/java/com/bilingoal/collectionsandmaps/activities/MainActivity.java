package com.bilingoal.collectionsandmaps.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.adapters.TabAdapter;
import com.bilingoal.collectionsandmaps.grid.GridContract;
import com.bilingoal.collectionsandmaps.grid.GridFragment;
import com.google.android.material.tabs.TabLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.tab_layout) TabLayout tabLayout;
    private GridFragment collections, maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if(getSupportFragmentManager().getFragments().isEmpty()){
            collections = GridFragment.createInstance(GridContract.COLLECTIONS);
            maps= GridFragment.createInstance(GridContract.MAPS);
        }
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(getResources().getString(R.string.tab_title_collections), collections);
        tabAdapter.addFragment(getResources().getString(R.string.tab_title_maps),  maps);

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}