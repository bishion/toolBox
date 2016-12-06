package com.bizi.study.list2tree;

import java.util.TreeSet;

/**
 * 描述：
 * Created by GuoFangBi on 16-1-30.
 */
public class Node implements Comparable{
    private String text;
    private String id;
    private int level;
    private TreeSet<Node> childList = new TreeSet<>();

    public void addChild(Node node){
        childList.add(node);
    }

    @Override
    public int compareTo(Object o) {
        return ((Node)o).getLevel()-this.level;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TreeSet<Node> getChildList() {
        return childList;
    }

    public void setChildList(TreeSet<Node> childList) {
        this.childList = childList;
    }
}
