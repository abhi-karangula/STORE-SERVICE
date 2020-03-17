package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.bean.Store;
import com.store.service.IStoreService;

@RestController
@RequestMapping("api/store")
public class StoreController {

	@Autowired
	IStoreService storeService;

	@PostMapping("/saveStore")
	public ResponseEntity<?> saveStore(@RequestBody Store store) {
		ResponseEntity<?> response = null;
		try {
			Store savedStore = storeService.saveStore(store);
			if (savedStore == null) {
				response = ResponseEntity.accepted().body("Could not save the store details.");
			} else {
				response = ResponseEntity.ok(savedStore);
			}
		} catch (Exception ex) {
			response = ResponseEntity.badRequest().body("Exception occurred, try again");
		}
		return response;
	}

	@GetMapping("/getStoreList")
	public ResponseEntity<?> getStoreList() {
		ResponseEntity<?> response = null;
		try {
			List<Store> storeList = storeService.getStoreList();
			if (storeList.isEmpty()) {
				response = ResponseEntity.accepted().body("There are no store's available.");
			} else {
				response = ResponseEntity.ok(storeList);
			}
		} catch (Exception ex) {
			response = ResponseEntity.badRequest().body("Exception occurred, try again");
		}
		return response;
	}

	@DeleteMapping("/deleteStore")
	public ResponseEntity<?> deleteStore(@RequestParam(required = true) Long id) {
		ResponseEntity<?> response = null;
		try {
			storeService.deleteStore(id);
			List<Store> storeList = storeService.getStoreList();
			if (storeList.isEmpty()) {
				response = ResponseEntity.accepted().body("There are no store's available.");
			} else {
				response = ResponseEntity.ok(storeList);
			}
		} catch (Exception ex) {
			response = ResponseEntity.badRequest().body("Exception occurred, try again");
		}
		return response;
	}

	@PutMapping("/updateStore")
	public ResponseEntity<?> updateStore(@RequestBody Store store) {
		ResponseEntity<?> response = null;
		try {
			storeService.updateStore(store);
			List<Store> storeList = storeService.getStoreList();
			if (storeList.isEmpty()) {
				response = ResponseEntity.accepted().body("There are no store's available.");
			} else {
				response = ResponseEntity.ok(storeList);
			}
		} catch (Exception ex) {
			response = ResponseEntity.badRequest().body("Exception occurred, try again");
		}
		return response;
	}
}
