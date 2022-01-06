package com.bean;
import java.util.List;

/**
 * Auto-generated: 2022-01-06 16:3:17
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private int count;
    private List<CjList> securityOrderList;
    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    public void setSecurityOrderList(List<CjList> securityOrderList) {
        this.securityOrderList = securityOrderList;
    }
    public List<CjList> getSecurityOrderList() {
        return securityOrderList;
    }

    @Override
    public String toString() {
        return "Data{" +
                "count=" + count +
                ", securityOrderList=" + securityOrderList +
                '}';
    }
}