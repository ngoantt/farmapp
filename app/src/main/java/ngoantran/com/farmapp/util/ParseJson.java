package ngoantran.com.farmapp.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ngoantran.com.farmapp.model.FeedItem;
import ngoantran.com.farmapp.model.UserChat;

/**
 * Created by NgoanTT on 4/2/2016.
 */
public class ParseJson {
    public static final String TAG = ParseJson.class.getSimpleName();

    public static List<FeedItem> parseJsonFeed(JSONArray feedJson) {
        List<FeedItem> feedItemList = new ArrayList<>();
        try {
            for (int i = 0; i < feedJson.length(); i++) {
                JSONObject objFeed = (JSONObject) feedJson.get(i);
                FeedItem feed = new FeedItem();
                feed.id = objFeed.getInt(Key.KEY_ID);
                feed.name = objFeed.getString(Key.KEY_NAME);
                // image can null sometime
                String image = objFeed.isNull(Key.KEY_IMAGE) ? null : objFeed.getString(Key.KEY_IMAGE);
                feed.image = image;
                feed.status = objFeed.getString(Key.KEY_STATUS);
                feed.profilePic = objFeed.getString(Key.KEY_PROFILE_PIC);
                feed.timestamp = objFeed.getString(Key.KEY_TIMESTAMP);
                //url might be null sometimes
                String url = objFeed.isNull(Key.KEY_URL) ? null : objFeed.getString(Key.KEY_URL);
                feed.url = url;
                feedItemList.add(feed);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return feedItemList;
    }

    public static List<UserChat> parseJsonUserChat(JSONArray userChatArr) {
        Log.d(TAG," into parseJsonUserChat:");
        List<UserChat> userChatList = new ArrayList<>();
        try {
            for (int i = 0; i < userChatArr.length(); i++) {
                JSONObject userObj = (JSONObject) userChatArr.get(i);
                UserChat userChat = new UserChat();
                userChat.id = userObj.getInt(Key.KEY_ID);
                userChat.profilePic = userObj.getString(Key.KEY_PROFILE_PIC);
                userChat.name = userObj.getString(Key.KEY_NAME);
                String status = userObj.isNull(Key.KEY_STATUS) ? null : userObj.getString(Key.KEY_STATUS);
                userChat.status = status;
                userChatList.add(userChat);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userChatList;
    }
}
