package com.example.reubro_json2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    MyAdapter myAdapter;
    String s1,s2;
    RecyclerView recyclerView;
    String JSON_STRING = "{\"JSON\":{\"status\":\"success\",\"message\":\"Login Success\",\"data\":{\"user_id\":3544354,\"title\":0,\"user_name\":\"Gilson Gilbert\",\"email_id\":\"gilson @gmail.com\",\"dob\":\"15-12-1990\",\"phone\":9845268745,\"country\":\"+91\",\"profile_pic\":\"https://www.google.com/imgres?imgurl=https%3A%2F%2Fimage.shutterstock.com%2Fimage-photo%2Fwhite-transparent-leaf-on-mirror-260nw-577160911.jpg&imgrefurl=https%3A%2F%2Fwww.shutterstock.com%2Fsearch%2Fimage&tbnid=saXt3gObqm30jM&vet=1&docid=QooZsUX3wOLfLM&w=382&h=280&source=sh%2Fx%2Fim\"}}}";
    String jstatus,jmessage,juserid,jtitle,jname, jmail,jdob,jphone,jcontry,jimag;

    String jsonstring[];
    TextView employeeName, employeeSalary;
    ImageView imageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        try {

            JSONObject obj = new JSONObject(JSON_STRING);

            JSONObject jmain = obj.getJSONObject("JSON");
            JSONObject jsub  = jmain.getJSONObject("data");

            jstatus=jmain.getString("status");
            jmessage=jmain.getString("message");
            juserid = jsub.getString("user_id");
            jtitle= jsub.getString("title");
            jname = jsub.getString("user_name");
            jmail= jsub.getString("email_id");
            jdob= jsub.getString("dob");
            jphone= jsub.getString("phone");
            jcontry= jsub.getString("country");
            jimag= jsub.getString("profile_pic");




        } catch (JSONException e) {
            e.printStackTrace();
        }

        recyclerView=findViewById(R.id.recycler);




        MyAdapter myAdapter =new MyAdapter(this,jstatus,jmessage,juserid,jtitle,jname, jmail,jdob,jphone,jcontry,jimag);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}