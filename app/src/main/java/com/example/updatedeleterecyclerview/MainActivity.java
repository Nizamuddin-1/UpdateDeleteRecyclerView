package com.example.updatedeleterecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Contact_Model> arrayList=new ArrayList<>();
FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_check_box_24,"A","12345"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_off_24,"B","65412"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_done_24,"C","98745"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_check_box_24,"A","12345"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_off_24,"B","65412"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_done_24,"C","98745"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_check_box_24,"A","12345"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_off_24,"B","65412"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_done_24,"C","98745"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_check_box_24,"A","12345"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_off_24,"B","65412"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_done_24,"C","98745"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_check_box_24,"A","12345"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_off_24,"B","65412"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_done_24,"C","98745"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_check_box_24,"A","12345"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_off_24,"B","65412"));
        arrayList.add(new Contact_Model(R.drawable.ic_baseline_cloud_done_24,"C","98745"));
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.update_lay);
                dialog.show();
                Button button=dialog.findViewById(R.id.btn);
                EditText editname=dialog.findViewById(R.id.name);
                EditText editnumber=dialog.findViewById(R.id.number);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="",number="";
                        if(!editname.getText().toString().equals("")){
                            name=editname.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Please Enter the name",Toast.LENGTH_LONG).show();
                        }
                        if (!editnumber.getText().toString().equals(""))
                        {
                            number=editnumber.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Please Enter the number",Toast.LENGTH_LONG).show();
                        }
                        arrayList.add(new Contact_Model(name,number));
                        adapter.notifyItemInserted(arrayList.size()-1);
                        recyclerView.scrollToPosition(arrayList.size()-1);
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}