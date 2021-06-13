package com.portfolio.management.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio")
public class PortfolioStock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long stockId;

	private String stockName;
	private float buyPrice;
	private int quantity;
	private Date purchaseDate;
	private float investedAmount;
	private float targetPrice;
	private float expectedAmount;
	private float sellPrice;
	private float actualAmount=(float) 0.0;
	private float exitPrice;
	private String comments;
	private float currentPrice;

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public float getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public float getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(float investedAmount) {
		this.investedAmount = investedAmount;
	}

	public float getExceptedTarget() {
		return targetPrice;
	}

	public void setExceptedTarget(float targetPrice) {
		targetPrice = targetPrice;
	}

	public float getExpectedAmount() {
		return expectedAmount;
	}

	public void setExpectedAmount(float expectedAmount) {
		this.expectedAmount = expectedAmount;
	}

	public float getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}

	public float getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(float actualAmount) {
		this.actualAmount = actualAmount;
	}

	public float getExitPrice() {
		return exitPrice;
	}

	public void setExitPrice(float exitPrice) {
		this.exitPrice = exitPrice;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public PortfolioStock(String stockName, float buyPrice, int quantity, Date purchaseDate, float investedAmount,
			float exceptedTarget, float expectedAmount, float sellPrice, float actualAmount, float exitPrice,
			String comments, float currentPrice) {
		super();
		this.stockName = stockName;
		this.buyPrice = buyPrice;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
		this.investedAmount = investedAmount;
		this.targetPrice=targetPrice;
		this.expectedAmount = expectedAmount;
		this.sellPrice = sellPrice;
		this.actualAmount = actualAmount;
		this.exitPrice = exitPrice;
		this.comments = comments;
		this.currentPrice = currentPrice;
	}

	public PortfolioStock() {
		super();
	}

	@Override
	public String toString() {
		return "PortfolioStock [stockId=" + stockId + ", stockName=" + stockName + ", buyPrice=" + buyPrice
				+ ", quantity=" + quantity + ", purchaseDate=" + purchaseDate + ", investedAmount=" + investedAmount
				+ ", ExceptedTarget=" + targetPrice + ", expectedAmount=" + expectedAmount + ", sellPrice="
				+ sellPrice + ", actualAmount=" + actualAmount + ", exitPrice=" + exitPrice + ", comments=" + comments
				+ ", currentPrice=" + currentPrice + "]";
	}

}
