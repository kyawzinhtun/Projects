package org.amaris.service.othercrud;

import java.util.List;

import org.amaris.service.inventoryManage.Style;

public interface IOtherCrudServiceManager {
	
	String getMaxId();
	void insertOtherCrud(OtherCrudObject crud);
	void updateOtherCrud(OtherCrudObject crud);
	void deleteOtherCrud(String id);
	public List<OtherCrudObject> findByStockNameFilter(String stockName);
	List<OtherCrudObject>  findAll();
	OtherCrudObject findById(String id);
	List<OtherCrudObject> findByDate(String startDate, String endDate);
	

}
