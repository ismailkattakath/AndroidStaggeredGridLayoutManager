package inducesmile.com.androidstaggeredgridlayoutmanager;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class RecyclerGridViewSpacing extends RecyclerView.ItemDecoration {

    private int space;
    private int spancount;

    public RecyclerGridViewSpacing(int space, int spancount) {
        this.space = space;
        this.spancount = spancount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first row to avoid double space between items

        for(int i=0; i<spancount; i++) {
            if (parent.getChildLayoutPosition(view) == i)
                outRect.top = space;
        }

        /*if(parent.getChildLayoutPosition(view)%spancount == 0) {
            Log.d("Card position", ""+ parent.getChildLayoutPosition(view));
            outRect.right = 0;
        } else {
            outRect.right = space;
        }*/

    }
}