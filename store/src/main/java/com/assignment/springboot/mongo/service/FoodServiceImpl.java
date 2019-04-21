package com.assignment.springboot.mongo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.springboot.mongo.dao.FoodDao;
import com.assignment.springboot.mongo.model.FoodEntity;

@Service
public class FoodServiceImpl implements FoodService {

	// The dao repository will use the Mongodb-Repository to perform the database operations.
	@Autowired
	FoodDao dao;

	
	@Override
	public void addItem(List<FoodEntity> item) {
		dao.saveAll(item);
	}

	
	@Override
	public Collection<FoodEntity> getItems() {
		return dao.findAll();
	}

	
	@Override
	public Optional<FoodEntity> findById(int id) {
		return dao.findById(id);
	}

	
	@Override
	public void removeItem(int id) {
		dao.deleteById(id);
	}

	
	@Override
	public void updateItem(FoodEntity item) {
		dao.save(item);
	}

	
	@Override
	public void deleteAllItems() {
		dao.deleteAll();
	}
}