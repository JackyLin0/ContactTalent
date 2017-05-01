package tw.brad.apps.contacttalent.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tw.brad.apps.contacttalent.R;
import tw.brad.apps.contacttalent.adapter.ContactBookAdapter;
import tw.brad.apps.contacttalent.model.ContactBook;
import tw.brad.apps.contacttalent.model.ContactBookDAO;

/**
 * Created by hungming on 2017/4/11.
 */

public class ContactFragment  extends Fragment {
    private RecyclerView listView;
    private List<ContactBook> data;
    private ContactBookAdapter adapter;
    private TextView tv_menu;
    private static final int MENU_ALL = Menu.FIRST;
    private static final int MENU_ID = MENU_ALL+1;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contactbook, container, false);
        tv_menu = (TextView) rootView.findViewById(R.id.tv_menu);
        registerForContextMenu(rootView);
        listView = (RecyclerView) rootView.findViewById(R.id.contactlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);

        //  測試時期假資料
        if ((data = new ContactBookDAO(this.getContext()).getAll()).size()==0)
        {
            new ContactBookDAO(this.getContext()).sample();
        }

        adapter = new ContactBookAdapter(this.getContext(),data);
        listView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getActivity().getMenuInflater().inflate(R.menu.general_menu, menu);
     }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.all:
                tv_menu.setText(R.string.all);
                break;
            case R.id.id:
                tv_menu.setText(R.string.id);
                break;
            case R.id.name:
                tv_menu.setText(R.string.name);
                break;
            case R.id.contact:
                tv_menu.setText(R.string.contact);
                break;
            case R.id.tel:
                tv_menu.setText(R.string.tel);
                break;
            case R.id.address:
                tv_menu.setText(R.string.address);
                break;
            case R.id.memo:
                tv_menu.setText(R.string.memo);
                break;

        }
        return super.onContextItemSelected(item);
    }


}
