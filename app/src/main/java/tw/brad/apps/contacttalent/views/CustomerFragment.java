package tw.brad.apps.contacttalent.views;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tw.brad.apps.contacttalent.R;

public class CustomerFragment extends Fragment {
    private Context context;
    private ViewPager customerViewPager;
    private TabLayout tabCustomer;
    private  TabLayout.Tab telRecord,customerInfo,priceReport,saleInfo;

    public CustomerFragment() {
     }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View customerView;
        context = container.getContext();
        customerView = inflater.inflate(R.layout.customer,container,false);
        customerViewPager = (ViewPager) customerView.findViewById(R.id.customerViewPager);
        tabCustomer = (TabLayout) customerView.findViewById(R.id.tabCustomer);
        initView();
        return customerView;
    }

    private void initView() {
        tabCustomer.setTabMode(TabLayout.MODE_FIXED);
        telRecord = tabCustomer.newTab(); // 通話紀錄
        customerInfo = tabCustomer.newTab(); // 客戶資料
        priceReport = tabCustomer.newTab(); // 報價資料
        saleInfo = tabCustomer.newTab(); // 銷售資料

        for (int i = 0; i < tabCustomer.getTabCount(); i++) {
            TabLayout.Tab tab = tabCustomer.getTabAt(i);
            if (tab != null) tab.setCustomView(R.layout.tab_items);

        }

        // 通話紀錄
        View view1 = ((Activity)context).getLayoutInflater().inflate(R.layout.tab_items, null);
        TextView tv1= (TextView) view1.findViewById(R.id.tv_title);
        tv1.setText(getResources().getString(R.string.tel_record));
        tv1.setGravity(Gravity.CENTER);
        telRecord.setCustomView(view1);

        View view2 = ((Activity)context).getLayoutInflater().inflate(R.layout.tab_items, null);
        TextView tv2= (TextView) view2.findViewById(R.id.tv_title);
        tv2.setText(getResources().getString(R.string.customer_Info));
        tv2.setGravity(Gravity.CENTER);
        customerInfo.setCustomView(view2);

        View view3 = ((Activity)context).getLayoutInflater().inflate(R.layout.tab_items, null);
        TextView tv3= (TextView) view3.findViewById(R.id.tv_title);
        tv3.setText(getResources().getString(R.string.priceReport));
        tv3.setGravity(Gravity.CENTER);
        priceReport.setCustomView(view3);

        View view4 = ((Activity)context).getLayoutInflater().inflate(R.layout.tab_items, null);
        TextView tv4 = (TextView) view4.findViewById(R.id.tv_title);
        tv4.setText(getResources().getString(R.string.saleInfo));
        tv4.setGravity(Gravity.CENTER);
        saleInfo.setCustomView(view4);


        tabCustomer.addTab(telRecord);
        tabCustomer.addTab(customerInfo);
        tabCustomer.addTab(priceReport);
        tabCustomer.addTab(saleInfo);
        tabCustomer.setSelectedTabIndicatorColor(Color.WHITE);
        tabCustomer.setSelectedTabIndicatorHeight(10);
    }


}
