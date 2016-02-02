package org.amaris.service.SupplierManager;

import java.util.List;

import org.amaris.service.SupplierManager.Supplier;

public interface ISupplierServiceManager {
	public void addSupplier(Supplier supplier);
	public String getLastGenId();
	void updateSupplier(Supplier supplier);
	void deleteSupplier(String id);
	public List<Supplier> findByNameFilter(String Name);
	List<Supplier>  findAll();
	Supplier findById(String id);
	
}
