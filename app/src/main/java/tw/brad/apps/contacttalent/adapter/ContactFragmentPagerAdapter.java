package tw.brad.apps.contacttalent.adapter;


import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import tw.brad.apps.contacttalent.views.ContactFragment;
import tw.brad.apps.contacttalent.views.FavoriteFragment;
import tw.brad.apps.contacttalent.views.SettingFragment;
import tw.brad.apps.contacttalent.views.TelRecordFragment;


/**
 * Created by hungming on 2017/4/12.
 */

public class ContactFragmentPagerAdapter extends FragmentPagerAdapter {
    private int count;
    private Context context;
    private TabLayout tabLayout;

    public ContactFragmentPagerAdapter(FragmentManager fm, TabLayout tabLayout) {
        super(fm);
        this.tabLayout = tabLayout ;

    }

    @Override
    public Fragment getItem(int position) {

        TelRecordFragment tel_recordFragment = new TelRecordFragment(); //聯絡人
        ContactFragment  contactbookFragment = new ContactFragment(); //電話簿
        FavoriteFragment favoriteFragment = new FavoriteFragment(); //我的最愛
        SettingFragment settingFragment = new SettingFragment(); //我的最愛
        List<Fragment> allFragment = new ArrayList<Fragment>();
        allFragment.add(tel_recordFragment);
        allFragment.add(contactbookFragment);
        allFragment.add(favoriteFragment);
        allFragment.add(settingFragment);

        return  allFragment.get(position);
    }

    @Override
    public int getCount() {
        return tabLayout.getTabCount();
    }
}
