package me.tyrion.treenote;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.tyrion.treenote.model.Comment;

/**
 * Created by taomaogan on 2016/7/22.
 */
public class TreeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements TreeOperationListener {
    private static final int NORMAL_LAYOUT = 1;
    private static final int NULL_LAYOUT = 2;

    private LayoutInflater mInflater;
    private List<Comment> mComments;
    private Context mContext;

    public TreeAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mComments = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case NORMAL_LAYOUT:
                view = mInflater.inflate(R.layout.comment_item, parent, false);
                viewHolder = new CommentVH(view);
                break;

            case NULL_LAYOUT:
                view = mInflater.inflate(R.layout.comment_null_item, parent, false);
                viewHolder = new NullVH(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CommentVH) {
            CommentVH commentVH = (CommentVH) holder;
            commentVH.update(mComments.get(position), mContext);
            commentVH.addAddListener(this, position);
            commentVH.addZoomListener(this, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Comment comment = mComments.get(position);
        if (comment.isVisible()) {
            return NORMAL_LAYOUT;
        } else {
            return NULL_LAYOUT;
        }
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    public void addItems(List<Comment> comments) {
        convertComment(comments);
        notifyDataSetChanged();
    }

    private void convertComment(List<Comment> comments) {
        mComments = new ArrayList<>();
        convertComment(comments, 1);
    }

    private void convertComment(List<Comment> comments, int level) {
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            comment.setLevel(level);
            comment.setVisible(true);
            mComments.add(comment);

            if (comment.getChildren() != null && comment.getChildren().size() > 0) {
                convertComment(comment.getChildren(), level + 1);
            }
        }
    }

    @Override
    public void zoom(int pos) {
        //TODO 收起放大
    }

    @Override
    public void add(int pos) {
        //TODO 增加评论
    }
    
}
