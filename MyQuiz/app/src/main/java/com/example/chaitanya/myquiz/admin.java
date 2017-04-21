package com.example.chaitanya.myquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class admin extends Activity {
    static int itemPosition;
    ListView lv;
    List<Question> quesList2;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
       setlist();
    }
    private void setlist(){
        lv=(ListView) findViewById(R.id.listView);
        QuizHelper db = new QuizHelper(this);  // my question bank class
        quesList2 = db.getAllQuestions2();
        int a= quesList2.size();
        String[] testArray = new String[a];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i]=quesList2.get(i).getQUESTION();
        }
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,testArray);

        // Assign adapter to ListView
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub
                itemPosition     = position;
            }
        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, v.getId(), 0, "Delete");//groupId, itemId, order, title
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        QuizHelper db = new QuizHelper(this);
        if(item.getTitle()=="Delete"){
         db.deleteDB();
            setlist();
            Toast.makeText(this, "Successfully deleted" +quesList2.size(), Toast.LENGTH_LONG).show();
            adapter.notifyDataSetChanged();

        }
        else{
            return false;
        }
        return true;
    }

}

