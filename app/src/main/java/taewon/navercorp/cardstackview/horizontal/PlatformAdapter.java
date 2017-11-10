package taewon.navercorp.cardstackview.horizontal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by USER on 2017-11-10.
 */

public class PlatformAdapter extends FragmentPagerAdapter {

    public PlatformAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new PlatformFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }
}
