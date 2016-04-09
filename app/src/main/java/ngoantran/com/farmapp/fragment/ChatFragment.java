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
import ngoantran.com.farmapp.adapter.ChatListAdapter;
import ngoantran.com.farmapp.app.AppController;
import ngoantran.com.farmapp.model.UserChat;
import ngoantran.com.farmapp.util.Const;
import ngoantran.com.farmapp.util.ParseJson;

public class ChatFragment extends Fragment {

    public static final String TAG = ChatFragment.class.getSimpleName();

    private ListView lvUserChat;
    private List<UserChat> userChatList;
    private ChatListAdapter adapter;
    private SwipeRefreshLayout refreshLayout;

    public ChatFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_chat, container, false);

        lvUserChat = (ListView) v.findViewById(R.id.list_user_chat);
        refreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);
        userChatList = new ArrayList<>();
        adapter = new ChatListAdapter(getActivity(), userChatList);
        lvUserChat.setAdapter(adapter);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataContacts();
            }
        });

        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
                getDataContacts();
            }
        });

        return v;
    }

    private void getDataContacts() {
        // showing refresh animation
        refreshLayout.setRefreshing(true);
        // Creating volley request obj
        JsonArrayRequest request = new JsonArrayRequest(Const.GET_USER_CHAT_LIST, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, "get request successful!" + response.toString());
                if (response.length() > 0) {
                    userChatList = ParseJson.parseJsonUserChat(response);
                    Log.d(TAG, "userChatList in cache: " + userChatList.toString());

                    // notifying list adapter about data changes
                    // so that it renders the list view with updated data
                    adapter = new ChatListAdapter(getActivity(), userChatList);
                    lvUserChat.setAdapter(adapter);
                }
                //stop swipe refresh
                refreshLayout.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error: " + error.getMessage());
                //stop swipe refresh
                refreshLayout.setRefreshing(false);
            }
        });
        AppController.getInstance().addToRequestQueue(request);
    }

}
