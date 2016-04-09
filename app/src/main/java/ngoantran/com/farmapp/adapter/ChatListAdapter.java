package ngoantran.com.farmapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ngoantran.com.farmapp.R;
import ngoantran.com.farmapp.model.UserChat;

/**
 * Created by NgoanTT on 4/3/2016.
 */
public class ChatListAdapter extends BaseAdapter {
    // code example
    private List<UserChat> userChatList;
    private Activity activity;
    private LayoutInflater inflater;

    public ChatListAdapter(Activity activity, List<UserChat> userChatList) {
        this.activity = activity;
        this.userChatList = userChatList;
    }


    @Override
    public int getCount() {
        return userChatList == null ? 0 : userChatList.size();
    }

    @Override
    public Object getItem(int position) {
        return userChatList.get(position);
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
            convertView = inflater.inflate(R.layout.fragment_chat_item, null);
        }

        CircleImageView avatar = (CircleImageView) convertView.findViewById(R.id.circleImageUser);
        TextView username = (TextView) convertView.findViewById(R.id.txtUserName);
        TextView txtStatus = (TextView) convertView.findViewById(R.id.txtStatus);
        // user
        UserChat user = userChatList.get(position);
        String url = user.profilePic;
        Picasso.with(activity.getApplicationContext()).load(url).into(avatar);
        username.setText(user.name);
        txtStatus.setText(user.status);
        if (!TextUtils.isEmpty(user.status)) {
            txtStatus.setText(user.status);
            txtStatus.setVisibility(View.VISIBLE);
        } else {
            txtStatus.setVisibility(View.GONE);
        }

        return convertView;
    }
}
