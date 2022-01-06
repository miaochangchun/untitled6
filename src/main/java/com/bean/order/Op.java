package com.bean.order;

/**
 * Auto-generated: 2022-01-06 16:3:17
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Op {

    private String code;
    private String info;
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Op{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}