package org.amaris.service.inventoryManage;

import java.util.List;

public interface IInventoryServiceManager {

	public void addNewItem(Style style);
	public InventoryItem preEditItem(String string);
	public InventoryItem findItem(InventoryItem invItem);
	public void editStyle(Style style);
	public void removeItem(String Item);
	public List<Style> findFilterStyle(String styleCode);
	public List<Style> findAll();
	public Style findStyleDetail(String styleCode);
	public void removeStyle(String styleCode);
	


}
