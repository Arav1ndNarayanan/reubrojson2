package com.example.reubro_json2;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    String      status[],message[],userid[],title,name[], mail[],dob,phone,contry,imag[];

    Context context;

    public MyAdapter(Context ct,String jstatus[],String jmessage[],String juserid[],String jname[],String jmail[],String jimag[]){


        context=ct;
        status=jstatus;
        message=jmessage;
        userid=juserid;
       // title=jtitle;
        name=jname;
        mail=jmail;
       // dob=jdob;
       // phone=jphone;
       // contry=jcontry;
        imag=jimag;

        // images=image;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.mytext1.setText(status[i]);
        holder.mytext2.setText(message[i]);
        holder.mytext3.setText(userid[i]);
        holder.mytext5.setText(name[i]);
        holder.mytext6.setText(mail[i]);

        Glide
                .with(context)
                .load(imag[i])
                .apply(new RequestOptions().override(600, 300))
                .into(holder.myimage);

     //   Glide.with(context).load(imag[i]).into(holder.myimage);


    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mytext1,mytext2,mytext3,mytext4,mytext5,mytext6,mytext7,mytext8,mytext9;
        ImageView myimage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mytext1=itemView.findViewById(R.id.textView);
            mytext2=itemView.findViewById(R.id.textView2);
            mytext3=itemView.findViewById(R.id.textView3);

            mytext5=itemView.findViewById(R.id.textView5);
            mytext6=itemView.findViewById(R.id.textView6);
            myimage=itemView.findViewById(R.id.imageViewx);
        }
    }
}
