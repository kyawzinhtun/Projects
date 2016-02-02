package org.amaris.persistence.balanceManage;

import java.util.ArrayList;
import java.util.List;

import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.balanceManage.StockBalance;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "BalanceDAOManager")
public class BalanceDAOManager  extends SqlMapClientDaoSupport implements IBalanceDAOManager {

	@Transactional(propagation=Propagation.REQUIRED)
	public void insertStock(StockBalance stockBalance) {
		try{
			getSqlMapClientTemplate().insert("stockBalanceManager.insert_StockBalance_Mst", stockBalance);
			insertStockDesDetail(stockBalance);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertStockDesDetail(StockBalance stockBalance) {
		try{
			getSqlMapClientTemplate().insert("stockBalanceManager.insert_stock_des_detail", stockBalance);
			insertStockQtyDetail(stockBalance);
		}
		catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertStockQtyDetail(StockBalance stockBalance) {
		try{
			for(BalanceDetail bdetails : stockBalance.getBalanceDetail()) {
				bdetails.setStockInId(stockBalance.getStockInId());
				getSqlMapClientTemplate().insert("stockBalanceManager.insert_stock_qty_detail", bdetails); 
			}
		}
		catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<StockBalance> selectByFilter(String searchKey) {
		List<StockBalance> resultList = new ArrayList<StockBalance>();
		try{
			resultList = getSqlMapClientTemplate().queryForList("stockBalanceManager.selectByKey", searchKey);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public void upDateStock(StockBalance stockBalance) {
		try{
			String stockInId = stockBalance.getStockInId();
			deleteStock(stockInId);
			deleteStockDesDetail(stockInId);
			deleteStockQtyDetail(stockInId);
			insertStock(stockBalance);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteStock(String stockInId) {
		try{
			getSqlMapClientTemplate().update("stockBalanceManager.delete_StockBalance_Mst", stockInId);
			deleteStockDesDetail(stockInId);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteStockDesDetail(String stockInId) {
		try{
			getSqlMapClientTemplate().update("stockBalanceManager.delete_stock_des_detail", stockInId);
			deleteStockQtyDetail(stockInId);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteStockQtyDetail(String stockInId) {
		try{
			getSqlMapClientTemplate().update("stockBalanceManager.delete_stock_qty_detail", stockInId);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<StockBalance> selectAll() {
		List<StockBalance> stockDesDetailList;
		try{
			stockDesDetailList = (List<StockBalance>)getSqlMapClientTemplate().queryForList("stockBalanceManager.select_all_stock");
			return stockDesDetailList;
		} catch (DataAccessException de){
		   de.printStackTrace();
		   throw de;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<BalanceDetail> selectBalanceDetailByFilter(String stockInId) {
		List<BalanceDetail> resultList;
		try{
			resultList = (List<BalanceDetail>)getSqlMapClientTemplate().queryForList("stockBalanceManager.selectSQDByKey", stockInId);
			return resultList;
		} catch (DataAccessException de){
		   de.printStackTrace();
		   throw de;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public String selectMaxId() {
		int id;
		try{
			id =  (int) getSqlMapClientTemplate().queryForObject("stockBalanceManager.selectMaxId");
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

	@Transactional(propagation=Propagation.REQUIRED)
	public List<StockBalance> selectBalanceDetailByNameFilter(String name) {
		List<StockBalance> resultList = new ArrayList<StockBalance>();
		try{
			resultList = getSqlMapClientTemplate().queryForList("stockBalanceManager.selectByNameKey", name);
		} catch (DataAccessException de){
		   de.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

}
