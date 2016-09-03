package com.kesteli.filip.sciencebrowser1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
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

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp
    };

    private String[] clanci = {"jedan", "dva", "tri", "cetiri", "pet", "sest", "sedam", "osam", "devet", "deset"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        handleIntents();
        setupToolbar();
        setupViewPager();
        setupTabLayout();
        setupTabIcons();
    }

    private void handleIntents() {
        Intent intent = getIntent();
        if (intent.hasExtra(MainActivity.fizika_clanci)) {
            clanci = intent.getStringArrayExtra(MainActivity.fizika_clanci);
        } else if (intent.hasExtra(MainActivity.kemija_clanci)) {
            clanci = intent.getStringArrayExtra(MainActivity.kemija_clanci);
        } else if (intent.hasExtra(MainActivity.matematika_clanci)) {
            clanci = intent.getStringArrayExtra(MainActivity.matematika_clanci);
        } else if (intent.hasExtra(MainActivity.tehnika_clanci)) {
            clanci = intent.getStringArrayExtra(MainActivity.tehnika_clanci);
        } else if (intent.hasExtra(MainActivity.medicina_clanci)) {
            clanci = intent.getStringArrayExtra(MainActivity.medicina_clanci);
        } else if (intent.hasExtra(MainActivity.biologija_clanci)) {
            clanci = intent.getStringArrayExtra(MainActivity.biologija_clanci);
        }
        Toast.makeText(WebActivity.this, clanci[2], Toast.LENGTH_SHORT).show();
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
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        for (int i = 0; i < clanci.length; i++) {
            adapter.addFrag(new WebFragment(), clanci[i]);
        }
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        for (int i = 0; i < tabIcons.length; i++) {
            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
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


