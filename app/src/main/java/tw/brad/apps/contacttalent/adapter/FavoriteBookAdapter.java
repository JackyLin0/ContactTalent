package tw.brad.apps.contacttalent.adapter;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import tw.brad.apps.contacttalent.R;

/**
 * Created by hungming on 2017/4/18.
 */

public class FavoriteBookAdapter extends BaseExpandableListAdapter {
    private Context context;
    List<String> listDataHeader;
    HashMap<String, List<HashMap<String, String>>> listDataChild;

    public FavoriteBookAdapter(Context context, List<String> listDataHeader
            ,HashMap<String, List<HashMap<String, String>>> listDataChild)
    {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
    }


    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        return  this.listDataChild.get(this.listDataHeader.get(groupPosition)).size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);

    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerTitle = (String) getGroup(groupPosition); // 取得標題
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }
            /* 設置標題 */
        TextView tvHeader = (TextView) convertView
                .findViewById(R.id.stroke);
         tvHeader.setText(headerTitle+"劃");

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
         HashMap<String,String> childHash = (HashMap) getChild(groupPosition, childPosition);// 取得內容
        /* 設置內容layout */

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        /* 設置內容 */

        TextView favorite_name = (TextView) convertView.findViewById(R.id.favorite_name); //聯絡人
        ImageView favorite_dept =(ImageView) convertView.findViewById(R.id.favorite_dept); //部門
        TextView favorite_phone = (TextView) convertView.findViewById(R.id.favorite_phone); //電話
        ImageView favorite_phoneicon = (ImageView) convertView.findViewById(R.id.favorite_phoneicon); //電話圖示
        TextView favorite_company = (TextView) convertView.findViewById(R.id.favorite_company); //公司
        TextView favorite_city = (TextView) convertView.findViewById(R.id.favorite_city); //市
        TextView favorite_area = (TextView) convertView.findViewById(R.id.favorite_area); //區

        favorite_name.setText(childHash.get("favorite_name"));
      //  favorite_dept.setText(childHash.get("favorite_dept"));
        favorite_phone.setText(childHash.get("favorite_mobile"));
        favorite_company.setText(childHash.get("favorite_company"));
        favorite_city.setText(childHash.get("favorite_city"));
        favorite_area.setText(childHash.get("favorite_area"));

        Bitmap bm =null;
        Resources res =context.getResources();
        switch (Integer.valueOf(childHash.get("favorite_dept")))
        {
            case 0: bm = BitmapFactory.decodeResource(res,R.drawable.dept_customer); break;
            case 1: bm = BitmapFactory.decodeResource(res,R.drawable.dept_factory); break;
            case 2: bm = BitmapFactory.decodeResource(res,R.drawable.dept_employee); break;
        }
        favorite_dept.setImageBitmap(bm);
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
