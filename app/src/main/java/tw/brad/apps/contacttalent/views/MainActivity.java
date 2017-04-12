package tw.brad.apps.contacttalent.views;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import tw.brad.apps.contacttalent.R;
import tw.brad.apps.contacttalent.adapter.ContactFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity  {
    private RadioGroup radioGroup;
    private RadioButton telRecord,contant,favorite,setting;
    private ViewPager viewPager;
    private TelRecordFragment tel_recordFragment;
    private ContactFragment contactbookFragment;
    private FavoriteFragment favoriteFragment;
    private SettingFragment settingFragment;
    private List<Fragment> allFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        telRecord = (RadioButton) findViewById(R.id.tel_record);
        contant = (RadioButton) findViewById(R.id.contact);
        favorite = (RadioButton) findViewById(R.id.favorite);
        setting = (RadioButton) findViewById(R.id.setting);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId) {
                    case R.id.tel_record:
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.contact:
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.favorite:
                        viewPager.setCurrentItem(2, false);
                        break;
                    case R.id.setting:
                        viewPager.setCurrentItem(3, false);
                        break;
                }
            }
        });

        tel_recordFragment = new TelRecordFragment(); //聯絡人
        contactbookFragment = new ContactFragment(); //電話簿
        favoriteFragment = new FavoriteFragment(); //我的最愛
        settingFragment = new SettingFragment(); //我的最愛
        allFragment = new ArrayList<Fragment>();
        allFragment.add(tel_recordFragment);
        allFragment.add(contactbookFragment);
        allFragment.add(favoriteFragment);
        allFragment.add(settingFragment);

        viewPager.setAdapter(new ContactFragmentPagerAdapter(getSupportFragmentManager(),allFragment));
        viewPager.setCurrentItem(1);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.tel_record);
                        break;

                    case 1:
                        radioGroup.check(R.id.contact);
                        break;
                    case 2:
                        radioGroup.check(R.id.favorite);
                        break;
                    case 3:
                        radioGroup.check(R.id.setting);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    } // end of initView
}

