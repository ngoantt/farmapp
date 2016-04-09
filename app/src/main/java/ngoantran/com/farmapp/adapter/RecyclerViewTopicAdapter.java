package ngoantran.com.farmapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ngoantran.com.farmapp.R;
import ngoantran.com.farmapp.model.Topic;
import ngoantran.com.farmapp.model.TopicViewHolder;

/**
 * Created by NgoanTT on 4/2/2016.
 */
public class RecyclerViewTopicAdapter extends RecyclerView.Adapter<TopicViewHolder> {
    private List<Topic> topicList;
    private Context context;

    public RecyclerViewTopicAdapter(Context context, List<Topic> topicList){
        this.context = context;
        this.topicList = topicList;
    }

    @Override
    public TopicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_topic_item,null);
        TopicViewHolder viewHolder = new TopicViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TopicViewHolder holder, int position) {
        Topic topic = topicList.get(position);
        holder.txtTopic.setText(topic.title);
        holder.imgTopic.setImageResource(topic.image);
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }
}
