package org.amaris.persistence.other;

import java.util.ArrayList;
import java.util.List;

import org.amaris.service.inventoryManage.Style;
import org.amaris.service.lineManager.Line;
import org.amaris.service.othercrud.OtherCrudDate;
import org.amaris.service.othercrud.OtherCrudObject;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("OtherCrudDAOManager")
public class OtherCrudDAOManager extends SqlMapClientDaoSupport implements IOtherCrudDAOManager {

	@Override
	public String getMaxId() {
		int id;
		try{
			id =  (Integer) getSqlMapClientTemplate().queryForObject("other.selectMaxId");
			return id+"";
		} catch (DataAccessException de){
		   de.printStackTrace();
		   throw de;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	@Override
	public void insertOtherCrud(OtherCrudObject crud) {
		try{
			getSqlMapClientTemplate().insert("other.insertOtherCrud",crud);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void updateOtherCrud(OtherCrudObject crud) {
		try{
			getSqlMapClientTemplate().update("other.updateOtherCrud",crud);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void deleteOtherCrud(String id) {
		try{
			getSqlMapClientTemplate().delete("other.deleteOtherCrud",id);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

	@Override
	public List<OtherCrudObject> findAll() {
		List<OtherCrudObject> resultList = new ArrayList<>();
		try{
			resultList = getSqlMapClientTemplate().queryForList("other.selectAll");
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public OtherCrudObject findById(String id) {

		OtherCrudObject result = new OtherCrudObject();
		try{
			result = (OtherCrudObject) getSqlMapClientTemplate().queryForObject("other.selectByID",id);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	
	
	}

	@Override
	public List<OtherCrudObject> findByDate(String startDate, String endDate) {
		OtherCrudDate otherCrudDate=new OtherCrudDate();
		otherCrudDate.setStartDate(startDate);
		otherCrudDate.setEndDate(endDate);
		
		List<OtherCrudObject> resultList = new ArrayList<>();
		try{
			resultList = getSqlMapClientTemplate().queryForList("other.selectByDate",otherCrudDate);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	
	}

	@Override
	public List<OtherCrudObject> findByStockNameFilter(String stockname) {
		List<OtherCrudObject> resultList = new ArrayList<OtherCrudObject>();
		try {
			resultList = getSqlMapClientTemplate().queryForList("other.selectByStockNameFilter", stockname);
		}
		catch(DataAccessException de) {
			de.printStackTrace();
		}
		return resultList;
	
	}

}
