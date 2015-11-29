package com.example.tanushree.listviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    CardAdapter mAdapter;
    private ItemTouchHelper mItemTouchHelper;
    Menu mainMenu=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CardAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mainMenu = menu;
        return true;
    }

    //Menu press should open 3 dot menu
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode== KeyEvent.KEYCODE_MENU) {
            mainMenu.performIdentifierAction(R.id.empty, 0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_add:
                // Add item was selected
                LinearLayoutManager layoutManager = ((LinearLayoutManager)mRecyclerView.getLayoutManager());
                int numberOfChild = layoutManager.getChildCount();
                int firstVisiblePosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                firstVisiblePosition = (firstVisiblePosition == -1) ? 0 : firstVisiblePosition;
                firstVisiblePosition = (numberOfChild > 0 && firstVisiblePosition ==0) ? 1 : firstVisiblePosition;
                Toast.makeText(this,"Item added Successfully.",Toast.LENGTH_LONG).show();
                //Toast.makeText(this,"First visible item position is"+firstVisiblePosition,Toast.LENGTH_LONG).show();
                mAdapter.addItemAt(firstVisiblePosition);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
