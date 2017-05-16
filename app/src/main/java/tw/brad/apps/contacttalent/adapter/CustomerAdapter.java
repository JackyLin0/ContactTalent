package tw.brad.apps.contacttalent.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import tw.brad.apps.contacttalent.views.CustomerInfoFragment;
import tw.brad.apps.contacttalent.views.PriceReportFragment;
import tw.brad.apps.contacttalent.views.SaleInfoFragment;
import tw.brad.apps.contacttalent.views.TelRecordFragment;

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

        TelRecordFragment tel_recordFragment = new TelRecordFragment(); //通話紀錄
        CustomerInfoFragment contactbookFragment = new CustomerInfoFragment(); //客戶資料
        PriceReportFragment priceReportFragment = new PriceReportFragment(); //客戶報價
        SaleInfoFragment saleInfoFragment = new SaleInfoFragment(); //銷貨資料
        List<Fragment> allFragment = new ArrayList<Fragment>();
        allFragment.add(tel_recordFragment);
        allFragment.add(contactbookFragment);
        allFragment.add(priceReportFragment);
        allFragment.add(saleInfoFragment);

        return  allFragment.get(position);    }

    @Override
    public int getCount() {
        return tabCustomer.getTabCount();
    }
}
