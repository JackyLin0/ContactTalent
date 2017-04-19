package tw.brad.apps.contacttalent.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import tw.brad.apps.contacttalent.R;
import tw.brad.apps.contacttalent.adapter.FavoriteBookAdapter;
import tw.brad.apps.contacttalent.model.FavoriteBook;
import tw.brad.apps.contacttalent.model.FavoriteDAO;

/**
 * Created by hungming on 2017/4/12.
 */

public class FavoriteFragment extends Fragment {
    private ExpandableListView expListView;
    private List<FavoriteBook> data;
    private FavoriteBookAdapter adapter;
    private List<String> listDataHeader;
    private HashMap<String,List<HashMap<String,String>>> listDataChild;
    private FavoriteDAO dao;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listDataHeader = new LinkedList<>();
        listDataChild = new LinkedHashMap<>();

        View rootView = inflater.inflate(
                R.layout.favorite, container, false);
        expListView = (ExpandableListView) rootView.findViewById(R.id.expListView);
       //  測試時期假資料
        dao = new FavoriteDAO(this.getContext());
        if ((data = dao.getAll()).size()==0)
        {
            new FavoriteDAO(this.getContext()).sample();
        }
        initData(dao);
        parseData(dao);
        adapter= new FavoriteBookAdapter(getContext(),listDataHeader,listDataChild);

        expListView.setAdapter(adapter);
        for (int i =0 ;i<listDataHeader.size();i++)
        {
            expListView.expandGroup(i);
        }
        adapter.notifyDataSetChanged();
        return rootView;
    }

    private void parseData(FavoriteDAO  dao)
    {
        Log.v("Jacky",listDataHeader.toString());
        for(String s:listDataHeader) {
          Log.v("Jacky" ,s+"==>"+listDataChild.get(s));
        }
    }

    private void initData(FavoriteDAO  dao) {
        //加上筆畫
        for (String s:dao.getStroke())
        {
            listDataHeader.add(s);
            List <HashMap<String,String>> temp = new LinkedList<>();;
            for (FavoriteBook fb : dao.getDataByStroke(s))
            {

                HashMap<String,String> h =new HashMap<>();
                h.put("favorite_name",fb.getFavorite_name());
                h.put("favorite_phone",fb.getFavorite_phone());
                h.put("favorite_dept",fb.getFavorite_dept());
                h.put("favorite_mobile",fb.getFavorite_mobile());
                h.put("favorite_company",fb.getFavorite_company());
                h.put("favorite_city",fb.getFavorite_city());
                h.put("favorite_area",fb.getFavorite_area());
                temp.add(h);
                listDataChild.put(s,temp);
            }

        }
    }
}
