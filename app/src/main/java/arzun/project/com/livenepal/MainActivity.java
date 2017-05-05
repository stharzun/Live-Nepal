package arzun.project.com.livenepal;


import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;



public class MainActivity extends AppCompatActivity{
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;

    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= (Toolbar) findViewById(R.id.toolbar_id);
        drawerLayout= (DrawerLayout) findViewById(R.id.activity_main);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);

        setSupportActionBar(toolbar);

        actionBarDrawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.mainFrame,new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home");


    }
}
