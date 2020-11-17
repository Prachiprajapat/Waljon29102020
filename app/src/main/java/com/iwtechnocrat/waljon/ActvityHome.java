package com.iwtechnocrat.waljon;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.iwtechnocrat.waljon.Activities.Act_Cart;
import com.iwtechnocrat.waljon.Activities.Act_Search;
import com.iwtechnocrat.waljon.Activities.Act_Wishlist;
import com.iwtechnocrat.waljon.GoogleMap.PlaceSearch;
import com.iwtechnocrat.waljon.UI.Converter;

public class ActvityHome extends AppCompatActivity {
    Toolbar toolbar;
    MenuItem qr_code, location,cart,search;
    int total=0,count1=0;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actvity_home);

        toolbar =findViewById(R.id.toolbar);
       // toolbar.setLogo(R.drawable.main_logo);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Make toolbar show navigation button (i.e back button with arrow icon)
       // toolbar.setNavigationIcon(R.drawable.main_logo); // Replace arrow icon with our custom icon





        //toolbar.getLogo().methodForFloatRightHere();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_for_home, menu);
        MenuItem menuItem=menu.findItem(R.id.cart1);

        menuItem.setIcon(Converter.convertLayoutToImage(ActvityHome.this,count1,R.drawable.ic_shoppingbag));

        location=menu.findItem(R.id.location);
        cart = menu.findItem(R.id.cart1);
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
                Intent intent3 = new Intent(getApplicationContext(), Act_Cart.class);
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