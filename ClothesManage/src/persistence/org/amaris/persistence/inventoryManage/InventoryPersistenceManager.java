package org.amaris.persistence.inventoryManage;

import java.util.ArrayList;
import java.util.List;
import org.amaris.service.inventoryManage.InventoryItem;
import org.amaris.service.inventoryManage.Style;
import org.amaris.service.inventoryManage.StyleInclude;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "InventoryPersistenceManager")
public class InventoryPersistenceManager extends SqlMapClientDaoSupport implements IInventoryPersistenceManager {
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertItem(Style style) {
		try{
			getSqlMapClientTemplate().insert("inventoryManager.insertStyle", style);
			insertSytleDetail(style.getStyleIncludeList());
		} catch (DataAccessException de){
			de.printStackTrace();
		}		
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertSytleDetail(List<StyleInclude> styleIncludeList) {
		try{
			for(StyleInclude si : styleIncludeList) {
				getSqlMapClientTemplate().insert("inventoryManager.style_detail", si);
			}
		} catch (DataAccessException de){
			de.printStackTrace();
		}	
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<Style> selectAll() {
		List<Style> itmeResultList=new ArrayList<Style>();
		try {
			itmeResultList = getSqlMapClientTemplate().queryForList("inventoryManager.findAllStyle");
        } catch (DataAccessException de) {
        	de.printStackTrace();
        } 
		return itmeResultList;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteItem(String itemId) {
		try{
			getSqlMapClientTemplate().delete("inventoryManager.deleteItem", itemId);
		} catch (DataAccessException de){
			de.printStackTrace();
		}
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public InventoryItem preUpdate(String itemId) {
		InventoryItem iv = new InventoryItem();
		iv = (InventoryItem) getSqlMapClientTemplate().queryForObject("inventoryManager.findItemId", itemId);
		return iv;
	}

	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateItem(InventoryItem invItem) {
		try{
			getSqlMapClientTemplate().update("inventoryManager.UpdateItem", invItem);
		} catch (DataAccessException de){
			de.printStackTrace();
		}		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<Style> styleSelectFilter(String styleCode) {
		List<Style> resultList = new ArrayList<Style>();
		try {
			resultList = getSqlMapClientTemplate().queryForList("inventoryManager.SytleByFilter", styleCode);
		}
		catch(DataAccessException de) {
			de.printStackTrace();
		}
		return resultList;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Style selectStyleDetail(String styleCode) {
		Style style = new Style();
		try {
			style = (Style) getSqlMapClientTemplate().queryForObject("inventoryManager.SelectStyleDetail", styleCode);
			style.setStyleIncludeList(selectStyleInclude(styleCode));
		}
		catch(DataAccessException de) {
			de.printStackTrace();
		}
		return style;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<StyleInclude> selectStyleInclude(String styleCode) {
		List<StyleInclude> styleIncludeList = new ArrayList<StyleInclude>();
		try {
			styleIncludeList = getSqlMapClientTemplate().queryForList("inventoryManager.SelectStyleIncludeDetail", styleCode);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return styleIncludeList;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void updateStyle(Style style) {
		try {
			deleteStyleMst(style.getStyleName());
			insertItem(style);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteStyleMst(String styleCode) {
		try {
			getSqlMapClientTemplate().delete("inventoryManager.deleteStyleMst", styleCode);
			deleteSyleInclude(styleCode);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteSyleInclude(String styleCode) {
		try {
			getSqlMapClientTemplate().delete("inventoryManager.deleteStyleInclude", styleCode);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	
}
