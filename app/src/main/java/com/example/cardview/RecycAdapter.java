package com.example.cardview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.ViewHolder> {

    Context context;
    ArrayList<ConnectModel> arrConect;

//    private int lastPosttion = -1;

    RecycAdapter(Context context, ArrayList<ConnectModel> arrConect){
        this.context = context;
        this.arrConect = arrConect;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclecard,parent, false);  //WSCUBE RecyclerView ==> 50.10 Minite
        ViewHolder holders = new ViewHolder(view);
        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imgContect.setImageResource(arrConect.get(position).img);
        holder.txtName.setText(arrConect.get(position).name);
        holder.txtNumber.setText(arrConect.get(position).number);

        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.activity_update);

                EditText editName = dialog.findViewById(R.id.updateName);
                EditText editnumber = dialog.findViewById(R.id.updatecontect);
                Button btnAction = dialog.findViewById(R.id.buttonAction);
                TextView txtTitle = dialog.findViewById(R.id.txtTitle);

                txtTitle.setText("Update Contect");
                btnAction.setText("Update");

                editName.setText(arrConect.get(position).name);
                editnumber.setText(arrConect.get(position).number);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    String name = "" , number = "";
                    @Override
                    public void onClick(View v) {
                        if(!editName.getText().toString().equals("")) {
                            name = editName.getText().toString();
                        }
                        else {
                            Toast.makeText(context, "This Enter Name", Toast.LENGTH_SHORT).show();
                        }

                        if(!editnumber.getText().toString().equals("")) {
                            number = editnumber.getText().toString();
                        }
                        else {
                            Toast.makeText(context, "This Enter Number", Toast.LENGTH_SHORT).show();
                        }
                        arrConect.set(position,new ConnectModel(arrConect.get(position).img,name,number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contect")
                        .setMessage("are you sure you want to delete this contect?")
                        .setIcon(R.drawable.delete)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrConect.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();

                return true;
            }
        });
//        setAnimation(holder.itemView, position);
    }
    @Override
    public int getItemCount() {
        return arrConect.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtNumber;
        ImageView imgContect;
        LinearLayout llrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.textView);
            txtNumber = itemView.findViewById(R.id.textView2);
            imgContect = itemView.findViewById(R.id.imageView);
            llrow = itemView.findViewById(R.id.llrow);
        }
    }


//    private void setAnimation(View viewToAnimate, int position){
//        if(position>lastPosttion) {
//            Animation slida = AnimationUtils.loadAnimation(context, android.R.anim.anticipate_overshoot_interpolator);
//            viewToAnimate.startAnimation(slida);
//            lastPosttion = position;
//        }
//    }

}
