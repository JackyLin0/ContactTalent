package tw.brad.apps.contacttalent.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tw.brad.apps.contacttalent.R;

/**
 * Created by hungming on 2017/5/7.
 */

public class CustomerInfoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.customer_info,container,false);
        return v;
    }
}
