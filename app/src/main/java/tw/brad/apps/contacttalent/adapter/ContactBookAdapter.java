package tw.brad.apps.contacttalent.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tw.brad.apps.contacttalent.R;
import tw.brad.apps.contacttalent.model.ContactBook;

/**
 * Created by hungming on 2017/4/12.
 */

public class ContactBookAdapter extends RecyclerView.Adapter<ContactBookAdapter.ViewHolder> {
    private  List<ContactBook> data;
    private LayoutInflater inflater;
    private Context context;

    public  ContactBookAdapter(Context context,List<ContactBook> data)
    {
        this.context = context;
        this.data = data;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView contact_id,contact_name , contact_phone,contact_company,postal,address ;
        ImageView contact_photo,contact_phoneicon,contact_dept;
        public ViewHolder(View v) {
            super(v);
             contact_photo = (ImageView) v.findViewById(R.id.contact_photo);
            contact_phoneicon = (ImageView) v.findViewById(R.id.contact_photo);
             contact_id = (TextView) v.findViewById(R.id.contact_id);
             contact_name = (TextView) v.findViewById(R.id.contact_name);
             contact_company = (TextView) v.findViewById(R.id.contact_company);
             contact_dept = (ImageView) v.findViewById(R.id.contact_dept);
             contact_phone = (TextView) v.findViewById(R.id.contact_phone);
             postal = (TextView) v.findViewById(R.id.postal);
             address = (TextView) v.findViewById(R.id.address);
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contactitem, parent, false);
        ContactBookAdapter.ViewHolder vh = new ContactBookAdapter.ViewHolder(v);
        return  vh;
    }

    @Override
    public void onBindViewHolder(ContactBookAdapter.ViewHolder holder, int position) {
         holder.contact_photo.setImageResource(R.drawable.photo);
         holder.contact_id.setText(data.get(position).getContact_id());
         holder.contact_name.setText(data.get(position).getContact_name());
         holder.contact_phone.setText(data.get(position).getContact_mobile());
         holder.contact_company.setText(data.get(position).getContact_company());
         holder.postal.setText(data.get(position).getContact_postal());
         holder.address.setText(data.get(position).getContact_address());
         Bitmap bm =null;
         Resources res =context.getResources();
         switch (Integer.valueOf(data.get(position).getContact_dept()))
        {
            case 0: bm = BitmapFactory.decodeResource(res,R.drawable.dept_customer); break;
            case 1: bm = BitmapFactory.decodeResource(res,R.drawable.dept_factory); break;
            case 2: bm = BitmapFactory.decodeResource(res,R.drawable.dept_employee); break;
        }
        holder.contact_dept.setImageBitmap(bm);
//
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}
