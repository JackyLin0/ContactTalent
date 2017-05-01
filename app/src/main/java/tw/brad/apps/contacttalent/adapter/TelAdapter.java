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
import tw.brad.apps.contacttalent.model.TelRecord;

/**
 * Created by hungming on 2017/4/12.
 */

public class TelAdapter extends RecyclerView.Adapter<TelAdapter.ViewHolder> {
    private  List<TelRecord> data;
    private LayoutInflater inflater;
    private Context context;

    public TelAdapter(Context context, List<TelRecord> data)
    {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,phone,company,dTime;
        ImageView photo,dept;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            company = (TextView) v.findViewById(R.id.company);
            dept = (ImageView) v.findViewById(R.id.dept);
            dTime = (TextView) v.findViewById(R.id.dTime);
            phone = (TextView) v.findViewById(R.id.phone);
            photo = (ImageView) v.findViewById(R.id.photo);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.telrecorditem, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         holder.photo.setImageResource(R.drawable.photo);
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
     }

    @Override
    public int getItemCount() {
        return data.size();
    }





}
