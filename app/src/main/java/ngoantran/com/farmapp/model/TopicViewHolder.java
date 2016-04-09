package ngoantran.com.farmapp.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ngoantran.com.farmapp.R;

/**
 * Created by NgoanTT on 4/2/2016.
 */
public class TopicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtTopic;
    public ImageView imgTopic;

    public TopicViewHolder(View itemView) {
        super(itemView);
        // implement onclick
        itemView.setOnClickListener(this);
        txtTopic = (TextView) itemView.findViewById(R.id.txtNameTopic);
        imgTopic = (ImageView) itemView.findViewById(R.id.imgTopicItem);
    }

    @Override
    public void onClick(View view) {
        //Every time you click on the row toast is displayed
        Toast.makeText(view.getContext(), "This is " + txtTopic.getText(), Toast.LENGTH_LONG).show();
    }
}
