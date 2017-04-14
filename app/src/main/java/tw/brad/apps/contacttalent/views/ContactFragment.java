package tw.brad.apps.contacttalent.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import tw.brad.apps.contacttalent.R;
import tw.brad.apps.contacttalent.adapter.ContactBookAdapter;
import tw.brad.apps.contacttalent.model.ContactBook;
import tw.brad.apps.contacttalent.model.ContactBookDAO;

/**
 * Created by hungming on 2017/4/11.
 */

public class ContactFragment  extends Fragment {
    private ListView listView;
    private List<ContactBook> data;
    private ContactBookAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contactbook, container, false);
        listView = (ListView) rootView.findViewById(R.id.contactlist);
        //  測試時期假資料
        if ((data = new ContactBookDAO(this.getContext()).getAll()).size()==0)
        {
            new ContactBookDAO(this.getContext()).sample();
        }
        Log.v("Jacky",data.toString());

        adapter = new ContactBookAdapter(this.getContext(),data);
        listView.setAdapter(adapter);
        return rootView;
    }


}
