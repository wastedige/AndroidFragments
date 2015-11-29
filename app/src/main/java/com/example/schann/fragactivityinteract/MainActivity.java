package com.example.schann.fragactivityinteract;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.OnHeadlineSelectedListener {

    TextView textViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        textViewMain = (TextView) findViewById(R.id.textViewMain);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (findViewById(R.id.empty) != null) {
            if (savedInstanceState != null) {
                return;
            }

        }

        MainActivityFragment fragInstance = new MainActivityFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.empty, fragInstance).commit();

        //MainActivityFragment fragInstance = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        //fragInstance.ChangeTxtViewOnFrag("Frag function called from Main activity's Oncreate.");
    }

    @Override
    public void onArticleSelected(int length) {
        textViewMain.setText( "String length on Frag is now " + length );
        Log.d("LENGTH", "String length is now " + length );
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
