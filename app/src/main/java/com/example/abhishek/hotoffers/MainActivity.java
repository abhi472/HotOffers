package com.example.abhishek.hotoffers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Content> content = new ArrayList<>();
    RecyclerView rv;
    Content contents = new Content();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        rv = (RecyclerView) findViewById(R.id.rv);

        for (int i = 0; i < 100; i++) {
            contents.desc = "Best Collections of Bike Accessories Helmets and Spares starting from 99 only";
                contents.resources = R.drawable.image_1;
            contents.resource2 = R.drawable.abof;
            content.add(contents);

        }
        setupRecyclerView(rv, content);


    }

    void setupRecyclerView(RecyclerView rv, ArrayList<Content> cont) {
        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.setAdapter(new RecyclerViewAdapter(this,cont));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
