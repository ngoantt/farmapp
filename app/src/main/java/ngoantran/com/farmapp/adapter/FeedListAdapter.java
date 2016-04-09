package ngoantran.com.farmapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import ngoantran.com.farmapp.R;
import ngoantran.com.farmapp.app.AppController;
import ngoantran.com.farmapp.model.FeedItem;
import ngoantran.com.farmapp.util.FeedImageView;

/**
 * Created by NgoanTT on 4/2/2016.
 */
public class FeedListAdapter extends BaseAdapter {

    private Activity activity;
    private List<FeedItem> feedItemList;
    private LayoutInflater inflater;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public FeedListAdapter(Activity activity, List<FeedItem> feedItemList) {
        this.activity = activity;
        this.feedItemList = feedItemList;
    }


    @Override
    public int getCount() {
        return feedItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return feedItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_news_item, null);
        }

        if (imageLoader == null) {
            imageLoader = AppController.getInstance().getImageLoader();
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView timestamp = (TextView) convertView.findViewById(R.id.timestamp);
        TextView statusMsg = (TextView) convertView.findViewById(R.id.txtStatusMsg);
        TextView url = (TextView) convertView.findViewById(R.id.txtUrl);
        NetworkImageView profilePic = (NetworkImageView) convertView.findViewById(R.id.profilePic);
        FeedImageView feedImageView = (FeedImageView) convertView.findViewById(R.id.feedImage);

        FeedItem feedItem = feedItemList.get(position);

        name.setText(feedItem.name);
        //convert timestamp to x ago format
        CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(Long.parseLong(feedItem.timestamp), System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
        timestamp.setText(timeAgo);
        //check for empty status
        if (!TextUtils.isEmpty(feedItem.status)) {
            statusMsg.setText(feedItem.status);
            statusMsg.setVisibility(View.VISIBLE);
        } else {
            // status is empty, remove from view
            statusMsg.setVisibility(View.GONE);
        }
        // check null for url
        if (!TextUtils.isEmpty(feedItem.url)) {
            url.setText(Html.fromHtml("<a hef=\"" + feedItem.url + "\">" + feedItem.url + "</a>"));
            // making url clickable
            url.setMovementMethod(LinkMovementMethod.getInstance());
            url.setVisibility(View.VISIBLE);
        } else {
            url.setVisibility(View.GONE);
        }

        //user profile pic
        profilePic.setImageUrl(feedItem.profilePic, imageLoader);
        //feed image
        if (feedItem.image != null) {
            feedImageView.setImageUrl(feedItem.image, imageLoader);
            feedImageView.setVisibility(View.VISIBLE);
            feedImageView.setResponseObserver(new FeedImageView.ResponseObserver() {
                @Override
                public void onError() {

                }

                @Override
                public void onSuccess() {

                }
            });
        } else {
            feedImageView.setVisibility(View.GONE);
        }

        return convertView;
    }
}
