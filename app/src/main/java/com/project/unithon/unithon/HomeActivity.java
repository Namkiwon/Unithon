package com.project.unithon.unithon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.project.unithon.unithon.Fragment.FirstFragment;
import com.project.unithon.unithon.Fragment.SecondFragment;
import com.project.unithon.unithon.Fragment.ThirdFragment;

/**
 * Created by namgiwon on 2018. 1. 25..
 */

public class HomeActivity extends AppCompatActivity {
    private ViewPager vp;

    private FirstFragment first;
    private SecondFragment second;

    Fragment cur_fragment = new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Home");
        vp = (ViewPager) findViewById(R.id.home_viewpager);
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);

        first = new FirstFragment();
        second = new SecondFragment();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        //or switch문을 이용하면 될듯 하다.
        if (id == R.id.first_page) {
            vp.setCurrentItem(0);
            return true;
        }
        if (id == R.id.second_page) {
            vp.setCurrentItem(1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener movePageListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();
            vp.setCurrentItem(tag);
        }
    };

    private class pagerAdapter extends FragmentStatePagerAdapter
    {
        public pagerAdapter(android.support.v4.app.FragmentManager fm)
        {
            super(fm);
        }
        @Override
        public android.support.v4.app.Fragment getItem(int position)
        {
            switch(position)
            {
                case 0:
                    return first;
                case 1:
                    return second;
                default:
                    return null;
            }

        }
        @Override
        public int getCount()
        {
            return 2;
        }
    }




}
