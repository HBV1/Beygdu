package is.arnastofnun.BeygduTutorial;

import android.support.v7.app.ActionBar;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import is.arnastofnun.beygdu.R;

public class TutorialActivity extends ActionBarActivity {

    private static final int NUM_PAGES = 8;

    private ViewPager vPager;

    private PagerAdapter pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_tutorial);


        vPager = (ViewPager) findViewById(R.id.pager);
        pAdapter = new ScreenSliderPagerAdapter(getSupportFragmentManager());
        vPager.setAdapter(pAdapter);
        vPager.setPageTransformer(true, new AnimationTransformer());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View actionBarView = layoutInflater.inflate(R.layout.actionbar_tutorial, null);

        ImageView forwardImage = (ImageView) actionBarView.findViewById(R.id.forwardImage);
        forwardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vPager.getCurrentItem() < NUM_PAGES) vPager.setCurrentItem(vPager.getCurrentItem() + 1);
            }
        });

        ImageView backwardImage = (ImageView) actionBarView.findViewById(R.id.backwardImage);
        backwardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vPager.getCurrentItem() > 0) vPager.setCurrentItem(vPager.getCurrentItem() - 1);
            }
        });

        TextView quitView = (TextView) actionBarView.findViewById(R.id.quitTextView);
        quitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        actionBar.setCustomView(actionBarView);
        actionBar.setDisplayShowCustomEnabled(true);




    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tutorial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.quitButton:
                finish();
            case R.id.backButton:
                if(vPager.getCurrentItem() != 0)  {
                    vPager.setCurrentItem(vPager.getCurrentItem() - 1);
                    return true;
                }
                return super.onOptionsItemSelected(item);
            case R.id.forwardButton:
                if(vPager.getCurrentItem() < NUM_PAGES) {
                    vPager.setCurrentItem(vPager.getCurrentItem() + 1);
                    return true;
                }
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
*/
    private class ScreenSliderPagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSliderPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {
                case 0:
                    return ScreenSlidePageFragment.newInstance(R.layout.fragment_slide_portrait,
                            R.layout.fragment_slide_landscape_one,
                            R.drawable.tut_placement,
                            R.string.TF01,
                            R.string.TF02);
                case 1:
                    return ScreenSlidePageFragment.newInstance(R.layout.fragment_slide_portrait,
                            R.layout.fragment_slide_landscape_two,
                            R.drawable.tut_placement,
                            R.string.TF01,
                            R.string.TF02);
                case 2:
                    return ScreenSlidePageFragment.newInstance(R.layout.fragment_slide_portrait,
                            R.layout.fragment_slide_landscape_three,
                            R.drawable.tut_placement,
                            R.string.TF01,
                            R.string.TF02);
                case 3:
                    return ScreenSlidePageFragment.newInstance(R.layout.fragment_slide_portrait,
                            R.layout.fragment_slide_landscape_one,
                            R.drawable.tut_placement,
                            R.string.TF01,
                            R.string.TF02);
                case 4:
                    return ScreenSlidePageFragment.newInstance(R.layout.fragment_slide_portrait,
                            R.layout.fragment_slide_landscape_two,
                            R.drawable.tut_placement,
                            R.string.TF01,
                            R.string.TF02);
                case 5:
                    return ScreenSlidePageFragment.newInstance(R.layout.fragment_slide_portrait,
                            R.layout.fragment_slide_landscape_three,
                            R.drawable.tut_placement,
                            R.string.TF01,
                            R.string.TF02);
                case 6:
                    return ScreenSlidePageFragment.newInstance(R.layout.fragment_slide_portrait,
                            R.layout.fragment_slide_landscape_one,
                            R.drawable.tut_placement,
                            R.string.TF01,
                            R.string.TF02);
                case 7:
                    return ScreenSlidePageFragment.newInstance(R.layout.fragment_slide_portrait,
                            R.layout.fragment_slide_landscape_two,
                            R.drawable.tut_placement,
                            R.string.TF01,
                            R.string.TF02);
                default:
                    return ScreenSlidePageFragment.newInstance(R.layout.fragment_slide_portrait,
                            R.layout.fragment_slide_landscape_one,
                            R.drawable.tut_placement,
                            R.string.TF01,
                            R.string.TF02);
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
