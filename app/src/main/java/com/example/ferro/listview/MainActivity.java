package com.example.ferro.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements TextWatcher{
    ArrayAdapter adapter;
    ListView listView;
    EditText text;
    ArrayList<String> listNames = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.text);
        text.addTextChangedListener(this);
        listView = (ListView) findViewById(R.id.lista);
        String[] name = new String[]{"AccM","Bga","asC","nbD"};
        for(int x=0;x<name.length;x++){
            listNames.add(name[x]);
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listNames);
        listView.setAdapter(adapter);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(text.getText().toString()!= null){
            ArrayAdapter adap = new ArrayAdapter(this,android.R.layout.simple_list_item_1,ListFilter.filter(listNames,charSequence.toString()));
            listView.setAdapter(adap);
        }
        else{
            listView.setAdapter(adapter);
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
