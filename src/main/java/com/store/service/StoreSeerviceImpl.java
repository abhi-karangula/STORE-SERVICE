package com.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.bean.Store;
import com.store.repository.StoreRepository;

@Service
public class StoreSeerviceImpl implements IStoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Store saveStore(Store store) {
		Store savedStore = storeRepository.save(store);
		getStoreList();
		return savedStore;
	}

	@Override
	public List<Store> getStoreList() {
		List<Store> storeList = storeRepository.findAll();
		return storeList;
	}

	@Override
	public void updateStore(Store store) {
		Store responseStore = storeRepository.findById(store.getId()).get();
		responseStore.setName(store.getName());
		responseStore.setArea(store.getArea());
		responseStore.setLocality(store.getLocality());
		responseStore.setCity(store.getCity());
		responseStore.setPin(store.getPin());
		responseStore.setState(store.getState());
		responseStore.setLandmark(store.getLandmark());
		storeRepository.save(responseStore);
	}

	@Override
	public void deleteStore(Long id) {
		storeRepository.deleteById(id);
	}

}
