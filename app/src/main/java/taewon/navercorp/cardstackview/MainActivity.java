package taewon.navercorp.cardstackview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import taewon.navercorp.cardstackview.horizontal.PlatformAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PlatformAdapter mAdapter;
    private BroadcastReceiver mReceiver;

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewPager_parent);
        mAdapter = new PlatformAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("CHECK_PARENT", event.toString());
                return false;
            }
        });
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("CHECK", " >>>> "+intent.getParcelableExtra("MOTION"));
//                mViewPager.requestDisallowInterceptTouchEvent(false);
                mViewPager.setNestedScrollingEnabled(false);
            }
        };
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter("motion"));
    }
}


