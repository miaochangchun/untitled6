package com.bean;
import java.util.Date;

/**
 * Auto-generated: 2022-01-06 16:3:17
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CjList {

    private String id;
    private String accountNo;
    private Date cjsj;
    private String code;
    private String combPositionId;
    private String side;
    private int cjsl;
    private int cjjj;
    private long cjje;
    private String cjbh;
    private String exchange;
    private String htbh;
    private long qsDay;
    private String stockName;
    private Date updateTime;
    private Date createTime;
    private String cjType;
    private int unit;
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    public String getAccountNo() {
        return accountNo;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }
    public Date getCjsj() {
        return cjsj;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setCombPositionId(String combPositionId) {
        this.combPositionId = combPositionId;
    }
    public String getCombPositionId() {
        return combPositionId;
    }

    public void setSide(String side) {
        this.side = side;
    }
    public String getSide() {
        return side;
    }

    public void setCjsl(int cjsl) {
        this.cjsl = cjsl;
    }
    public int getCjsl() {
        return cjsl;
    }

    public void setCjjj(int cjjj) {
        this.cjjj = cjjj;
    }
    public int getCjjj() {
        return cjjj;
    }

    public void setCjje(long cjje) {
        this.cjje = cjje;
    }
    public long getCjje() {
        return cjje;
    }

    public void setCjbh(String cjbh) {
        this.cjbh = cjbh;
    }
    public String getCjbh() {
        return cjbh;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
    public String getExchange() {
        return exchange;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }
    public String getHtbh() {
        return htbh;
    }

    public void setQsDay(long qsDay) {
        this.qsDay = qsDay;
    }
    public long getQsDay() {
        return qsDay;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    public String getStockName() {
        return stockName;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCjType(String cjType) {
        this.cjType = cjType;
    }
    public String getCjType() {
        return cjType;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
    public int getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "SecurityOrderList{" +
                "id='" + id + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", cjsj=" + cjsj +
                ", code='" + code + '\'' +
                ", combPositionId='" + combPositionId + '\'' +
                ", side='" + side + '\'' +
                ", cjsl=" + cjsl +
                ", cjjj=" + cjjj +
                ", cjje=" + cjje +
                ", cjbh='" + cjbh + '\'' +
                ", exchange='" + exchange + '\'' +
                ", htbh='" + htbh + '\'' +
                ", qsDay=" + qsDay +
                ", stockName='" + stockName + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", cjType='" + cjType + '\'' +
                ", unit=" + unit +
                '}';
    }
}