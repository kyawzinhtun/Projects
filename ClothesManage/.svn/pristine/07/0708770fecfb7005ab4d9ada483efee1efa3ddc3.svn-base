package org.amaris.service.inventoryManage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.amaris.persistence.inventoryManage.IInventoryPersistenceManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value="InventoryServiceManager")
public class InventoryServiceManager implements IInventoryServiceManager {
	
	@Resource(name = "InventoryPersistenceManager")
	IInventoryPersistenceManager inventoryPersistenceManager;

	@Transactional(propagation=Propagation.REQUIRED)
	public void addNewItem(Style style) {
		try {
			inventoryPersistenceManager.insertItem(style);
		}
		catch (Exception ex) {
			
		}
		
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public InventoryItem findItem(InventoryItem invItem) {
		try {
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<Style> findAll() {
		List<Style> resultList = new ArrayList<Style>();
		try {
			resultList = inventoryPersistenceManager.selectAll();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public void removeItem(String item) {
		try {
			inventoryPersistenceManager.deleteItem(item);
		}
		catch (Exception ex) {
			
		}
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public InventoryItem preEditItem(String invItem) {
		InventoryItem iv= new InventoryItem();
		try {
			iv = inventoryPersistenceManager.preUpdate(invItem);
		}
		catch (Exception ex) {
			
		}
		
		return iv;
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public void EditItem(InventoryItem invItem) {
		try {
			inventoryPersistenceManager.updateItem(invItem);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public List<Style> findFilterStyle(String styleCode) {
		List<Style> styleList = new ArrayList<Style>();
		try {
			styleList = inventoryPersistenceManager.styleSelectFilter(styleCode);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return styleList;
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public Style findStyleDetail(String styleCode) {
		Style style = new Style();
		try {
			style = inventoryPersistenceManager.selectStyleDetail(styleCode);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return style;
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public void editStyle(Style style) {
		try {
			inventoryPersistenceManager.updateStyle(style);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public void removeStyle(String styleCode) {
		try {
			inventoryPersistenceManager.deleteStyleMst(styleCode);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
