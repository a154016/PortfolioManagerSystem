package com.portfolio.management.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String userName;
	private String stockName;
	private Date purchaseDate;
	private float buyPrice;
	private int quantity;
	private float investedAmount;
	private float targetPrice;
	private float exitPrice;
	private float expectedGain;
	private String comments;
	@Lob
	private  byte[] files;
	private float ltp;
	
	private String image;
	
	private float holdValue;
	private float marketValue;
	
	  
	

	public float getHoldValue() {
		return holdValue;
	}

	public void setHoldValue(float holdValue) {
		this.holdValue = holdValue;
	}

	public float getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(float marketValue) {
		this.marketValue = marketValue;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getLtp() {
		return ltp;
	}

	public void setLtp(float ltp) {
		this.ltp = ltp;
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



	
	public Todo() {
		super();
	}



	public Todo(long id, String userName, float buyPrice, int quantity, float investedAmount, float targetPrice,
			Float exitPrice, float expectedGain, String comments, String stockName, Date purchaseDate, byte[] files, float ltp) {
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
		this.purchaseDate = purchaseDate;
		this.files=files;
		this.ltp=ltp;
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

	public Date getpurchaseDate() {
		return purchaseDate;
	}

	public void setpurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}