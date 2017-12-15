package prvaaplikacija.recycleviewer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Mende on 15.12.2017.
 */

public class MyPageAdapter extends FragmentPagerAdapter {
    ArrayList<ImageData> images = new ArrayList<ImageData>();


    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addImage(ImageData image) {
        images.add(image);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();

        args.putString("SLIKA_URL",images.get(position).getPreviewURL());
        FragmentImage f = new FragmentImage();
        f.setArguments(args);
        return f;
    }

    @Override
    public int getCount() {
        return images.size();
    }
}
