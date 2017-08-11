package com.kesteli.filip.sciencebrowser1.aplikacije.education;

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
import com.kesteli.filip.sciencebrowser1.aplikacije.education.edufrag.EduFrag1;
import com.kesteli.filip.sciencebrowser1.aplikacije.education.edufrag.EduFrag10;
import com.kesteli.filip.sciencebrowser1.aplikacije.education.edufrag.EduFrag2;
import com.kesteli.filip.sciencebrowser1.aplikacije.education.edufrag.EduFrag3;
import com.kesteli.filip.sciencebrowser1.aplikacije.education.edufrag.EduFrag4;
import com.kesteli.filip.sciencebrowser1.aplikacije.education.edufrag.EduFrag5;
import com.kesteli.filip.sciencebrowser1.aplikacije.education.edufrag.EduFrag6;
import com.kesteli.filip.sciencebrowser1.aplikacije.education.edufrag.EduFrag7;
import com.kesteli.filip.sciencebrowser1.aplikacije.education.edufrag.EduFrag8;
import com.kesteli.filip.sciencebrowser1.aplikacije.education.edufrag.EduFrag9;
import com.kesteli.filip.sciencebrowser1.web.history.EurekaActivity;
import com.kesteli.filip.sciencebrowser1.web.history.FavoriteActivity;
import com.kesteli.filip.sciencebrowser1.web.history.HistoryActivity;

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

    /**
     * Kad stisnem recimo chemistry, jedini nacin da znam da je to chemistry je da posaljem intentExtra!
     * Recimo kod ostalih activityja to nije toliko bitno (Education, RealityCheck, Motivator, itd.)
     */

    private void setupFragments() {
        Intent intent = getIntent();
        if (intent.hasExtra(ClanciHelperPOJO.getEducation_express())) {
            adapter.addFrag(new EduFrag1(), clanciHelperPOJO.getEdukacija()[0]);
            adapter.addFrag(new EduFrag2(), clanciHelperPOJO.getEdukacija()[1]);
            adapter.addFrag(new EduFrag3(), clanciHelperPOJO.getEdukacija()[2]);
            adapter.addFrag(new EduFrag4(), clanciHelperPOJO.getEdukacija()[3]);
            adapter.addFrag(new EduFrag5(), clanciHelperPOJO.getEdukacija()[4]);
            adapter.addFrag(new EduFrag6(), clanciHelperPOJO.getEdukacija()[5]);
            adapter.addFrag(new EduFrag7(), clanciHelperPOJO.getEdukacija()[6]);
            adapter.addFrag(new EduFrag8(), clanciHelperPOJO.getEdukacija()[7]);
            adapter.addFrag(new EduFrag9(), clanciHelperPOJO.getEdukacija()[8]);
            adapter.addFrag(new EduFrag10(), clanciHelperPOJO.getEdukacija()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getFizika().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[0]);
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
