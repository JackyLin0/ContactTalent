package tw.brad.apps.contacttalent.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tw.brad.apps.contacttalent.R;
import tw.brad.apps.contacttalent.model.ContactBook;

/**
 * Created by hungming on 2017/4/12.
 */

public class ContactBookAdapter extends BaseAdapter {
    private  List<ContactBook> data;
    private LayoutInflater inflater;
    private Context context;

    public ContactBookAdapter(Context context, List<ContactBook> data)
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
            convertView = inflater.inflate(R.layout.contactitem, parent, false);
            holder = new Holder();
            holder.contact_id = (TextView) convertView.findViewById(R.id.contact_id);
            holder.contact_name = (TextView) convertView.findViewById(R.id.contact_name);
            holder.contact_company = (TextView) convertView.findViewById(R.id.contact_company);
            holder.contact_dept = (ImageView) convertView.findViewById(R.id.contact_dept);
            holder.contact_phone = (TextView) convertView.findViewById(R.id.contact_phone);
            holder.postal = (TextView) convertView.findViewById(R.id.postal);
            holder.address = (TextView) convertView.findViewById(R.id.address);
            convertView.setTag(holder);
         }
         holder.contact_id.setText(data.get(position).getContact_id());
         holder.contact_name.setText(data.get(position).getContact_name());
         holder.contact_phone.setText(data.get(position).getContact_mobile());
         holder.contact_company.setText(data.get(position).getContact_company());
         holder.postal.setText(data.get(position).getContact_postal());
         holder.address.setText(data.get(position).getContact_address());
         Bitmap bm =null;
        Resources  res =context.getResources();
        switch (Integer.valueOf(data.get(position).getContact_dept()))
        {
            case 0: bm = BitmapFactory.decodeResource(res,R.drawable.dept_customer); break;
            case 1: bm = BitmapFactory.decodeResource(res,R.drawable.dept_factory); break;
            case 2: bm = BitmapFactory.decodeResource(res,R.drawable.dept_employee); break;
        }
        holder.contact_dept.setImageBitmap(bm);


        return convertView;
    }


    class Holder{
        TextView  contact_photo,contact_id,contact_name , contact_phone,contact_company,postal,address ;
        ImageView contact_phoneicon,contact_dept;
    }

}
