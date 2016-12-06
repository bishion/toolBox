package com.bizi.study.list2tree;

import com.bizi.tools.json.JsonMapper;

import java.util.*;

/**
 * 描述：
 * Created by GuoFangBi on 16-1-30.
 */
public class Main {
    public static void main(String[] args) {

        List<Item> itemList = getItemList();

        List<Item> nodeList = new ArrayList<Item>();
        for(Item node1 : itemList){
            if(node1.getParentId()!="0"){
                for(Item node2 : itemList){
                    if(node1.getParentId().equals(node2.getId())){
                        if(node2.getChildren() == null)
                            node2.setChildren(new TreeSet<>());
                        node2.getChildren().add(node1);
                        break;
                    }
                }
            }else {
                nodeList.add(node1);
            }
        }
        //转为json格式
        java.lang.String json = JsonMapper.toNormalJson(nodeList);
        System.out.println(json);
    }

    static List<Item> getItemList(){
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("1","0","一级菜单",1));
        itemList.add(new Item("2","1","2级菜单",1));
        itemList.add(new Item("3","1","2级菜单",2));
        itemList.add(new Item("4","3","3级菜单",2));
        itemList.add(new Item("5","3","3级菜单",1));
        itemList.add(new Item("6","5","4级菜单",1));
        itemList.add(new Item("7","6","5级菜单",1));
        itemList.add(new Item("8","7","6级菜单",1));
        itemList.add(new Item("9","0","一级菜单",2));
        itemList.add(new Item("10","9","2级菜单",1));
        itemList.add(new Item("11","9","2级菜单",2));
        itemList.add(new Item("12","10","3级菜单",1));
        itemList.add(new Item("13","11","3级菜单",1));

        return itemList;
    }
}
