package com.yc.damai.po;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DmOrders {
    private Integer id;
    
    @NumberFormat(pattern = "#,###.00")
    private Double total;
    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
		this.createtime = new Timestamp(date.getTime());
	}

	//请求参数的格式化注解
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //Json 转换的格式化注解
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    private Timestamp createtime;

    private Integer state;

    private Integer uid;

    private Integer aid;

    private DmOrderitem[] dmOrderitem; 
    

	

	public DmOrderitem[] getDmOrderitem() {
		return dmOrderitem;
	}

	public void setDmOrderitem(DmOrderitem[] dmOrderitem) {
		this.dmOrderitem = dmOrderitem;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}