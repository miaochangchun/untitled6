package com.bean;

/**
 * 持仓类
 */
public class Position {
    private String accountNo;       //账户
    private String code;            //合约代码
    private String positionType;    //持仓类型
    private Double bzj;             //持仓保证金
    private String exchange;        //交易所
    private Integer kysl;           //可用数量
    private Integer zsl;            //持仓数量
    private String stockName;       //合约名称
    private Integer djsl;           //冻结数量
    private Double cbj;             //成本价
    private Double zcb;             //总成本
    private Integer kcsl;           //开仓数量
    private Double yk;              //盈亏金额
    private Double nowPrice;        //现价
    private Double bzjByRealTime;   //实时保证金
    private Integer remainDay;      //到期天数
    private String exerciseDate;    //到期日
    private String callOrPut;       //认购or认沽
    private String underlyingCode;  //标的代码
    private Integer expectHoldDays; //持仓天数

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public Double getBzj() {
        return bzj;
    }

    public void setBzj(Double bzj) {
        this.bzj = bzj;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Integer getKysl() {
        return kysl;
    }

    public void setKysl(Integer kysl) {
        this.kysl = kysl;
    }

    public Integer getZsl() {
        return zsl;
    }

    public void setZsl(Integer zsl) {
        this.zsl = zsl;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Integer getDjsl() {
        return djsl;
    }

    public void setDjsl(Integer djsl) {
        this.djsl = djsl;
    }

    public Double getCbj() {
        return cbj;
    }

    public void setCbj(Double cbj) {
        this.cbj = cbj;
    }

    public Double getZcb() {
        return zcb;
    }

    public void setZcb(Double zcb) {
        this.zcb = zcb;
    }

    public Integer getKcsl() {
        return kcsl;
    }

    public void setKcsl(Integer kcsl) {
        this.kcsl = kcsl;
    }

    public Double getYk() {
        return yk;
    }

    public void setYk(Double yk) {
        this.yk = yk;
    }

    public Double getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(Double nowPrice) {
        this.nowPrice = nowPrice;
    }

    public Double getBzjByRealTime() {
        return bzjByRealTime;
    }

    public void setBzjByRealTime(Double bzjByRealTime) {
        this.bzjByRealTime = bzjByRealTime;
    }

    public Integer getRemainDay() {
        return remainDay;
    }

    public void setRemainDay(Integer remainDay) {
        this.remainDay = remainDay;
    }

    public String getExerciseDate() {
        return exerciseDate;
    }

    public void setExerciseDate(String exerciseDate) {
        this.exerciseDate = exerciseDate;
    }

    public String getCallOrPut() {
        return callOrPut;
    }

    public void setCallOrPut(String callOrPut) {
        this.callOrPut = callOrPut;
    }

    public String getUnderlyingCode() {
        return underlyingCode;
    }

    public void setUnderlyingCode(String underlyingCode) {
        this.underlyingCode = underlyingCode;
    }

    public Integer getExpectHoldDays() {
        return expectHoldDays;
    }

    public void setExpectHoldDays(Integer expectHoldDays) {
        this.expectHoldDays = expectHoldDays;
    }
}
