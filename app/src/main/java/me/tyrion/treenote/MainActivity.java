package me.tyrion.treenote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.tyrion.treenote.model.Comment;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mTestRv;
    private TreeAdapter mTreeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestRv = (RecyclerView) findViewById(R.id.test_rv);
        mTreeAdapter = new TreeAdapter(this);
        mTestRv.setLayoutManager(new LinearLayoutManager(this));
        mTestRv.setAdapter(mTreeAdapter);
        mTreeAdapter.addItems(initComment());
    }

    private List<Comment> initComment() {
        List<Comment> comments1 = new ArrayList<>();

        List<Comment> comments2 = new ArrayList<>();
        Comment comment = new Comment();
        comment.setChildren(new ArrayList<Comment>());
        comment.setContent("可爱又迷人的反派角色");
        comments2.add(comment);

        List<Comment> comments3 = new ArrayList<>();
        Comment comment1 = new Comment();
        comment1.setChildren(comments2);
        comment1.setContent("贯彻爱与真实的邪恶");
        comments3.add(comment1);

        List<Comment> comments4 = new ArrayList<>();
        Comment comment2 = new Comment();
        comment2.setChildren(comments3);
        comment2.setContent("为了保护世界的和平");
        comments4.add(comment2);

        List<Comment> comments5 = new ArrayList<>();
        Comment comment3 = new Comment();
        comment3.setChildren(comments4);
        comment3.setContent("为了防止世界被破坏");
        comments5.add(comment3);

        Comment comment4 = new Comment();
        comment4.setChildren(new ArrayList<Comment>());
        comment4.setContent("武藏！小次郎！");
        comments5.add(comment4);

        Comment comment5 = new Comment();
        comment5.setChildren(new ArrayList<Comment>());
        comment5.setContent("喵！");
        comments5.add(comment5);

        Comment comment6 = new Comment();
        comment6.setChildren(comments5);
        comment6.setContent("我们就大发慈悲的回答你");
        comments1.add(comment6);

        return comments1;
    }
}
