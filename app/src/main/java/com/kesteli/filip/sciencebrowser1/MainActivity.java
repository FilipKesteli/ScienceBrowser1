package com.kesteli.filip.sciencebrowser1;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ClanciHelper clanciHelper = new ClanciHelper();
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

    //OVERRIDEANE METODE:
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
    public static final String fizika_clanci = "fizika_clanci";
    public static final String kemija_clanci = "fizika_clanci";
    public static final String matematika_clanci = "fizika_clanci";
    public static final String tehnika_clanci = "tehnika_clanci";
    public static final String medicina_clanci = "medicina_clanci";
    public static final String biologija_clanci = "biologija_clanci";
    public static final String astronomija_clanci = "astronomija_clanci";

    public static final String geologija_clanci = "geologija_clanci";

    private String[] clanci_fizika = {
            "http://phys.org/physics-news/",
            "https://www.sciencedaily.com/news/matter_energy/physics/",
            "http://physicsworld.com/cws/channel/news",
            "http://www.physics.org/news.asp",
            "http://scitation.aip.org/content/aip/magazine/physicstoday/news",
            "http://www.scientificamerican.com/physics/",
            "http://discovermagazine.com/tags/physics",
            "https://physics.aps.org/",
            "https://www.newscientist.com/subject/physics/",
            "http://www.sci-news.com/news/physics"
    };

    private String[] fizika = {"phys.org", "science daily", "physics world", "physics.org", "scitation.aip", "sci american", "discover", "physics.aps", "new scientist", "sci news"};

    private String[] clanci_kemija = {
            "http://www.scientificamerican.com/chemistry/",
            "http://phys.org/chemistry-news/",
            "http://www.iflscience.com/chemistry/",
            "https://www.sciencedaily.com/news/matter_energy/chemistry/",
            "http://www.sciencemag.org/category/chemistry",
            "https://www.rsc.org/chemistryworld/news",
            "http://www.nytimes.com/topic/subject/chemistry",
            "http://www.sci-news.com/news/othersciences/chemistry",
            "http://cen.acs.org/news.html",
            "http://scienceworld.scholastic.com/Chemistry-News/"
    };

    private String[] kemija = {"sci american", "phys.org", "ifl science", "science daily", "science mag", "chem world", "ny times", "sci-news", "cen.acs.org", "science world"};

    private String[] clanci_matematika = {
            "http://www.scientificamerican.com/math/",
            "https://www.sciencedaily.com/news/computers_math/mathematics/",
            "http://phys.org/science-news/mathematics/",
            "https://plus.maths.org/content/News",
            "http://www.independent.co.uk/topic/Mathematics",
            "http://news.mit.edu/topic/mathematics",
            "http://www.usnews.com/topics/subjects/math",
            "http://math.alltop.com/",
            "http://www.nytimes.com/topic/subject/mathematics",
            "http://www.ams.org/news/math-in-the-media/mathdigest-index"
    };

    private String[] matematika = {"sci american", "science daily", "phys.org", "plus.maths.org", "independent.co.uk", "news mit", "us news", "math.alltop", "ny times", "ams.org"};

    private String[] clanci_tehnika = {
            "http://www.bbc.com/news/technology",
            "http://edition.cnn.com/tech",
            "http://www.cnet.com/news/",
            "http://www.technewsworld.com/",
            "http://www.theverge.com/tech",
            "http://timesofindia.indiatimes.com/tech/tech-news",
            "http://www.telegraph.co.uk/technology/news/",
            "http://www.extremetech.com/",
            "http://www.news.com.au/technology",
            "http://www.reuters.com/news/technology"
    };

    private String[] tehnika = {"bbc", "cnn", "cnet", "tech news world", "the verge", "times of india", "telegraph", "extreme tech", "news.com", "reuters"};

    private String[] clanci_medicina = {
            "http://www.bbc.com/news/us/health",
            "http://www.medicalnewstoday.com/",
            "https://www.sciencedaily.com/news/health_medicine/",
            "http://www.news-medical.net/",
            "http://www.livescience.com/health",
            "http://www.internalmedicinenews.com/",
            "http://www.medpagetoday.com/specialty",
            "http://med.stanford.edu/news.html",
            "http://med.stanford.edu/news/all-news.html",
            "http://edition.cnn.com/health"
    };

    private String[] medicina = {"bbc", "medical news today", "sci daily", "news medical", "live science", "inter med news", "med page", "standford", "stanford all", "cnn"};

    private String[] clanci_biologija = {
            "http://www.scientificamerican.com/biology/",
            "https://www.sciencedaily.com/news/plants_animals/biology/",
            "http://www.sci-news.com/news/biology",
            "http://phys.org/biology-news/",
            "http://www.biologynews.net/",
            "https://nsf.gov/news/index.jsp?prio_area=3",
            "http://www.sciencemag.org/category/biology",
            "http://www.usnews.com/topics/subjects/biology",
            "https://www.theguardian.com/science/biology",
            "http://scienceworld.scholastic.com/Biology-News/"
    };

    private String[] biologija = {"sci american", "sci daily", "sci news", "phys.org", "bio news", "nsf.gov", "science mag", "us news", "the guardian", "sci world"};

    private String[] clanci_astronomija = {
            "http://www.astronomy.com/news",
            "http://www.skyandtelescope.com/astronomy-news/",
            "http://phys.org/space-news/astronomy/",
            "https://www.sciencedaily.com/news/space_time/astronomy/",
            "https://astronomynow.com/category/news/",
            "http://www.sci-news.com/news/astronomy",
            "http://www.space.com/science-astronomy",
            "https://www.newscientist.com/subject/space/",
            "http://www.universetoday.com/",
            "http://www.skyatnightmagazine.com/astronomy-news"
    };

    private String[] astronomija = {"astronomy.com", "sky and telescope", "phys.org", "sci daily", "astronomy now", "sci news", "space", "new scientist", "universe today", "sky and night"};

    private String[] clanci_geologija = {
            "https://www.sciencedaily.com/news/earth_climate/geology/",
            "http://geology.com/",
            "http://www.sci-news.com/news/geology",
            "https://www.theguardian.com/science/geology",
            "http://geology.alltop.com/",
            "http://www.nature.com/subjects/geology",
            "http://www.livescience.com/environment",
            "http://www.geosociety.org/news/",
            "http://www.telegraph.co.uk/news/earth/environment/geology/",
            "http://www.independent.co.uk/topic/Geology"
    };

    private String[] geologija = {"sci daily", "geology", "sci news", "the guardian", "geology.alltop", "nature", "live sci", "geo society", "telegraph", "independent"};

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

        private String[] titles = {
                "Fizika",
                "Kemija",
                "Matematika",
                "Tehnika",
                "Medicina",
                "Biologija",
                "Astronomija",
                "Geologija"
        };

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
            holder.znanostTitle.setText(clanciHelper.getTitles()[position]);
//            holder.znanostImage.setImageResource(images[position]);
            holder.znanostImage.setImageResource(clanciHelper.getImages()[position]);
        }

        @Override
        public int getItemCount() {
            return clanciHelper.getTitles().length;
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
                        Intent intent = new Intent(MainActivity.this, WebActivity.class);
                        if (position == 0) {
                            intent.putExtra(fizika_clanci, fizika);
                        } else if (position == 1) {
                            intent.putExtra(kemija_clanci, kemija);
                        } else if (position == 2) {
                            intent.putExtra(matematika_clanci, matematika);
                        } else if (position == 3) {
                            intent.putExtra(tehnika_clanci, tehnika);
                        } else if (position == 4) {
                            intent.putExtra(medicina_clanci, medicina);
                        } else if (position == 5) {
                            intent.putExtra(biologija_clanci, biologija);
                        } else if (position == 6) {
                            intent.putExtra(astronomija_clanci, astronomija);
                        } else if (position == 7) {
                            intent.putExtra(geologija_clanci, geologija);
                        }
                        startActivity(intent);

                        Snackbar.make(view, "Click detected on item " + position, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                });
            }
        }
    }
}


