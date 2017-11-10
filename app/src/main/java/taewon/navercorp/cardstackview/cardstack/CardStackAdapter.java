package taewon.navercorp.cardstackview.cardstack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by USER on 2017-11-03.
 */

public class CardStackAdapter extends FragmentPagerAdapter {

    public CardStackAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new CardStackFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }
}
