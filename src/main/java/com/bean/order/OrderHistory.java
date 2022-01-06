package com.bean.order;

/**
 * 历史委托类
 */
public class OrderHistory {
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
        return "OrderHistory{" +
                "op=" + op +
                ", data=" + data +
                '}';
    }
}
