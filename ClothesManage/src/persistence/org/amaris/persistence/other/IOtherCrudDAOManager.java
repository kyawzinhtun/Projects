package org.amaris.persistence.other;

import java.util.List;

import org.amaris.service.inventoryManage.Style;
import org.amaris.service.othercrud.OtherCrudObject;

public interface IOtherCrudDAOManager {
	
	String getMaxId();
	void insertOtherCrud(OtherCrudObject crud);
	void updateOtherCrud(OtherCrudObject crud);
	void deleteOtherCrud(String id);
	public List<OtherCrudObject> findByStockNameFilter(String stockname);
	List<OtherCrudObject>  findAll();
	OtherCrudObject findById(String id);
	List<OtherCrudObject> findByDate(String startDate, String endDate);
	

}
