package edu.mctc.lisa.kindling;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    private RecyclerView mEntryRecyclerView;
    public static EntryRecyclerAdapter sAdapter;
    public static EntryLoader sEntryLoader;
    public static EntryManager sEntryManager;

    private static final String TAG = "GERM.gridactivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        sEntryManager = EntryManager.get(this);

        setupUiElements();
        updateUI();

//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Toast.makeText(GridActivity.this, "" + position,
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void showAddEntryDialog() {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        AddTextDialogFrag newFragment = new AddTextDialogFrag();
        newFragment.show(ft, "add entry dialog");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grid, menu);

        return true;
    }

    private void setupUiElements()
    {
        sEntryLoader = new EntryLoader();
        sEntryLoader.loadMoreItems(100);

        EntryRecyclerAdapter era = new EntryRecyclerAdapter(sEntryLoader);
        mEntryRecyclerView = (RecyclerView) findViewById(R.id.recycler_gridview);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        sglm.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        mEntryRecyclerView.setLayoutManager(sglm);
        mEntryRecyclerView.setAdapter(era);

        // --- snip --- we'll come back to the infinite scrolling in a sec...
    }

    public void updateUI() {
        ArrayList<Entry> entries = sEntryManager.getEntries();

        if (sAdapter == null) {
            sAdapter = new EntryRecyclerAdapter(sEntryLoader);
            mEntryRecyclerView.setAdapter(sAdapter);

        } else {
            sAdapter.setEntries(entries);
            // CONSIDER CHANGING JUST ONE. (THANKS, KYLE!!)
//            sAdapter.notifyItemChanged();
            sAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // TODO: Figure out why this doesn't work on API19, and fix

        switch (item.getItemId()) {
            case R.id.add_text_entry:
                showAddEntryDialog();
                return true;

            case R.id.add_image_entry:
                Toast.makeText(GridActivity.this, "image entry",
                        Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}
