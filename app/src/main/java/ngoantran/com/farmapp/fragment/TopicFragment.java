package ngoantran.com.farmapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ngoantran.com.farmapp.R;
import ngoantran.com.farmapp.adapter.RecyclerViewTopicAdapter;
import ngoantran.com.farmapp.data.DummyData;
import ngoantran.com.farmapp.model.Topic;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends Fragment {

    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerViewTopic;

    public TopicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_topic, container, false);

        List<Topic> topicList = DummyData.createDataExplore();
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerViewTopic = (RecyclerView) view.findViewById(R.id.recyclerTopic);
        recyclerViewTopic.setLayoutManager(layoutManager);
        RecyclerViewTopicAdapter adapter = new RecyclerViewTopicAdapter(getActivity(), topicList);
        recyclerViewTopic.setAdapter(adapter);
        return view;

    }

}
