package com.example.reubro_json2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    MyAdapter myAdapter;
    String s1,s2;
    RecyclerView recyclerView;
    String strJson = "{\"JSON\":{\"status\":\"success\",\"message\":\"Login Success\",\"data\":[{\"user_id\":\"354sd4\",\"user_name\":\"Gilson Gilbert\",\"email_id\":\"gilson @gmail.com\",\"profile_pic\":\"< image_url >\"},{\"user_id\":\"3544354\",\"user_name\":\"Arjun\",\"email_id\":\"arjun@gmail.com\",\"profile_pic\":\"< image_url >\"},{\"user_id\":\"3544354\",\"user_name\":\"Arun\",\"email_id\":\"arun@gmail.com\",\"profile_pic\":\"< image_url >\"}]}}";
    String jstatus,jmessage,juserid,jtitle,jname, jmail,jdob,jphone,jcontry,jimag;
    String jdata[];

    String jsonstring[];
    TextView employeeName, employeeSalary;
    ImageView imageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String datax = "";
        try {
            // Create the root JSONObject from the JSON string.
            JSONObject  jsonRootObject = new JSONObject(strJson);
            JSONObject jmain = jsonRootObject.getJSONObject("JSON");

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jmain.optJSONArray("data");


           jdata =getResources().getStringArray(R.array.arr);
            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);



                jstatus=jmain.getString("status");
                jmessage=jmain.getString("message");
                juserid = jsonObject.getString("user_id");
                jname = jsonObject.getString("user_name");
                jmail= jsonObject.getString("email_id");


               jdata[i]=jstatus+"\n"+jmessage+"\n"+juserid+"\n"+jname+"\n"+jmail+"\n";


            }

        } catch (JSONException e) {e.printStackTrace();}

   /*     jstatus=jmain.getString("status");
            jmessage=jmain.getString("message");
            juserid = jsub.getString("user_id");
            jtitle= jsub.getString("title");
            jname = jsub.getString("user_name");
            jmail= jsub.getString("email_id");
            jdob= jsub.getString("dob");
            jphone= jsub.getString("phone");
            jcontry= jsub.getString("country");
            jimag= jsub.getString("profile_pic");*/






        recyclerView=findViewById(R.id.recycler);




        MyAdapter myAdapter =new MyAdapter(this,jdata);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}