package com.kesteli.filip.sciencebrowser1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kesteli.filip.sciencebrowser1.web.ClanciActivity;
import com.kesteli.filip.sciencebrowser1.aplikacije.democracy.DemocracyActivity;
import com.kesteli.filip.sciencebrowser1.aplikacije.donacije.DonationActivity;
import com.kesteli.filip.sciencebrowser1.aplikacije.education.EducationActivity;
import com.kesteli.filip.sciencebrowser1.aplikacije.kzinicijativa.KZInicijativaActivity;
import com.kesteli.filip.sciencebrowser1.aplikacije.motivatorapp.MotivatorActivity;
import com.kesteli.filip.sciencebrowser1.aplikacije.realitycheck.RealityActivity;
import com.kesteli.filip.sciencebrowser1.aplikacije.smartcity.SmartCityActivity;
import com.kesteli.filip.sciencebrowser1.aplikacije.history.EurekaActivity;
import com.kesteli.filip.sciencebrowser1.aplikacije.history.FavoriteActivity;
import com.kesteli.filip.sciencebrowser1.aplikacije.history.HistoryActivity;
import com.kesteli.filip.sciencebrowser1.web.WebActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ClanciHelperPOJO clanciHelperPOJO = new ClanciHelperPOJO();

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupToolbar();
        setupHamburgerIcon();
        setupNavigationView();
        setupRecyclerView();
    }

    private void initWidgets() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    private void setupHamburgerIcon() {
        //Hamburger icon:
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void setupNavigationView() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        sharedPreferences = getSharedPreferences(ClanciHelperPOJO.getWebStranicePREFERENCES(), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Intent intent = new Intent(MainActivity.this, WebActivity.class);
        String znanost = null;
        if (id == R.id.nav_fizika) {
            znanost = ClanciHelperPOJO.getFizika_clanci();
        } else if (id == R.id.nav_kemija) {
            znanost = ClanciHelperPOJO.getKemija_clanci();
        } else if (id == R.id.nav_matematika) {
            znanost = ClanciHelperPOJO.getMatematika_clanci();
        } else if (id == R.id.nav_tehnika) {
            znanost = ClanciHelperPOJO.getTehnika_clanci();
        } else if (id == R.id.nav_medicina) {
            znanost = ClanciHelperPOJO.getMedicina_clanci();
        } else if (id == R.id.nav_bilogija) {
            znanost = ClanciHelperPOJO.getBiologija_clanci();
        } else if (id == R.id.nav_astronomija) {
            znanost = ClanciHelperPOJO.getAstronomija_clanci();
        } else if (id == R.id.nav_geologija) {
            znanost = ClanciHelperPOJO.getGeologija_clanci();
        } else if (id == R.id.nav_eureka) {
            Intent intentEureka = new Intent(MainActivity.this, EurekaActivity.class);
            startActivity(intentEureka);
        } else if (id == R.id.nav_favorite) {
            Intent intentFavorite = new Intent(MainActivity.this, FavoriteActivity.class);
            startActivity(intentFavorite);
        } else if (id == R.id.nav_history) {
            Intent intentHistory = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intentHistory);
        }

        editor.putString(ClanciHelperPOJO.getWebStranicePREFERENCES(), znanost);
        editor.commit();
        intent.putExtra(znanost, znanost);
        startActivity(intent);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            return true;
        } else if (id == R.id.action_eureka) {
            Intent intent = new Intent(MainActivity.this, EurekaActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_favorite) {
            Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_history) {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private GridLayoutManager gridLayoutManager; //kartice u mreži

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_layout_grana_znanosti, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
//            holder.znanostTitle.setText(titles[position]);
            holder.znanostTitle.setText(clanciHelperPOJO.getIdejeTitles()[position]);
//            holder.znanostImage.setImageResource(images[position]);
            holder.znanostImage.setImageResource(clanciHelperPOJO.getIdejeImages()[position]);
            holder.cardView.setCardBackgroundColor(clanciHelperPOJO.getIdejeColors()[position]);
        }

        @Override
        public int getItemCount() {
            return clanciHelperPOJO.getIdejeTitles().length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView znanostImage;
            public TextView znanostTitle;
            public CardView cardView;

            public ViewHolder(View itemView) {

                super(itemView);
                znanostImage = (ImageView) itemView.findViewById(R.id.znanost_image);
                znanostTitle = (TextView) itemView.findViewById(R.id.znanost_title);
                cardView = (CardView) itemView.findViewById(R.id.card_view);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();

                        sharedPreferences = getSharedPreferences(ClanciHelperPOJO.getWebStranicePREFERENCES(), Context.MODE_PRIVATE);
                        editor = sharedPreferences.edit();

                        if (position == 0) {
                            Intent intentEducation = new Intent(MainActivity.this, EducationActivity.class);
                            editor.putString(ClanciHelperPOJO.getWebStranicePREFERENCES(), ClanciHelperPOJO.getEducation_express());
                            editor.commit();
                            intentEducation.putExtra(ClanciHelperPOJO.getEducation_express(), ClanciHelperPOJO.getEducation_express());
                            startActivity(intentEducation);
                        } else if (position == 1) {
                            Intent intentDemocracy = new Intent(MainActivity.this, DemocracyActivity.class);
                            startActivity(intentDemocracy);
                        } else if (position == 2) {
                            Intent intentClanci = new Intent(MainActivity.this, ClanciActivity.class);
                            startActivity(intentClanci);
                        } else if (position == 3) {
                            Intent intentDonation = new Intent(MainActivity.this, DonationActivity.class);
                            startActivity(intentDonation);
                        } else if (position == 4) {
                            Intent intentKZInicijativa = new Intent(MainActivity.this, KZInicijativaActivity.class);
                            startActivity(intentKZInicijativa);
                        } else if (position == 5) {
                            Intent intentMotivator = new Intent(MainActivity.this, MotivatorActivity.class);
                            startActivity(intentMotivator);
                        } else if (position == 6) {
                            Intent intentReality = new Intent(MainActivity.this, RealityActivity.class);
                            startActivity(intentReality);
                        } else if (position == 7) {
                            Intent intentSmartCity = new Intent(MainActivity.this, SmartCityActivity.class);
                            startActivity(intentSmartCity);
                        }
                    }
                });
            }
        }
    }
}

