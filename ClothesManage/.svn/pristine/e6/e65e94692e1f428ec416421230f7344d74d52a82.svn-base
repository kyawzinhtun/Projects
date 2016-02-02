package org.amaris.persistence.inventoryManage;

import java.util.List;

import org.amaris.service.inventoryManage.InventoryItem;
import org.amaris.service.inventoryManage.Style;

public interface IInventoryPersistenceManager {
	public void insertItem(Style style);
	public List<Style> selectAll( );
	public void deleteItem(String itemId);
	public InventoryItem preUpdate(String itemId);
	public void updateItem(InventoryItem invItem);
	public List<Style> styleSelectFilter(String styleCode);
	public Style selectStyleDetail(String styleCode);
	public void updateStyle(Style style);
	public void deleteStyleMst(String styleCode);

}
