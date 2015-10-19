package inducesmile.com.androidstaggeredgridlayoutmanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView countryName;
    public ImageView countryPhoto;

    public ViewHolder(View itemView) {
        super(itemView);
        countryName = (TextView) itemView.findViewById(R.id.country_name);
        countryPhoto = (ImageView) itemView.findViewById(R.id.country_photo);
    }
}
