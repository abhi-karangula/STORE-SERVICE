package com.store.service;

import java.util.List;

import com.store.bean.Store;

public interface IStoreService {
	public Store saveStore(Store store);
	
	public List<Store> getStoreList();
	
	public void updateStore(Store store);
	
	public void deleteStore(Long id);
}
