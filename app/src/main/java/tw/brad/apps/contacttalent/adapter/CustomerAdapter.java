package tw.brad.apps.contacttalent.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hungming on 2017/5/7.
 */

public class CustomerAdapter extends FragmentPagerAdapter {
    TabLayout tabCustomer;

    public CustomerAdapter(TabLayout tabCustomer, FragmentManager fm) {
        super(fm);
        this.tabCustomer = tabCustomer;
    }


    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
