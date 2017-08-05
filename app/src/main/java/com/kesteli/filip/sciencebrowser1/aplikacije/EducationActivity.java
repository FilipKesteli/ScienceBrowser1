package com.kesteli.filip.sciencebrowser1.aplikacije;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.kesteli.filip.sciencebrowser1.ClanciHelperPOJO;
import com.kesteli.filip.sciencebrowser1.R;
import com.kesteli.filip.sciencebrowser1.education.EduFrag1;
import com.kesteli.filip.sciencebrowser1.history.EurekaActivity;
import com.kesteli.filip.sciencebrowser1.history.FavoriteActivity;
import com.kesteli.filip.sciencebrowser1.history.HistoryActivity;
import com.kesteli.filip.sciencebrowser1.web.WebActivity;
import com.kesteli.filip.sciencebrowser1.web.fragmenti.Frag1;
import com.kesteli.filip.sciencebrowser1.web.fragmenti.Frag10;
import com.kesteli.filip.sciencebrowser1.web.fragmenti.Frag2;
import com.kesteli.filip.sciencebrowser1.web.fragmenti.Frag3;
import com.kesteli.filip.sciencebrowser1.web.fragmenti.Frag4;
import com.kesteli.filip.sciencebrowser1.web.fragmenti.Frag5;
import com.kesteli.filip.sciencebrowser1.web.fragmenti.Frag6;
import com.kesteli.filip.sciencebrowser1.web.fragmenti.Frag7;
import com.kesteli.filip.sciencebrowser1.web.fragmenti.Frag8;
import com.kesteli.filip.sciencebrowser1.web.fragmenti.Frag9;

import java.util.ArrayList;
import java.util.List;

public class EducationActivity extends AppCompatActivity {

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
        setupFragments();
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
    }

    /**
     * Ovdje učitavam tabove
     */
    private void setupFragments() {
        Intent intent = getIntent();
        if (intent.hasExtra(ClanciHelperPOJO.getFizika_clanci())) {
            adapter.addFrag(new EduFrag1(), "Android");
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

    /**
     * Gornji toolbar
     */
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
                Intent intent = new Intent(EducationActivity.this, HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.action_favorite:
                Intent intent2 = new Intent(EducationActivity.this, FavoriteActivity.class);
                startActivity(intent2);
                break;
            case R.id.action_eureka:
                Intent intent3 = new Intent(EducationActivity.this, EurekaActivity.class);
                startActivity(intent3);
                break;
            //FACTORY metoda -> odmah iskoristimo vec postojecu ugradenu sprancu za ProgressDialog objekt:
//                ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "Loading Bank Transaction", "Please wait");
        }
        return true;
    }
}
