package com.example.retrofitmvvmrecyclerviewrxjava.ui.main;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.retrofitmvvmrecyclerviewrxjava.R;
import com.example.retrofitmvvmrecyclerviewrxjava.pojo.PostModel;
import java.util.ArrayList;
import java.util.List;
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<PostModel> postList = new ArrayList<>();

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item , parent , false));
    }

    @Override
    public void onBindViewHolder( PostsAdapter.PostViewHolder holder, int position) {
        holder.titleTV.setText(postList.get(position).getTitle());
        holder.userTV.setText(postList.get(position).getUserId()+"");
        holder.bodyTV.setText(postList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setlist(List<PostModel> postList){
        this.postList = postList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView titleTV , userTV , bodyTV;
        public PostViewHolder(View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            userTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);
        }
    }
}