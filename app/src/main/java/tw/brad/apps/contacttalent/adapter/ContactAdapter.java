package tw.brad.apps.contacttalent.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tw.brad.apps.contacttalent.R;
import tw.brad.apps.contacttalent.model.TelRecord;

/**
 * Created by hungming on 2017/4/12.
 */

public class ContactAdapter extends BaseAdapter {
    private  List<TelRecord> data;
    private LayoutInflater inflater;
    private Context context;

     public ContactAdapter(Context context, List<TelRecord> data)
    {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView !=null){
            holder  = (Holder) convertView.getTag();
        }
        else {
            convertView = inflater.inflate(R.layout.telrecorditem, parent, false);
            holder = new Holder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.company = (TextView) convertView.findViewById(R.id.company);
            holder.dept = (ImageView) convertView.findViewById(R.id.dept);
            holder.dTime = (TextView) convertView.findViewById(R.id.dTime);
            holder.phone = (TextView) convertView.findViewById(R.id.phone);
            convertView.setTag(holder);
         }
         Log.v("Jacky",data.get(position).toString());
         holder.name.setText(data.get(position).getName());
         holder.phone.setText(data.get(position).getMobile());
         holder.dTime.setText(data.get(position).getdTime());
         holder.company.setText(data.get(position).getCompany());
         Bitmap bm =null;
        Resources  res =context.getResources();
        switch (Integer.valueOf(data.get(position).getDept()))
        {
            case 0: bm = BitmapFactory.decodeResource(res,R.drawable.dept_customer); break;
            case 1: bm = BitmapFactory.decodeResource(res,R.drawable.dept_factory); break;
            case 2: bm = BitmapFactory.decodeResource(res,R.drawable.dept_employee); break;
        }
        holder.dept.setImageBitmap(bm);


        return convertView;
    }


    class Holder{
        TextView name,phone,company,dTime;
        ImageView dept;
    }

}
