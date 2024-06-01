package com.example.updatedeleterecyclerview;

import android.app.Dialog;
import android.content.Context;
import android.icu.text.LocaleDisplayNames;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Contact_Model> arrayList;
    public RecyclerViewAdapter(Context context,ArrayList<Contact_Model> arrayList){
        this.arrayList=arrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.content_lay,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         holder.name.setText(arrayList.get(position).name);
         holder.number.setText(arrayList.get(position).number);
         holder.imageView.setImageResource(arrayList.get(position).img);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.update_contact);
                EditText editName=dialog.findViewById(R.id.edit1);
                EditText editNumber=dialog.findViewById(R.id.edit2);
                Button btn=dialog.findViewById(R.id.btn);
                TextView textView=dialog.findViewById(R.id.update);
                textView.setText("Update Contact");
                btn.setText("Update");
                editName.setText(arrayList.get(position).name);
                editNumber.setText(arrayList.get(position).number);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name="",number="";
                        if(!editName.getText().toString().equals("")){
                            name=editName.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(context,"Please Enter the Name!",Toast.LENGTH_LONG).show();
                        }
                        if (!editNumber.getText().toString().equals("")){
                            number=editNumber.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(context,"Please Enter the Number!",Toast.LENGTH_LONG).show();
                        }
                        arrayList.set(position,new Contact_Model(name,number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,number;
        ImageView imageView;
        LinearLayout layout;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           name=itemView.findViewById(R.id.name);
           number=itemView.findViewById(R.id.number);
           imageView=itemView.findViewById(R.id.img);
           layout=itemView.findViewById(R.id.row);

       }
   }

}
