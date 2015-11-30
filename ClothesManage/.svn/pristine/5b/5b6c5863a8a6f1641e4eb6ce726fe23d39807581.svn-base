package org.amaris.service.othercrud;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.amaris.persistence.other.IOtherCrudDAOManager;
import org.springframework.stereotype.Service;

@Service("OtherCrudServiceManager")
public class OtherCrudServiceManager implements IOtherCrudServiceManager {
	
	@Resource(name = "OtherCrudDAOManager")
	IOtherCrudDAOManager iOtherCrudDAOManger;
	
	
	@Override
	public String getMaxId() {
		String id="";
		try {
			return iOtherCrudDAOManger.getMaxId();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return id;
	}

	@Override
	public void insertOtherCrud(OtherCrudObject crud) {
		try {
			iOtherCrudDAOManger.insertOtherCrud(crud);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void updateOtherCrud(OtherCrudObject crud) {
		try {
			 iOtherCrudDAOManger.updateOtherCrud(crud);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void deleteOtherCrud(String id){
		try {
			iOtherCrudDAOManger.deleteOtherCrud(id);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
			}

	@Override
	public List<OtherCrudObject> findAll() {
		List<OtherCrudObject> resultList=new ArrayList<>();
		try {
			resultList = iOtherCrudDAOManger.findAll();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
		
	}

	@Override
	public OtherCrudObject findById(String id) {
		OtherCrudObject result=new OtherCrudObject();
		try {
			result = iOtherCrudDAOManger.findById(id);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<OtherCrudObject> findByDate(String startDate, String endDate) {
		List<OtherCrudObject> resultList=new ArrayList<>();
		try {
			resultList = iOtherCrudDAOManger.findByDate(startDate, endDate);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
		
	}

	@Override
	public List<OtherCrudObject> findByStockNameFilter(String stockName) {
		List<OtherCrudObject> resultList=new ArrayList<>();
		try {
			resultList = iOtherCrudDAOManger.findByStockNameFilter(stockName);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

}
