package taewon.navercorp.cardstackview;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;

import taewon.navercorp.cardstackview.horizontal.ParallaxTransformer;
import taewon.navercorp.cardstackview.horizontal.PlatformAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PlatformAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10 * 10, getResources().getDisplayMetrics());

        mViewPager = (ViewPager) findViewById(R.id.viewPager_parent);
        mAdapter = new PlatformAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPageTransformer(true, new ParallaxTransformer());
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setPageMargin(-margin);
    }
}


