package com.iwtechnocrat.waljon;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.iwtechnocrat.waljon.Activities.Act_Cart;
import com.iwtechnocrat.waljon.Activities.Act_Profile;
import com.iwtechnocrat.waljon.Activities.Act_Search;
import com.iwtechnocrat.waljon.Activities.Act_Wishlist;
import com.iwtechnocrat.waljon.Activities.CartActivity;
import com.iwtechnocrat.waljon.Cart.Myhelper;
import com.iwtechnocrat.waljon.Fragment.Categories_Frag;
import com.iwtechnocrat.waljon.Fragment.HommeeFragment;
import com.iwtechnocrat.waljon.GoogleMap.PlaceSearch;
import com.iwtechnocrat.waljon.UI.Converter;

public class Act_Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {

    DrawerLayout dLayout;
    Toolbar  toolbar;
    SearchView mSearchView;
    BottomNavigationView navigation;
    ImageView search,wishlist,map,cart;
    int total=0,count1=0;
    MenuItem qr_code, location,cart1,search1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__admin_home);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadFragment(new HommeeFragment());


       navigation = findViewById(R.id.navigation);
        cart = findViewById(R.id.cart);
        wishlist = findViewById(R.id.wishlist);
        navigation.setOnNavigationItemSelectedListener(this);
        search = findViewById(R.id.search);
        map = findViewById(R.id.map);

        Menu a = navigation.getMenu();
        MenuItem b = a.findItem(R.id.nav_home);
        navigation.setItemIconTintList(null);
       // BVMenu.setItemIconTintList(null);
        b.setIcon(R.drawable.wlogo11);


        Myhelper myhelper1=new Myhelper(this);
        SQLiteDatabase database1 = myhelper1.getReadableDatabase();
        String sql1 = "select * from CART";
        Cursor c1 = database1.rawQuery(sql1,null);
        while(c1.moveToNext()){
            count1++;
        }


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_Search.class);
                startActivity(intent);
            }
        });


        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_Wishlist.class);
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlaceSearch.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_Cart.class);
                startActivity(intent);
            }
        });
        cart.setImageDrawable(Converter.convertLayoutToImage(Act_Home.this,count1,R.drawable.ic_shoppingbag));


    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.nav_home:
                fragment = new HommeeFragment();
                break;

            case R.id.nav_profile:
              Intent intent = new Intent(getApplicationContext(), Act_Profile.class);
              startActivity(intent);
                break;
   case R.id.nav_categories:
       com.iwtechnocrat.waljon.Activities.Act_CAtegories bottomSheet = new com.iwtechnocrat.waljon.Activities.Act_CAtegories();
       bottomSheet.show(getSupportFragmentManager(),
               "ModalBottomSheet");
                break;


        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commitAllowingStateLoss();
            return true;
        }
        return false;
    }

    private void setUpHomeFragment(){
        HommeeFragment homeFrag =new HommeeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame, homeFrag);
        ft.addToBackStack(null);
        ft.commit();
    }






    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
//        HommeeFragment homeFrag =new HommeeFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction ft = fragmentManager.beginTransaction();
//        ft.replace(R.id.frame, homeFrag);
//        ft.addToBackStack(null);
//        ft.commit();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_for_home, menu);
        MenuItem menuItem=menu.findItem(R.id.cart1);

        menuItem.setIcon(Converter.convertLayoutToImage(Act_Home.this,count1,R.drawable.ic_shoppingbag));

        location=menu.findItem(R.id.location);
        cart1 = menu.findItem(R.id.cart1);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.location:
                finish();
                Intent intent = new Intent(getApplicationContext(), PlaceSearch.class);

                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
//
            case R.id.wishlist:
                finish();
                Intent intent2 = new Intent(getApplicationContext(), Act_Wishlist.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.cart1:
                finish();
                Intent intent3 = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.search:
                finish();
                Intent intent4 = new Intent(getApplicationContext(), Act_Search.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;



        }
        return super.onOptionsItemSelected(item);
    }


}