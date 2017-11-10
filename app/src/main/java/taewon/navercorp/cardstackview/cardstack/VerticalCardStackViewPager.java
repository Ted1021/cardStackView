package taewon.navercorp.cardstackview.cardstack;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by USER on 2017-11-10.
 */

public class VerticalCardStackViewPager extends ViewPager {

    private float mPastX, mPastY;
    private boolean isComplete = false;
    private boolean isHorizontal = false;

    public VerticalCardStackViewPager(Context context) {
        super(context);
        init();
    }

    public VerticalCardStackViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        setPageTransformer(true, new CardStackTransformer());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class CardStackTransformer implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View page, float position) {

            if (position < -1) {
                page.setAlpha(0);

            } else {
                page.setAlpha(1);
                page.setTranslationX(page.getWidth() * -position);
                float yPosition = position * page.getHeight();
                page.setTranslationY(yPosition);
            }

            if (position >= 0) {
                page.setScaleX(0.8f - 0.04f * position);
                page.setScaleY(0.8f);
                page.setTranslationX(-page.getWidth() * position);
                page.setTranslationY(50 * position);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

//        Intent intent;
//        switch(ev.getAction()){
//
//            case MotionEvent.ACTION_DOWN:
//
//                mPastX = ev.getX();
//                mPastY = ev.getY();
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//
//                if(!isComplete){
//
//                    float dx = ev.getX() - mPastX;
//                    float dy = ev.getY() - mPastY;
//
//                    if(dx==0){
//                        break;
//                    }
//                    float a = dy / dx;
//                    Log.d("check_a", a+"");
//                    if(-1 <= a && a <= 1){
//                        // 수평
//                        isHorizontal = true;
//                    }
//                    isComplete = true;
//                    break;
//                }
//
//                Log.d("CHECK", isHorizontal+"");
//                if(isHorizontal){
//                    intent = new Intent("motion");
//                    intent.putExtra("MOTION", ev);
//                    LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
//                }
////                this.getParent().getParent().requestDisallowInterceptTouchEvent(false);
////                this.requestDisallowInterceptTouchEvent(true);
//                break;
//
//            case MotionEvent.ACTION_UP:
//                isHorizontal = false;
//                isComplete = false;
//                break;
//        }
        return super.onTouchEvent(swapXY(ev));
    }

    private MotionEvent swapXY(MotionEvent ev) {

        float width = getWidth();
        float height = getHeight();
        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;
        ev.setLocation(newX, newY);
        return ev;
    }
}