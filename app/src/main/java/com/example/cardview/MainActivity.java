package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
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

    FloatingActionButton btnOpenDialog;
    ArrayList<ConnectModel> arrConect = new ArrayList<>();
    RecycAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);  //not Dark Mode // Dark Mode Off

        btnOpenDialog = findViewById(R.id.floatingActionButton);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.activity_update);

                EditText editName = dialog.findViewById(R.id.updateName);
                EditText editnumber = dialog.findViewById(R.id.updatecontect);
                Button btnAction = dialog.findViewById(R.id.buttonAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    String name = "" , number = "";
                    @Override
                    public void onClick(View v) {
                        if(!editName.getText().toString().equals("")) {
                            name = editName.getText().toString();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "This Enter Name", Toast.LENGTH_SHORT).show();
                        }

                        if(!editnumber.getText().toString().equals("")) {
                            number = editnumber.getText().toString();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "This Enter Number", Toast.LENGTH_SHORT).show();
                        }

                        arrConect.add(new ConnectModel(R.drawable.a, name, number));

                        adapter.notifyItemInserted(arrConect.size()-1);
                        recyclerView.scrollToPosition(arrConect.size()-1);

                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });
        ConnectModel model = new ConnectModel(R.drawable.b,"Avi","1234567891");
        arrConect.add(model);

        arrConect.add(new ConnectModel(R.drawable.c,"hp","1234567891"));
        arrConect.add(new ConnectModel(R.drawable.a,"hello","12657891"));
        arrConect.add(new ConnectModel(R.drawable.a,"dvdvf","129914641691"));
        arrConect.add(new ConnectModel(R.drawable.b,"raj","9921567891"));
        arrConect.add(new ConnectModel(R.drawable.a,"Dishant","9826514156"));
        arrConect.add(new ConnectModel(R.drawable.b,"smita","1234465147891"));
        arrConect.add(new ConnectModel(R.drawable.c,"jenish","87164657891"));
        arrConect.add(new ConnectModel(R.drawable.b,"sd","87614788491"));
        arrConect.add(new ConnectModel(R.drawable.a,"dvdvf","129914641691"));
        arrConect.add(new ConnectModel(R.drawable.b,"raj","9921567891"));
        arrConect.add(new ConnectModel(R.drawable.a,"Dishant","9826514156"));
        arrConect.add(new ConnectModel(R.drawable.b,"smita","1234465147891"));
        arrConect.add(new ConnectModel(R.drawable.c,"jenish","87164657891"));
        arrConect.add(new ConnectModel(R.drawable.b,"sd","87614788491"));
        arrConect.add(new ConnectModel(R.drawable.a,"dvdvf","129914641691"));
        arrConect.add(new ConnectModel(R.drawable.c,"dfrefkfdc","123646561487"));
        arrConect.add(new ConnectModel(R.drawable.c,"hp","1234567891"));
        arrConect.add(new ConnectModel(R.drawable.a,"hello","12657891"));
        arrConect.add(new ConnectModel(R.drawable.a,"dvdvf","129914641691"));
        arrConect.add(new ConnectModel(R.drawable.b,"raj","9921567891"));
        arrConect.add(new ConnectModel(R.drawable.a,"Dishant","9826514156"));
        arrConect.add(new ConnectModel(R.drawable.b,"smita","1234465147891"));
        arrConect.add(new ConnectModel(R.drawable.c,"jenish","87164657891"));
        arrConect.add(new ConnectModel(R.drawable.b,"sd","87614788491"));
        arrConect.add(new ConnectModel(R.drawable.a,"dvdvf","129914641691"));
        arrConect.add(new ConnectModel(R.drawable.b,"raj","9921567891"));
        arrConect.add(new ConnectModel(R.drawable.a,"Dishant","9826514156"));
        arrConect.add(new ConnectModel(R.drawable.b,"smita","1234465147891"));
        arrConect.add(new ConnectModel(R.drawable.c,"jenish","87164657891"));
        arrConect.add(new ConnectModel(R.drawable.b,"sd","87614788491"));
        arrConect.add(new ConnectModel(R.drawable.a,"dvdvf","129914641691"));
        arrConect.add(new ConnectModel(R.drawable.c,"dfrefkfdc","123646561487"));
        arrConect.add(new ConnectModel(R.drawable.c,"hp","1234567891"));
        arrConect.add(new ConnectModel(R.drawable.a,"hello","12657891"));
        arrConect.add(new ConnectModel(R.drawable.a,"dvdvf","129914641691"));
        arrConect.add(new ConnectModel(R.drawable.b,"raj","9921567891"));
        arrConect.add(new ConnectModel(R.drawable.a,"Dishant","9826514156"));
        arrConect.add(new ConnectModel(R.drawable.b,"smita","1234465147891"));
        arrConect.add(new ConnectModel(R.drawable.c,"jenish","87164657891"));
        arrConect.add(new ConnectModel(R.drawable.b,"sd","87614788491"));
        arrConect.add(new ConnectModel(R.drawable.a,"dvdvf","129914641691"));
        arrConect.add(new ConnectModel(R.drawable.b,"raj","9921567891"));
        arrConect.add(new ConnectModel(R.drawable.a,"Dishant","9826514156"));
        arrConect.add(new ConnectModel(R.drawable.b,"smita","1234465147891"));
        arrConect.add(new ConnectModel(R.drawable.c,"jenish","87164657891"));
        arrConect.add(new ConnectModel(R.drawable.b,"sd","87614788491"));
        arrConect.add(new ConnectModel(R.drawable.a,"dvdvf","129914641691"));
        arrConect.add(new ConnectModel(R.drawable.c,"dfrefkfdc","123646561487"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecycAdapter(MainActivity.this,arrConect);
        recyclerView.setAdapter(adapter);
    }
}