package ngoantran.com.farmapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import ngoantran.com.farmapp.R;
import ngoantran.com.farmapp.adapter.FeedListAdapter;
import ngoantran.com.farmapp.app.AppController;
import ngoantran.com.farmapp.model.FeedItem;
import ngoantran.com.farmapp.util.Const;
import ngoantran.com.farmapp.util.ParseJson;


public class NewsFragment extends Fragment {
    public static final String TAG = NewsFragment.class.getSimpleName();

    private ListView listView;
    private FeedListAdapter feedListAdapter;
    private List<FeedItem> feedItemList;
    private SwipeRefreshLayout refreshLayout;


    public NewsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_news, container, false);
        listView = (ListView) v.findViewById(R.id.list_item);
        refreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);

        feedItemList = new ArrayList<>();
        feedListAdapter = new FeedListAdapter(getActivity(), feedItemList);
        listView.setAdapter(feedListAdapter);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataFeeds();
            }
        });

        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
                getDataFeeds();
            }
        });
        return v;
    }

    private void getDataFeeds() {
        refreshLayout.setRefreshing(true);
        JsonArrayRequest request = new JsonArrayRequest(Const.GET_FEED_LIST, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, "Response: " + response.toString());
                if(response.length() > 0){
                    feedItemList = ParseJson.parseJsonFeed(response);
                    feedListAdapter = new FeedListAdapter(getActivity(), feedItemList);
                    listView.setAdapter(feedListAdapter);
                }
                refreshLayout.setRefreshing(false);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error: " + error.getMessage());
                refreshLayout.setRefreshing(false);
            }
        });

        // Adding request to volley request queue
        AppController.getInstance().addToRequestQueue(request);
    }
}
