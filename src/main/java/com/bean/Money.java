package com.bean;

public class Money {
    private String accountNo;
    private Double zye;              //总余额
    private Double kyzj;             //可用保证金
    private Double bzj;              //占用保证金
    private Double djzj;             //冻结资金
    private Double zzc;              //总资产
    private Double ljyk;             //累计盈亏
    private Double dryk;             //当日盈亏
    private Double zsz;              //总市值
    private String risk;             //风险度
    private Double zyk;              //总盈亏
    private Double fdyk;             //浮动盈亏
    private Double bzjByRealTime;    //实时已用保证金
    private String profitRatio;      //总收益率

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getZye() {
        return zye;
    }

    public void setZye(Double zye) {
        this.zye = zye;
    }

    public Double getKyzj() {
        return kyzj;
    }

    public void setKyzj(Double kyzj) {
        this.kyzj = kyzj;
    }

    public Double getBzj() {
        return bzj;
    }

    public void setBzj(Double bzj) {
        this.bzj = bzj;
    }

    public Double getDjzj() {
        return djzj;
    }

    public void setDjzj(Double djzj) {
        this.djzj = djzj;
    }

    public Double getZzc() {
        return zzc;
    }

    public void setZzc(Double zzc) {
        this.zzc = zzc;
    }

    public Double getLjyk() {
        return ljyk;
    }

    public void setLjyk(Double ljyk) {
        this.ljyk = ljyk;
    }

    public Double getDryk() {
        return dryk;
    }

    public void setDryk(Double dryk) {
        this.dryk = dryk;
    }

    public Double getZsz() {
        return zsz;
    }

    public void setZsz(Double zsz) {
        this.zsz = zsz;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public Double getZyk() {
        return zyk;
    }

    public void setZyk(Double zyk) {
        this.zyk = zyk;
    }

    public Double getFdyk() {
        return fdyk;
    }

    public void setFdyk(Double fdyk) {
        this.fdyk = fdyk;
    }

    public Double getBzjByRealTime() {
        return bzjByRealTime;
    }

    public void setBzjByRealTime(Double bzjByRealTime) {
        this.bzjByRealTime = bzjByRealTime;
    }

    public String getProfitRatio() {
        return profitRatio;
    }

    public void setProfitRatio(String profitRatio) {
        this.profitRatio = profitRatio;
    }
}
