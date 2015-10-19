package inducesmile.com.androidstaggeredgridlayoutmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;


public class OrderScreen extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderscreen);
        initRecyclerView();
        initToolbar();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        int spanCount = getResources().getInteger(R.integer.default_grid_column_count);
        int spacing = (int) getResources().getDimension(R.dimen.tiny_margin);
        recyclerView.addItemDecoration(new RecyclerGridViewSpacing(spacing, spanCount));
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(spanCount, 1));
        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(OrderScreen.this, getListItemData());
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

    private List<OrderObject> getListItemData(){
        List<OrderObject> listViewItems = new ArrayList<>();
        listViewItems.add(new OrderObject("Alkane", R.drawable.one));
        listViewItems.add(new OrderObject("Ethane", R.drawable.two));
        listViewItems.add(new OrderObject("Alkyne", R.drawable.three));
        listViewItems.add(new OrderObject("Benzene", R.drawable.four));
        listViewItems.add(new OrderObject("Amide", R.drawable.one));
        listViewItems.add(new OrderObject("Amino Acid", R.drawable.two));
        listViewItems.add(new OrderObject("Phenol", R.drawable.three));
        listViewItems.add(new OrderObject("Carbonxylic", R.drawable.four));
        listViewItems.add(new OrderObject("Nitril", R.drawable.one));
        listViewItems.add(new OrderObject("Ether", R.drawable.two));
        listViewItems.add(new OrderObject("Ester", R.drawable.three));
        listViewItems.add(new OrderObject("Alcohol", R.drawable.four));

        return listViewItems;
    }
}
