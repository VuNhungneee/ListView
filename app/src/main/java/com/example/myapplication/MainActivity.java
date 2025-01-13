package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewDS;
    EditText editTextQT;
    Button buttonAdd, buttonEdit, buttonDelete, buttonSearch;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initwidget();
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Vietnamese");
        arr.add("English");
        arr.add("Chinese");
        arr.add("Cambodian");
        ArrayAdapter<String> adt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
        listViewDS.setAdapter(adt);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qt = editTextQT.getText().toString();
                arr.add(qt);
                adt.notifyDataSetChanged();
            }
        });
        listViewDS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int val = position;
                editTextQT.setText(arr.get(position));
                buttonEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        arr.set(position, editTextQT.getText().toString());
                        adt.notifyDataSetChanged();
                    }
                });
                buttonDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        arr.remove(position);
                        adt.notifyDataSetChanged();
                    }
                });
            }
        });
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editTextQT.getText().toString();
                if(arr.contains(s))
                {
                    Toast.makeText(MainActivity.this, "Co tu nhaaa!!", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(MainActivity.this, "Khong co!!", Toast.LENGTH_SHORT).show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initwidget() {
        listViewDS = (ListView) findViewById(R.id.listViewDS);
        editTextQT = (EditText) findViewById(R.id.editTextQT);
        buttonAdd = (Button) findViewById(R.id.buttonOK);
        buttonEdit = (Button) findViewById(R.id.buttonEdit);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
    }
}