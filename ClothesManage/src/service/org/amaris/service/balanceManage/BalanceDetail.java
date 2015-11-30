package org.amaris.service.balanceManage;

public class BalanceDetail {
	
	// id
	private int stockQtyId;
	
	// inherit from stockBalance
	private String stockInId;
	
	// stock per price
	private String stockPrice;
	
	// total stock quantity if stock is "pate" quantity refer to yards
	private String stockQuantity;
	
	// total price of stock
	private String totalPrice;
	
	// detail of unit count mean width x length or include or none
	private String detailUnitCount;
	
	private String colorNo;
	
	private String qtyInches;
	
	private String cuttingId;
	
	public BalanceDetail() {
		
	}

	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(String stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDetailUnitCount() {
		return detailUnitCount;
	}

	public void setDetailUnitCount(String detailUnitCount) {
		this.detailUnitCount = detailUnitCount;
	}

	public String getStockInId() {
		return stockInId;
	}

	public void setStockInId(String stockInId) {
		this.stockInId = stockInId;
	}

	public int getStockQtyId() {
		return stockQtyId;
	}

	public void setStockQtyId(int stockQtyId) {
		this.stockQtyId = stockQtyId;
	}

	public String getColorNo() {
		return colorNo;
	}

	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
	}

	public String getQtyInches() {
		return qtyInches;
	}

	public void setQtyInches(String qtyInches) {
		this.qtyInches = qtyInches;
	}

	public String getCuttingId() {
		return cuttingId;
	}

	public void setCuttingId(String cuttingId) {
		this.cuttingId = cuttingId;
	}

	
	
}
