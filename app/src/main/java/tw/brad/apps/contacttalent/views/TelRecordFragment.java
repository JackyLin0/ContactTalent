package tw.brad.apps.contacttalent.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tw.brad.apps.contacttalent.R;
import tw.brad.apps.contacttalent.adapter.TelAdapter;
import tw.brad.apps.contacttalent.model.TelRecord;
import tw.brad.apps.contacttalent.model.TelRecordDAO;

/**
 * Created by hungming on 2017/4/12.
 */

public class TelRecordFragment extends Fragment {
    private RecyclerView recyclerView;
    private TelAdapter adapter;
    private List<TelRecord> data = null;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.telrecord, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        //  測試時期假資料
        if ((data = new TelRecordDAO(this.getContext()).getAll()).size()==0)
        {
            new TelRecordDAO(this.getContext()).sample();
        }

        adapter = new TelAdapter(this.getContext(),data);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return rootView;
    }
}
