package arzun.project.com.livenepal;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

/**
 * Created by arzun on 5/4/17.
 */
public class HomeFragment extends Fragment {
    TextView mvideoTitle,mvideoAuthor,tvideoTitle,tvideoAuthor;
    ImageView mvideoImage,tvideoImage;
    PagerSlidingTabStrip pagerTabs;
    ViewPager pager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.home_layout,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        /*
        * Main Video Display
        * */
        mvideoImage= (ImageView) view.findViewById(R.id.mainVideoImage);
        mvideoTitle= (TextView) view.findViewById(R.id.mainVideoTitle);
        mvideoAuthor= (TextView) view.findViewById(R.id.mainVideoAuthor);

        mvideoImage.setImageResource(R.drawable.images1);
        mvideoTitle.setText("Hamro Nepal");
        mvideoAuthor.setText("Suman Jung");

        /*
        * Scroll ma hunne video haru
        * */
        LinearLayout videoTab=(LinearLayout)view.findViewById(R.id.videoThumbnail);
        TypedArray images=getResources().obtainTypedArray(R.array.images_ids);

        for (int i=0;i<4;i++){
            View.inflate(getContext(),R.layout.video_thumbnail,videoTab);
            int resID=images.getResourceId(i,-1);
            tvideoImage= (ImageView) view.findViewById(R.id.thumbnailVideoImage);
            tvideoTitle= (TextView) view.findViewById(R.id.thumbnailVideoTitle);
            tvideoAuthor= (TextView) view.findViewById(R.id.thumbnailVideoAuthor);

            tvideoImage.setImageResource(resID);

        }
        images.recycle();

        /*
        * Channel ko lists
        * */
        LinearLayout channelTab=(LinearLayout)view.findViewById(R.id.channelThumbnail);
        for (int i=0;i<4;i++){
            View.inflate(getContext(),R.layout.channel_thumbnail,channelTab);
        }

        pagerTabs=(PagerSlidingTabStrip)view.findViewById(R.id.pager_tabs);
        pager=(ViewPager)view.findViewById(R.id.view_pager);

        FragmentManager fragmentManager=getChildFragmentManager();
        pager.setAdapter(new MyAdapter(getActivity(),fragmentManager));
        pagerTabs.setViewPager(pager);
    }

    private class MyAdapter extends FragmentStatePagerAdapter{
        Context c;
        public MyAdapter(FragmentActivity activity, FragmentManager fragmentManager) {
            super(fragmentManager);
            c=activity;

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return new TrendingVideos();
                case 1:
                    return new MostViewedVideos();
                case 2:
                    return new YouMayLikeVideos();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Trending Videos";
                case 1:
                    return "Most Viewed";
                case 2:
                    return "You may Like";
            }
            return super.getPageTitle(position);
        }
    }
}
