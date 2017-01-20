package com.example.sky.contextmenu;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.list);
        String[] list1 = new String[]{"Jelly Bean", "Kitkat", "Lollipop", "Marshmallow"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,list1);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Share");
        menu.add("Edit");
        menu.add("Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
         super.onContextItemSelected(item);
       if(item.getTitle()=="Share"){
           Toast.makeText(this,"Share Done",Toast.LENGTH_SHORT).show();
       }
        if(item.getTitle()=="Edit"){
            Toast.makeText(this,"Edit Done",Toast.LENGTH_SHORT).show();
        }
        if(item.getTitle()=="Delete")
        {
            Toast.makeText(this,"Delete Done",Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(getApplicationContext(),"You Pressed Setting",Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit:
                Toast.makeText(getApplicationContext(),"You Pressed edit",Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(getApplicationContext(),"You Pressed share",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(getApplicationContext(),"You Pressed delete",Toast.LENGTH_SHORT).show();
                break;
             default:
                 Toast.makeText(getApplicationContext(),"You Pressed Wrong",Toast.LENGTH_SHORT).show();
                 break;
        }
        return true;
    }
}
