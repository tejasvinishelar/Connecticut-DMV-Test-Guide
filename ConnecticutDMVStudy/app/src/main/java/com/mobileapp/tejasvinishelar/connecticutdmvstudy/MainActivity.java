package com.mobileapp.tejasvinishelar.connecticutdmvstudy;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private LinearLayout linearLayout;
    private ActionBarDrawerToggle toggle;
    ImageView dmvimageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        dmvimageView = findViewById(R.id.imageView);

        toggle.syncState();

        ActionBar actionbar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight

                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        menuItem.setChecked(true);
                        int id = menuItem.getItemId();
                        /*if(id==R.id.test1){
                            dmvimage.setVisibility(View.INVISIBLE);
                            TestOneFragment test1 = new TestOneFragment();
                            transaction.replace(R.id.fragment,test1).commit();

                        }*/
                        switch (id) {
                            case R.id.test1:
                                dmvimageView.setVisibility(View.INVISIBLE);
                                TestOneFragment test1 = new TestOneFragment();
                                transaction.replace(R.id.fragment,test1).commit();
                                break;

                            case R.id.test2:
                                dmvimageView.setVisibility(View.INVISIBLE);
                                TestOneFragment test2 = new TestOneFragment();
                                transaction.replace(R.id.fragment,test2).commit();
                                break;

                            case R.id.dmvmanual:
                                dmvimageView.setVisibility(View.INVISIBLE);
                                ManualPDF manual = new ManualPDF();
                                transaction.replace(R.id.fragment,manual).commit();
                                break;
                        }
                        drawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        /*drawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );*/
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
        else if (id == R.id.action_help) {
            return true;
        }
        else if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        /*switch (item.getItemId()) {
            case android.R.id.home:
               // drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }*/
        return super.onOptionsItemSelected(item);

    }
}
