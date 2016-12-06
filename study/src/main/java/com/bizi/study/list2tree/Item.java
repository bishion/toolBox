package com.bizi.study.list2tree;

import java.util.TreeSet;

/**
 * 描述：
 * Created by GuoFangBi on 16-1-30.
 */
public class Item implements Comparable{
    private String id;
    private String text;
    private String parentId;
    private int    level;
    private TreeSet<Item> children = new TreeSet<>();

    public Item(String id, String parentId,  String text,int level) {
        this.id = id;
        this.text = text;
        this.parentId = parentId;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TreeSet<Item> getChildren() {
        return children;
    }

    public void setChildren(TreeSet<Item> children) {
        this.children = children;
    }

    @Override
    public int compareTo(Object o) {
        int result = ((Item)o).getLevel()-this.level;
        result = result==0?-1:result;
        return ((Item)o).getLevel()-this.level;
    }


    public static void main(String[] args) {
        TreeSet<Item> items = new TreeSet<>();
        items.add(new Item("1","1","1",1));
        items.add(new Item("2","1","1",2));
        System.out.println(items.size());
    }
}
