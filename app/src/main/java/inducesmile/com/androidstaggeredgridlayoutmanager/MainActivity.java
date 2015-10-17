package inducesmile.com.androidstaggeredgridlayoutmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        initToolbar();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        SolventRecyclerViewAdapter rcAdapter = new SolventRecyclerViewAdapter(MainActivity.this, getListItemData());
        recyclerView.setAdapter(rcAdapter);

        recyclerView.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideViews();
            }

            @Override
            public void onShow() {
                showViews();
            }
        });

    }

    private void hideViews() {
        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews() {
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setTitle(getString(R.string.app_name));
        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }

    private List<ItemObjects> getListItemData(){
        List<ItemObjects> listViewItems = new ArrayList<>();
        listViewItems.add(new ItemObjects("Alkane", R.drawable.one));
        listViewItems.add(new ItemObjects("Ethane", R.drawable.two));
        listViewItems.add(new ItemObjects("Alkyne", R.drawable.three));
        listViewItems.add(new ItemObjects("Benzene", R.drawable.four));
        listViewItems.add(new ItemObjects("Amide", R.drawable.one));
        listViewItems.add(new ItemObjects("Amino Acid", R.drawable.two));
        listViewItems.add(new ItemObjects("Phenol", R.drawable.three));
        listViewItems.add(new ItemObjects("Carbonxylic", R.drawable.four));
        listViewItems.add(new ItemObjects("Nitril", R.drawable.one));
        listViewItems.add(new ItemObjects("Ether", R.drawable.two));
        listViewItems.add(new ItemObjects("Ester", R.drawable.three));
        listViewItems.add(new ItemObjects("Alcohol", R.drawable.four));

        return listViewItems;
    }
}
