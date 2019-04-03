package com.example.login;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.Button;
import android.content.Intent;

public class Left extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    // объявляем fab
    ImageButton floatButton;
    // объявляем обновление списка диалогов (вращающийся прогресс бар )
    SwipeRefreshLayout swipeRefreshLayout;

    int number = 0;

    protected String name, second_name, email, password, birthday_date;

    TextView textView_name;
    TextView textView_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                number ++;

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 4000);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // реализация нажатия кнопки fab
        floatButton = (ImageButton) findViewById(R.id.imageButton);
        floatButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

              //  Toast.makeText(getApplicationContext(),
                     //   "Button is clicked", Toast.LENGTH_LONG).show();
            //    v.startAnimation(animAlpha);
              //  AlertDialog.Builder mBuilder = new AlertDialog.Builder(Left.this);
             //   View mView = getLayoutInflater().inflate(R.layout.create_new_group, null);
             //   final EditText crName = (EditText) mView.findViewById(R.id.editText8);
               // Button mLogin = (Button) mView.findViewById(R.id.btn_create);

               /* mLogin.setOnClickListener(new View.OnClickListener()){
                    @Override
                   /* public void onClick(View view) {

                    }

                }*/
           // });
             //   mBuilder.setView(mView);
            //    AlertDialog dialog  = mBuilder.create();
             //   dialog.show();
            }
        });





        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);

        name = getIntent().getStringExtra("name");
        second_name = getIntent().getStringExtra("second_name");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");
        birthday_date = getIntent().getStringExtra("birthday_date");

        textView_name = (TextView) headerView.findViewById(R.id.textView_name);
        textView_email = (TextView) headerView.findViewById(R.id.textView_email);

        textView_name.setText(name+" "+second_name);
        textView_email.setText(email);
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
        getMenuInflater().inflate(R.menu.left, menu);
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
        // переход по кнопке (в правом углу ) на  замекти
        if (id == R.id.next){
            Intent intent = new Intent(this, TskActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.esc) {
            // Handle the camera action
        } else if (id == R.id.pro) {

        } else if (id == R.id.cal) {
            Intent intent = new Intent(this, CalendarActivity.class);
            startActivity(intent);
            return false;

        } else if (id == R.id.them) {

        } else if (id == R.id.sett) {

            Intent intent = new Intent(this, SettingsActivity.class);

            intent.putExtra("name", name);
            intent.putExtra("second_name", second_name);
            intent.putExtra("email", email);
            intent.putExtra("password", password);
            intent.putExtra("birthday_date", birthday_date);

            startActivity(intent);
            return false;



        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }








}
