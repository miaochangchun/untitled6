package com.bean.cj;

/**
 * 历史成交表
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CjHistory {

    private Op op;
    private Data data;
    public void setOp(Op op) {
        this.op = op;
    }
    public Op getOp() {
        return op;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return "JsonRootBean{" +
                "op=" + op +
                ", data=" + data +
                '}';
    }
}
