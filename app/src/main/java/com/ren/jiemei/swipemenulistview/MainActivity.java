package com.ren.jiemei.swipemenulistview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeMenuListView list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (SwipeMenuListView) findViewById(R.id.swipelist);

        final List<String> listdata = createListdata();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listdata);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);

                SwipeMenuItem test = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                test.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                test.setWidth(dp2px(90));
                // set item title
                test.setTitle("test");
                // set item title fontsize
                test.setTitleSize(18);
                // set item title font color
//                test.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(test);
            }
        };

// set creator
        list.setMenuCreator(creator);

        list.setAdapter(adapter);
        list.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index){
                    case 0:
                        Log.e("tag", "点击打开----》: "+position );
                        break;
                    case 1:
                        listdata.remove(position);
                        adapter.notifyDataSetChanged();
                        break;
                    case 2:
                        Log.e("tag", "TEST----》: "+position );
                        break;
                }
                return true;
            }
        });


    }

    private List<String> createListdata() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add("东边日出西边雨，道是有晴却无晴"+"---->"+i);
        }
        return list;
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
