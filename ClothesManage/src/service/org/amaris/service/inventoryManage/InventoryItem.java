package org.amaris.service.inventoryManage;

public class InventoryItem {
	
	private String itemId;
	private String itemName;
	private String imagePath;
	private String remarks;
	private String date;
	
	public InventoryItem() {
		
	}
	
	public InventoryItem(String itemId, String itemName, String imagePath,
			String remarks, String date) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.imagePath = imagePath;
		this.remarks = remarks;
		this.date = date;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
