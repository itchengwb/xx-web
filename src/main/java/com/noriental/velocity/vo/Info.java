package com.noriental.velocity.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Bobo on 2015-11-21 02:01:56
 */
public class Info implements Serializable{

    private String msg;
    private Map<String,String> map;
    private List<Integer> list;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String,String> getMap() {
        return map;
    }

    public void setMap(Map<String,String> map) {
        this.map = map;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Info toString:{"+msg+","+map.toString()+","+list.toString()+"}";
    }
}
