package taewon.navercorp.cardstackview.horizontal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import taewon.navercorp.cardstackview.R;
import taewon.navercorp.cardstackview.cardstack.CardStackAdapter;
import taewon.navercorp.cardstackview.cardstack.VerticalCardStackViewPager;

import static taewon.navercorp.cardstackview.R.id.viewPager;


public class PlatformFragment extends Fragment {

    private VerticalCardStackViewPager mViewPager;
    private CardStackAdapter mAdapter;

    public PlatformFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_platform, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        mViewPager = (VerticalCardStackViewPager) view.findViewById(viewPager);
        mAdapter = new CardStackAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setClipToPadding(false);
        mViewPager.setPadding(0, 48, 0, 80);
        mViewPager.setPageMargin(12);
    }
}
