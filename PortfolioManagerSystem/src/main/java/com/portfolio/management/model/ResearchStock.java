package com.portfolio.management.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "researchStock")
public class ResearchStock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String userName;
	private String stockType;	
	private String stockName;
	private Date researchDate;
	private float buyPrice;
	private int quantity;
	private float targetPrice;
	private float exitPrice;
	private float support;
	private float resistance;
	private float investedAmount;
	private float expectedGain;
	private String comments;
	private String orderType;
	private String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Lob
	private  byte[] files;
	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}	

	public Date getResearchDate() {
		return researchDate;
	}

	public void setResearchDate(Date researchDate) {
		this.researchDate = researchDate;
	}

	public float getSupport() {
		return support;
	}

	public void setSupport(float support) {
		this.support = support;
	}

	public float getResistance() {
		return resistance;
	}

	public void setResistance(float resistance) {
		this.resistance = resistance;
	}

	public byte[] getFiles() {
		return files;
	}

	public void setFiles(byte[] files) {
		this.files = files;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(float investedAmount) {
		this.investedAmount = investedAmount;
	}

	public float getTargetPrice() {
		return targetPrice;
	}

	public void setTargetPrice(float targetPrice) {
		this.targetPrice = targetPrice;
	}

	public Float getExitPrice() {
		return exitPrice;
	}

	public void setExitPrice(Float exitPrice) {
		this.exitPrice = exitPrice;
	}

	public float getExpectedGain() {
		return expectedGain;
	}

	public void setExpectedGain(float expectedGain) {
		this.expectedGain = expectedGain;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public float getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}

	public ResearchStock() {
		super();
	}

	public ResearchStock(long id, String userName, float buyPrice, int quantity, float investedAmount, float targetPrice,
			float exitPrice, float expectedGain, float support, float resistance,String comments, String stockName, Date researchDate, byte[] files
			,String stockType, String orderType,String image
			) {
		super();
		this.id = id;
		this.userName = userName;
		this.buyPrice = buyPrice;
		this.quantity = quantity;
		this.investedAmount = investedAmount;
		this.targetPrice = targetPrice;
		this.exitPrice = exitPrice;
		this.expectedGain = expectedGain;
		this.comments = comments;
		this.stockName = stockName;
		this.researchDate = researchDate;
		this.files=files;
		this.support=support;
		this.resistance=resistance;
		this.stockType=stockType;
		this.orderType=orderType;
		this.image=image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getstockName() {
		return stockName;
	}

	public void setstockName(String stockName) {
		this.stockName = stockName;
	}


}