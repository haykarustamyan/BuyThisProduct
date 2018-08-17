package am.highapps.buythisproduct.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import am.highapps.buythisproduct.R;

public class ProductsFragment extends Fragment {

    private int productsListPage;
    ViewPager viewPager;


    public ProductsFragment() {

    }

    public static ProductsFragment newInstance(int page) {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        View result=inflater.inflate(R.layout.fragment_products, container, false);
//        TextView pageHeader=(TextView)result.findViewById(R.id.tv_productsFragment);
//        String header = String.format("Фрагмент %d", productsListPage+1);
//        pageHeader.setText(header);
//        return result;

        View rootView = inflater.inflate(R.layout.fragment_products, container, false);

        Button refregerBtn = (Button) rootView.findViewById(R.id.ll_refreger);
//        viewPager = (ViewPager) getActivity().findViewById(R.id.tv_productsFragment);

        refregerBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                viewPager.setCurrentItem(0);
            }
        });

        return rootView;
    }

}
