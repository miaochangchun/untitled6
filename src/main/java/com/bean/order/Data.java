package com.bean.order;
import java.util.List;

public class Data {
    private int count;
    private List<SecurityOrderList> securityOrderList;

    public int getCount() {
        return count;
    }

    public List<SecurityOrderList> getSecurityOrderList() {
        return securityOrderList;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSecurityOrderList(List<SecurityOrderList> securityOrderList) {
        this.securityOrderList = securityOrderList;
    }

    @Override
    public String toString() {
        return "Data{" +
                "count=" + count +
                ", securityOrderLists=" + securityOrderList +
                '}';
    }
}
