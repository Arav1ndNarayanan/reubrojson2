package com.example.reubro_json2;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    String      status[],message,userid,title,name, mail,dob,phone,contry,imag;

    Context context;

    public MyAdapter(Context ct,String jstatus[]){//,String jmessage,String juserid,String jtitle,String jname,String  jmail,String jdob,String jphone,String jcontry,String jimg){


        context=ct;
        status=jstatus;
      /*  message=jmessage;
        userid=juserid;
        title=jtitle;
        name=jname;
        mail=jmail;
        dob=jdob;
        phone=jphone;
        contry=jcontry;
        imag=jimg;

        // images=image;
*/
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
        holder.mytext2.setText(message);
        holder.mytext3.setText(userid);
        holder.mytext4.setText(title);
        holder.mytext5.setText(name);
        holder.mytext6.setText(mail);
        holder.mytext7.setText(dob);
        holder.mytext8.setText(phone);
        holder.mytext9.setText(contry);



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
            mytext4=itemView.findViewById(R.id.textView4);
            mytext5=itemView.findViewById(R.id.textView5);
            mytext6=itemView.findViewById(R.id.textView6);
            mytext7=itemView.findViewById(R.id.textView7);
            mytext8=itemView.findViewById(R.id.textView8);
            mytext9=itemView.findViewById(R.id.textView9);
            myimage=itemView.findViewById(R.id.imageViewx);
        }
    }
}
