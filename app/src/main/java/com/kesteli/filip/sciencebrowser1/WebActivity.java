package com.kesteli.filip.sciencebrowser1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebActivity extends AppCompatActivity {

    private ClanciHelperPOJO clanciHelperPOJO = new ClanciHelperPOJO();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    //    private SharedPreferences sharedPreferences;
//    private SharedPreferences.Editor editor;
//    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        setupToolbar();
        setupViewPager();
        setupTabLayout();
        setupTabIcons();

//        setupSharedPreferences();
//        handleIntents();
        setupFragments();
    }

    private void setupFragments() {
        Intent intent = getIntent();
        if (intent.hasExtra(ClanciHelperPOJO.getFizika_clanci())) {
            adapter.addFrag(new Frag1(), clanciHelperPOJO.getFizika()[0]);
            adapter.addFrag(new Frag2(), clanciHelperPOJO.getFizika()[1]);
            adapter.addFrag(new Frag3(), clanciHelperPOJO.getFizika()[2]);
            adapter.addFrag(new Frag4(), clanciHelperPOJO.getFizika()[3]);
            adapter.addFrag(new Frag5(), clanciHelperPOJO.getFizika()[4]);
            adapter.addFrag(new Frag6(), clanciHelperPOJO.getFizika()[5]);
            adapter.addFrag(new Frag7(), clanciHelperPOJO.getFizika()[6]);
            adapter.addFrag(new Frag8(), clanciHelperPOJO.getFizika()[7]);
            adapter.addFrag(new Frag9(), clanciHelperPOJO.getFizika()[8]);
            adapter.addFrag(new Frag10(), clanciHelperPOJO.getFizika()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getFizika().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[0]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getKemija_clanci())) {
            adapter.addFrag(new Frag1(), clanciHelperPOJO.getKemija()[0]);
            adapter.addFrag(new Frag2(), clanciHelperPOJO.getKemija()[1]);
            adapter.addFrag(new Frag3(), clanciHelperPOJO.getKemija()[2]);
            adapter.addFrag(new Frag4(), clanciHelperPOJO.getKemija()[3]);
            adapter.addFrag(new Frag5(), clanciHelperPOJO.getKemija()[4]);
            adapter.addFrag(new Frag6(), clanciHelperPOJO.getKemija()[5]);
            adapter.addFrag(new Frag7(), clanciHelperPOJO.getKemija()[6]);
            adapter.addFrag(new Frag8(), clanciHelperPOJO.getKemija()[7]);
            adapter.addFrag(new Frag9(), clanciHelperPOJO.getKemija()[8]);
            adapter.addFrag(new Frag10(), clanciHelperPOJO.getKemija()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getKemija().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[1]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getMatematika_clanci())) {
            adapter.addFrag(new Frag1(), clanciHelperPOJO.getMatematika()[0]);
            adapter.addFrag(new Frag2(), clanciHelperPOJO.getMatematika()[1]);
            adapter.addFrag(new Frag3(), clanciHelperPOJO.getMatematika()[2]);
            adapter.addFrag(new Frag4(), clanciHelperPOJO.getMatematika()[3]);
            adapter.addFrag(new Frag5(), clanciHelperPOJO.getMatematika()[4]);
            adapter.addFrag(new Frag6(), clanciHelperPOJO.getMatematika()[5]);
            adapter.addFrag(new Frag7(), clanciHelperPOJO.getMatematika()[6]);
            adapter.addFrag(new Frag8(), clanciHelperPOJO.getMatematika()[7]);
            adapter.addFrag(new Frag9(), clanciHelperPOJO.getMatematika()[8]);
            adapter.addFrag(new Frag10(), clanciHelperPOJO.getMatematika()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getMatematika().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[2]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getTehnika_clanci())) {
            adapter.addFrag(new Frag1(), clanciHelperPOJO.getTehnika()[0]);
            adapter.addFrag(new Frag2(), clanciHelperPOJO.getTehnika()[1]);
            adapter.addFrag(new Frag3(), clanciHelperPOJO.getTehnika()[2]);
            adapter.addFrag(new Frag4(), clanciHelperPOJO.getTehnika()[3]);
            adapter.addFrag(new Frag5(), clanciHelperPOJO.getTehnika()[4]);
            adapter.addFrag(new Frag6(), clanciHelperPOJO.getTehnika()[5]);
            adapter.addFrag(new Frag7(), clanciHelperPOJO.getTehnika()[6]);
            adapter.addFrag(new Frag8(), clanciHelperPOJO.getTehnika()[7]);
            adapter.addFrag(new Frag9(), clanciHelperPOJO.getTehnika()[8]);
            adapter.addFrag(new Frag10(), clanciHelperPOJO.getTehnika()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getTehnika().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[3]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getMedicina_clanci())) {
            adapter.addFrag(new Frag1(), clanciHelperPOJO.getMedicina()[0]);
            adapter.addFrag(new Frag2(), clanciHelperPOJO.getMedicina()[1]);
            adapter.addFrag(new Frag3(), clanciHelperPOJO.getMedicina()[2]);
            adapter.addFrag(new Frag4(), clanciHelperPOJO.getMedicina()[3]);
            adapter.addFrag(new Frag5(), clanciHelperPOJO.getMedicina()[4]);
            adapter.addFrag(new Frag6(), clanciHelperPOJO.getMedicina()[5]);
            adapter.addFrag(new Frag7(), clanciHelperPOJO.getMedicina()[6]);
            adapter.addFrag(new Frag8(), clanciHelperPOJO.getMedicina()[7]);
            adapter.addFrag(new Frag9(), clanciHelperPOJO.getMedicina()[8]);
            adapter.addFrag(new Frag10(), clanciHelperPOJO.getMedicina()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getMedicina().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[4]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getBiologija_clanci())) {
            adapter.addFrag(new Frag1(), clanciHelperPOJO.getBiologija()[0]);
            adapter.addFrag(new Frag2(), clanciHelperPOJO.getBiologija()[1]);
            adapter.addFrag(new Frag3(), clanciHelperPOJO.getBiologija()[2]);
            adapter.addFrag(new Frag4(), clanciHelperPOJO.getBiologija()[3]);
            adapter.addFrag(new Frag5(), clanciHelperPOJO.getBiologija()[4]);
            adapter.addFrag(new Frag6(), clanciHelperPOJO.getBiologija()[5]);
            adapter.addFrag(new Frag7(), clanciHelperPOJO.getBiologija()[6]);
            adapter.addFrag(new Frag8(), clanciHelperPOJO.getBiologija()[7]);
            adapter.addFrag(new Frag9(), clanciHelperPOJO.getBiologija()[8]);
            adapter.addFrag(new Frag10(), clanciHelperPOJO.getBiologija()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getBiologija().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[5]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getAstronomija_clanci())) {
            adapter.addFrag(new Frag1(), clanciHelperPOJO.getAstronomija()[0]);
            adapter.addFrag(new Frag2(), clanciHelperPOJO.getAstronomija()[1]);
            adapter.addFrag(new Frag3(), clanciHelperPOJO.getAstronomija()[2]);
            adapter.addFrag(new Frag4(), clanciHelperPOJO.getAstronomija()[3]);
            adapter.addFrag(new Frag5(), clanciHelperPOJO.getAstronomija()[4]);
            adapter.addFrag(new Frag6(), clanciHelperPOJO.getAstronomija()[5]);
            adapter.addFrag(new Frag7(), clanciHelperPOJO.getAstronomija()[6]);
            adapter.addFrag(new Frag8(), clanciHelperPOJO.getAstronomija()[7]);
            adapter.addFrag(new Frag9(), clanciHelperPOJO.getAstronomija()[8]);
            adapter.addFrag(new Frag10(), clanciHelperPOJO.getAstronomija()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getAstronomija().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[6]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getGeologija_clanci())) {
            adapter.addFrag(new Frag1(), clanciHelperPOJO.getGeologija()[0]);
            adapter.addFrag(new Frag2(), clanciHelperPOJO.getGeologija()[1]);
            adapter.addFrag(new Frag3(), clanciHelperPOJO.getGeologija()[2]);
            adapter.addFrag(new Frag4(), clanciHelperPOJO.getGeologija()[3]);
            adapter.addFrag(new Frag5(), clanciHelperPOJO.getGeologija()[4]);
            adapter.addFrag(new Frag6(), clanciHelperPOJO.getGeologija()[5]);
            adapter.addFrag(new Frag7(), clanciHelperPOJO.getGeologija()[6]);
            adapter.addFrag(new Frag8(), clanciHelperPOJO.getGeologija()[7]);
            adapter.addFrag(new Frag9(), clanciHelperPOJO.getGeologija()[8]);
            adapter.addFrag(new Frag10(), clanciHelperPOJO.getGeologija()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getGeologija().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[7]);
            }
        }
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

    /*private void setupSharedPreferences() {
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        *//*editor.putString(Name, n);
        editor.putString(Phone, ph);
        editor.putString(Email, e);
        editor.commit();*//*
    }*/

    /*private void handleIntents() {
        Intent intent = getIntent();
        if (intent.hasExtra(ClanciHelperPOJO.getFizika_clanci())) {
            editor.putString(ClanciHelperPOJO.getMyPREFERENCES(), ClanciHelperPOJO.getFizika_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                WebFragment webFragment = new WebFragment();
                editor.putString(ClanciHelperPOJO.getMyClanakPREFERENCE(), clanciHelperPOJO.getClanci_fizika()[i]);
//                Set<String> stringSet = {"da"};
                editor.commit();

                adapter.addFrag(webFragment, clanciHelperPOJO.getFizika()[i]);
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
    }*/

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
            case R.id.action_history:
                Intent intent = new Intent(WebActivity.this, HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.action_favorite:
                Intent intent2 = new Intent(WebActivity.this, FavoritesActivity.class);
                startActivity(intent2);
                break;
            case R.id.action_eureka:
                Intent intent3 = new Intent(WebActivity.this, DragAndDropActivity.class);
                startActivity(intent3);
                break;
            //FACTORY metoda -> odmah iskoristimo vec postojecu ugradenu sprancu za ProgressDialog objekt:
//                ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "Loading Bank Transaction", "Please wait");
        }
        return true;
    }
}


