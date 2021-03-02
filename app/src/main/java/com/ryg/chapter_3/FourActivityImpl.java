package com.ryg.chapter_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ryg.chapter_3.ui.ScrollViewEx3;

import java.util.ArrayList;

/**
 * @author xiaosy
 * @create 3/1/21
 * @Describe
 **/
class FourActivityImpl extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        ScrollViewEx3 scrollView = (ScrollViewEx3) findViewById(R.id.scrollView);
        ListView listView = (ListView)findViewById(R.id.list);
        scrollView.setListView(listView);
        createList();
    }

    private void createList() {
        ListView listView = (ListView)findViewById(R.id.list);
        ArrayList<String> datas = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            datas.add("name " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.content_list_item, R.id.name, datas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(FourActivityImpl.this, "click item",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}
