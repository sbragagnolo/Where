package es.com.donde.app;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by santiago on 5/23/14.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    private Fragment [] tabs = { new OrganiseFragment(), new JoinFragment(),  new PlayNowFragment()};

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        if(index < tabs.length) {
            return this.tabs[index];
        } else {
            return null;
        }

    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
