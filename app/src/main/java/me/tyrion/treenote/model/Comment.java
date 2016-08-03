package me.tyrion.treenote.model;

import java.util.List;

/**
 * Created by taomaogan on 2016/7/23.
 */
public class Comment {
    /**
     * 孩子数量
     */
    private List<Comment> children;
    /**
     * 展示内容
     */
    private String content;
    /**
     * 是否可见，父节点收起后，子节点需要隐藏
     */
    private boolean isVisible = true;
    /**
     * 当前节点是否收起状态
     */
    private boolean isExpand = true;
    /**
     * 是否需要还原状态，父节点收起后会影响到子节点的状态
     */
    private boolean isNeedReduction = false;
    /**
     * 当前节点等级，根据等级不同绘制竖线
     */
    private int level;


    public boolean isNeedReduction() {
        return isNeedReduction;
    }

    public void setNeedReduction(boolean needReduction) {
        isNeedReduction = needReduction;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
