package me.tyrion.treenote;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.tyrion.treenote.model.Comment;

/**
 * Created by taomaogan on 2016/7/22.
 */
public class CommentVH extends RecyclerView.ViewHolder {
    private ImageView mCommentAnimteIv;
    private LinearLayout mCommentLl;
    private TextView mCommentDescTv;

    public CommentVH(View itemView) {
        super(itemView);
        mCommentAnimteIv = (ImageView) itemView.findViewById(R.id.comment_animate_iv);
        mCommentDescTv = (TextView) itemView.findViewById(R.id.comment_desc_tv);
    }

    public void update(Comment comment,
                       Context context) {
        mCommentDescTv.setText(comment.getContent());

        mCommentLl = (LinearLayout) itemView;
        if (mCommentLl.getChildCount() > 2) {
            mCommentLl.removeViews(0, mCommentLl.getChildCount() - 2);
        }
        if (comment.getLevel() > 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            LayoutInflater inflater = LayoutInflater.from(context);
            for (int j = 1; j < comment.getLevel(); j++) {
                View lineView = inflater.inflate(R.layout.line_view, null);
                mCommentLl.addView(lineView, 0, layoutParams);
            }
        }
    }

    public void addZoomListener(final TreeOperationListener treeOperationListener, final int pos) {
        if (mCommentAnimteIv != null) {
            mCommentAnimteIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    treeOperationListener.zoom(pos);
                }
            });
        }
    }

    public void addAddListener(final TreeOperationListener treeOperationListener, final int pos) {
        if (mCommentLl != null) {
            mCommentLl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    treeOperationListener.add(pos);
                }
            });
        }
    }
}
