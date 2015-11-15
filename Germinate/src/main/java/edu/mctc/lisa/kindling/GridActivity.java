package edu.mctc.lisa.kindling;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class GridActivity extends AppCompatActivity {

    private static final String TAG = "GERM.gridactivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(GridActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showAddEntryDialog() {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        AddEntryDialogFragment newFragment = AddEntryDialogFragment.newInstance();
        newFragment.show(ft, "add entry dialog");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grid, menu);
//        Button addTextEntry = (Button) findViewById(R.id.add_text_entry);
//        menu.add(R.string.add_text_entry_action_name);
//        menu.add(R.string.add_image_entry_action_name);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.add_text_entry:
                Toast.makeText(GridActivity.this, "text entry",
                        Toast.LENGTH_SHORT).show();
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

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(185, 185));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.sample_01, R.drawable.sample_02,
                R.drawable.sample_03, R.drawable.sample_04,
                R.drawable.sample_05, R.drawable.sample_06,
                R.drawable.sample_07, R.drawable.sample_02,
                R.drawable.sample_03, R.drawable.sample_04,
                R.drawable.sample_05, R.drawable.sample_06,
                R.drawable.sample_01, R.drawable.sample_07,
                R.drawable.sample_03, R.drawable.sample_04,
                R.drawable.sample_05, R.drawable.sample_06,
                R.drawable.sample_01, R.drawable.sample_02,
                R.drawable.sample_07, R.drawable.sample_04,
                R.drawable.sample_05, R.drawable.sample_06,
                R.drawable.sample_01, R.drawable.sample_02,
                R.drawable.sample_03, R.drawable.sample_07,
                R.drawable.sample_05, R.drawable.sample_06
        };
    }
}
