package com.kesteli.filip.sciencebrowser1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
            holder.znanostTitle.setText(clanciHelperPOJO.getTitles()[position]);
//            holder.znanostImage.setImageResource(images[position]);
            holder.znanostImage.setImageResource(clanciHelperPOJO.getImages()[position]);
        }

        @Override
        public int getItemCount() {
            return clanciHelperPOJO.getTitles().length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView znanostImage;
            public TextView znanostTitle;

            public ViewHolder(View itemView) {
                super(itemView);
                znanostImage = (ImageView) itemView.findViewById(R.id.znanost_image);
                znanostTitle = (TextView) itemView.findViewById(R.id.znanost_title);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();

                        sharedPreferences = getSharedPreferences(ClanciHelperPOJO.getWebStranicePREFERENCES(), Context.MODE_PRIVATE);
                        editor = sharedPreferences.edit();

                        Intent intent = new Intent(MainActivity.this, WebActivity.class);
                        if (position == 0) {
                            editor.putString(ClanciHelperPOJO.getWebStranicePREFERENCES(), ClanciHelperPOJO.getFizika_clanci());
                            editor.commit();
                            intent.putExtra(ClanciHelperPOJO.getFizika_clanci(), ClanciHelperPOJO.getFizika_clanci());
                        } else if (position == 1) {
                            editor.putString(ClanciHelperPOJO.getWebStranicePREFERENCES(), ClanciHelperPOJO.getKemija_clanci());
                            editor.commit();
                            intent.putExtra(ClanciHelperPOJO.getKemija_clanci(), ClanciHelperPOJO.getKemija_clanci());
                        } else if (position == 2) {
                            editor.putString(ClanciHelperPOJO.getWebStranicePREFERENCES(), ClanciHelperPOJO.getMatematika_clanci());
                            editor.commit();
                            intent.putExtra(ClanciHelperPOJO.getMatematika_clanci(), ClanciHelperPOJO.getMatematika_clanci());
                        } else if (position == 3) {
                            editor.putString(ClanciHelperPOJO.getWebStranicePREFERENCES(), ClanciHelperPOJO.getTehnika_clanci());
                            editor.commit();
                            intent.putExtra(ClanciHelperPOJO.getTehnika_clanci(), ClanciHelperPOJO.getTehnika_clanci());
                        } else if (position == 4) {
                            editor.putString(ClanciHelperPOJO.getWebStranicePREFERENCES(), ClanciHelperPOJO.getMedicina_clanci());
                            editor.commit();
                            intent.putExtra(ClanciHelperPOJO.getMedicina_clanci(), ClanciHelperPOJO.getMedicina_clanci());
                        } else if (position == 5) {
                            editor.putString(ClanciHelperPOJO.getWebStranicePREFERENCES(), ClanciHelperPOJO.getBiologija_clanci());
                            editor.commit();
                            intent.putExtra(ClanciHelperPOJO.getBiologija_clanci(), ClanciHelperPOJO.getBiologija_clanci());
                        } else if (position == 6) {
                            editor.putString(ClanciHelperPOJO.getWebStranicePREFERENCES(), ClanciHelperPOJO.getAstronomija_clanci());
                            editor.commit();
                            intent.putExtra(ClanciHelperPOJO.getAstronomija_clanci(), ClanciHelperPOJO.getAstronomija_clanci());
                        } else if (position == 7) {
                            editor.putString(ClanciHelperPOJO.getWebStranicePREFERENCES(), ClanciHelperPOJO.getGeologija_clanci());
                            editor.commit();
                            intent.putExtra(ClanciHelperPOJO.getGeologija_clanci(), ClanciHelperPOJO.getGeologija_clanci());
                        }
                        startActivity(intent);
                    }
                });
            }
        }
    }
}

