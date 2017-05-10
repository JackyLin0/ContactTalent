package tw.brad.apps.contacttalent.views;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import tw.brad.apps.contacttalent.R;
import tw.brad.apps.contacttalent.adapter.ContactFragmentPagerAdapter;

public class MainActivity extends FragmentActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private  TabLayout.Tab telRecord,contact,favorite,setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tabLayout = (android.support.design.widget.TabLayout) findViewById(R.id.tab);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        telRecord = tabLayout.newTab(); // 電話紀錄
        contact = tabLayout.newTab(); // 聯絡人
        favorite = tabLayout.newTab(); // 我的最愛
        setting = tabLayout.newTab(); // 設定


        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) tab.setCustomView(R.layout.tab_items);

        }
        View view1 = getLayoutInflater().inflate(R.layout.tab_items, null);
        view1.findViewById(R.id.img_title).setBackgroundResource(R.mipmap.telrecorda);
        TextView tv1= (TextView) view1.findViewById(R.id.tv_title);
        tv1.setText(getResources().getString(R.string.tel_record));
        tv1.setGravity(Gravity.CENTER);
        telRecord.setCustomView(view1);

        View view2 = getLayoutInflater().inflate(R.layout.tab_items, null);
        view2.findViewById(R.id.img_title).setBackgroundResource(R.mipmap.contacta);
        TextView tv2 = (TextView) view2.findViewById(R.id.tv_title);
        tv2.setText(getResources().getString(R.string.contact));
        tv2.setGravity(Gravity.CENTER);

        contact.setCustomView(view2);

        View view3 = getLayoutInflater().inflate(R.layout.tab_items, null);
        view3.findViewById(R.id.img_title).setBackgroundResource(R.mipmap.favoritea);
        TextView tv3 = (TextView) view3.findViewById(R.id.tv_title);
        tv3.setText(getResources().getString(R.string.favorite));
        tv3.setGravity(Gravity.CENTER);

        favorite.setCustomView(view3);

        View view4 = getLayoutInflater().inflate(R.layout.tab_items, null);
        view4.findViewById(R.id.img_title).setBackgroundResource(R.mipmap.settinga);
        TextView tv4 = (TextView) view4.findViewById(R.id.tv_title);
        tv4.setText(getResources().getString(R.string.setting));
        tv4.setGravity(Gravity.CENTER);

        setting.setCustomView(view4);


        tabLayout.addTab(telRecord);
        tabLayout.addTab(contact);
        tabLayout.addTab(favorite);
        tabLayout.addTab(setting);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ContactFragmentPagerAdapter(getSupportFragmentManager(),tabLayout));
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayout.setSelectedTabIndicatorHeight(10);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
            }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

       viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                telRecord.getCustomView().findViewById(R.id.img_title).setBackgroundResource(R.mipmap.telrecorda);
                contact.getCustomView().findViewById(R.id.img_title).setBackgroundResource(R.mipmap.contacta);
                favorite.getCustomView().findViewById(R.id.img_title).setBackgroundResource(R.mipmap.favoritea);
                setting.getCustomView().findViewById(R.id.img_title).setBackgroundResource(R.mipmap.settinga);
                switch (position)
                {
                    case 0:
                        telRecord.getCustomView().findViewById(R.id.img_title).setBackgroundResource(R.mipmap.telrecordb);
                        tabLayout.getTabAt(0).select();
                        break;
                    case 1:
                        contact.getCustomView().findViewById(R.id.img_title).setBackgroundResource(R.mipmap.contactb);
                        tabLayout.getTabAt(1).select();

                        break;
                    case 2:
                        favorite.getCustomView().findViewById(R.id.img_title).setBackgroundResource(R.mipmap.favoriteb);
                        tabLayout.getTabAt(2).select();

                        break;
                    case 3:
                        setting.getCustomView().findViewById(R.id.img_title).setBackgroundResource(R.mipmap.settingb);

                        tabLayout.getTabAt(3).select();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });





    } // end of initView
}

