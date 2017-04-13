package tw.brad.apps.contacttalent.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import tw.brad.apps.contacttalent.R;
import tw.brad.apps.contacttalent.adapter.TelAdapter;
import tw.brad.apps.contacttalent.model.TelRecord;
import tw.brad.apps.contacttalent.model.TelRecordDAO;

/**
 * Created by hungming on 2017/4/12.
 */

public class TelRecordFragment extends Fragment {
    private ListView listView;
    private TelAdapter adapter;
    private List<TelRecord> data;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.telrecord, container, false);
        listView = (ListView) rootView.findViewById(R.id.listview);
        new TelRecordDAO(this.getContext()).sample();
        data =  new TelRecordDAO(this.getContext()).getAll();
        adapter = new TelAdapter(this.getContext(),data);
        listView.setAdapter(adapter);
        return rootView;
    }
}
