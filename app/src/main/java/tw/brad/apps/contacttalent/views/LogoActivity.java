package tw.brad.apps.contacttalent.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import tw.brad.apps.contacttalent.R;

public class LogoActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
    }

    public void toContact(View v)
    {
        Intent it = new Intent();
        it.setClass(this,MainActivity.class);
        startActivity(it);
    }
}
