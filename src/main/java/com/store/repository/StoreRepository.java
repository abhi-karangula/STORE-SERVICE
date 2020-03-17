package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.bean.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
