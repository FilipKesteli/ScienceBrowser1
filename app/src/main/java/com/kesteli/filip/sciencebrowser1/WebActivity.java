package com.kesteli.filip.sciencebrowser1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WebActivity extends AppCompatActivity {

    private ClanciHelperPOJO clanciHelperPOJO = new ClanciHelperPOJO();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private String[] clanci = {"jedan", "dva", "tri", "cetiri", "pet", "sest", "sedam", "osam", "devet", "deset"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        setupToolbar();
        setupViewPager();
        setupTabLayout();
        setupTabIcons();

        setupSharedPreferences();
        handleIntents();
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupTabLayout() {
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

/*
        for (int i = 0; i < clanci.length; i++) {
            adapter.addFrag(new WebFragment(), clanci[i]);
        }
        viewPager.setAdapter(adapter);
*/
    }

    private void setupTabIcons() {
/*
        for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
//            tabLayout.getTabAt(i).setIcon(images[1]);
            tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[4]);
        }
*/
    }

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static final String MyPREFERENCES = "MyPrefs";

    private void setupSharedPreferences() {
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        /*editor.putString(Name, n);
        editor.putString(Phone, ph);
        editor.putString(Email, e);
        editor.commit();*/
    }

    private void handleIntents() {
        Intent intent = getIntent();
        if (intent.hasExtra(ClanciHelperPOJO.getFizika_clanci())) {
            editor.putString(ClanciHelperPOJO.getFizika_clanci(), ClanciHelperPOJO.getFizika_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getFizika()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[0]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getKemija_clanci())) {
            editor.putString(ClanciHelperPOJO.getKemija_clanci(), ClanciHelperPOJO.getKemija_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getKemija()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[1]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getMatematika_clanci())) {
            editor.putString(ClanciHelperPOJO.getMatematika_clanci(), ClanciHelperPOJO.getMatematika_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getMatematika()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[2]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getTehnika_clanci())) {
            editor.putString(ClanciHelperPOJO.getTehnika_clanci(), ClanciHelperPOJO.getTehnika_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getTehnika()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[3]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getMedicina_clanci())) {
            editor.putString(ClanciHelperPOJO.getMedicina_clanci(), ClanciHelperPOJO.getMedicina_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getMedicina()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[4]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getBiologija_clanci())) {
            editor.putString(ClanciHelperPOJO.getBiologija_clanci(), ClanciHelperPOJO.getBiologija_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getBiologija()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[5]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getAstronomija_clanci())) {
            editor.putString(ClanciHelperPOJO.getAstronomija_clanci(), ClanciHelperPOJO.getAstronomija_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getAstronomija()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[6]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getGeologija_clanci())) {
            editor.putString(ClanciHelperPOJO.getGeologija_clanci(), ClanciHelperPOJO.getGeologija_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getGeologija()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[7]);
            }
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.moj_vlastiti_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_account_circle:
                Toast.makeText(WebActivity.this, "Alooohaaaa", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_shopping_cart:
                //FACTORY metoda -> odmah iskoristimo vec postojecu ugradenu sprancu za ProgressDialog objekt:
//                ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "Loading Bank Transaction", "Please wait");
                Toast.makeText(WebActivity.this, "Alooohaaaa", Toast.LENGTH_SHORT).show();
            case R.id.action_euro:
                Toast.makeText(WebActivity.this, "Alooohaaaa", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}


