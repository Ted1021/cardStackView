package taewon.navercorp.cardstackview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;

import taewon.navercorp.cardstackview.horizontal.ParallaxViewPager;
import taewon.navercorp.cardstackview.horizontal.PlatformAdapter;

public class MainActivity extends AppCompatActivity {

    private ParallaxViewPager mViewPager;
    private PlatformAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10 * 10, getResources().getDisplayMetrics());

        mViewPager = (ParallaxViewPager) findViewById(R.id.viewPager_parent);
        mAdapter = new PlatformAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setPageMargin(-margin);
    }
}


