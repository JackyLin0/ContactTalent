package tw.brad.apps.contacttalent.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tw.brad.apps.contacttalent.R;

/**
 * Created by hungming on 2017/4/12.
 */

public class TelRecordFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.telrecord, container, false);

        return rootView;
    }
}
