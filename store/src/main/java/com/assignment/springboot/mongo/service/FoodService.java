package com.assignment.springboot.mongo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.assignment.springboot.mongo.model.FoodEntity;

public interface FoodService {

	/**
	 * Method to add new item in the db using mongo-db repository.
	 * @param item
	 */
	public void addItem(List<FoodEntity> item);

	/**
	 * Method to fetch all items from the db using mongo-db repository.
	 * @return
	 */
	public Collection<FoodEntity> getItems();

	/**
	 * Method to fetch item by id using mongo-db repository.
	 * @param id
	 * @return
	 */
	public Optional<FoodEntity> findById(int id);

	/**
	 * Method to delete item by id using mongo-db repository.
	 * @param id
	 */
	public void removeItem(int id);

	/**
	 * Method to update item by id using mongo-db repository.
	 * @param id
	 */
	public void updateItem(FoodEntity item);

	/**
	 * Method to delete all items using mongo-db repository.
	 */
	public void deleteAllItems();
}