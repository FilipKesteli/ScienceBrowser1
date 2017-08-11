package com.kesteli.filip.sciencebrowser1.aplikacije.realitycheck;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kesteli.filip.sciencebrowser1.DatabaseHandler;
import com.kesteli.filip.sciencebrowser1.R;
import com.kesteli.filip.sciencebrowser1.bazapodataka.Stranica;
import com.kesteli.filip.sciencebrowser1.web.history.EurekaActivity;
import com.kesteli.filip.sciencebrowser1.web.history.EurekaDeleteAllDialog;
import com.kesteli.filip.sciencebrowser1.web.history.FavoriteActivity;
import com.kesteli.filip.sciencebrowser1.web.history.HistoryActivity;

import java.util.ArrayList;
import java.util.List;

public class RealityActivity extends AppCompatActivity {

    private List<Stranica> straniceEUREKA = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reality);
        setupToolbar();
        setupListeners();

        setupDatabase();
        setupRecyclerView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(RealityActivity.this, "Result: " + resultCode, Toast.LENGTH_SHORT).show();
        if (resultCode == Activity.RESULT_OK) {
            setupDatabase();
            setupRecyclerView();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private static final int REQ_CODE = 1;

    private void setupListeners() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRealityClan = new Intent(RealityActivity.this, RealityClanActivity.class);
                startActivity(intentRealityClan);
            }
        });
    }

    private void setupDatabase() {
        DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());
        List<Stranica> stranice = databaseHandler.getAllStranice();
        for (int i = 0; i < stranice.size(); i++) {
            if (stranice != null && stranice.get(i).get_eureka() == 1) {
                straniceEUREKA.add(stranice.get(i));
            }
        }
    }

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private GridLayoutManager gridLayoutManager; //kartice u mreži

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_history);
        gridLayoutManager = new GridLayoutManager(RealityActivity.this, 2);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }


    /**
     * Inner Klasa za prepoznavanje recycler viewa
     */
    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_layout_reality_tim, parent, false);
            RecyclerAdapter.ViewHolder viewHolder = new RecyclerAdapter.ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tvSite.setText(straniceEUREKA.get(position).get_site());
        }

//        private List<Stranica> stranice;

        @Override
        public int getItemCount() {
            return straniceEUREKA.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public List<Stranica> stranice;
            public TextView tvSite;

            public ViewHolder(View itemView) {
                super(itemView);
                tvSite = (TextView) itemView.findViewById(R.id.tvSite);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();

                    }
                });
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eureka, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_history) {
            Intent intent = new Intent(RealityActivity.this, HistoryActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_favorite) {
            Intent intent = new Intent(RealityActivity.this, FavoriteActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}