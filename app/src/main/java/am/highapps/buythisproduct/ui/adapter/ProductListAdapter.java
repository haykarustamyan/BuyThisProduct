package am.highapps.buythisproduct.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import am.highapps.buythisproduct.ui.fragment.ProductsFragment;

public class ProductListAdapter extends FragmentPagerAdapter {

    public ProductListAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return(ProductsFragment.newInstance(position));
    }

    @Override
    public int getCount() {
        return(5);
    }
}
