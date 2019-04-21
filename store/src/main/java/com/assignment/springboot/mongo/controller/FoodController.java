package com.assignment.springboot.mongo.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.springboot.mongo.model.FoodEntity;
import com.assignment.springboot.mongo.service.FoodService;

@RestController
@RequestMapping(value= "/store/products")
public class FoodController {

	@Autowired
	FoodService serv;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to save items in the db.
	 * @param item
	 * @return
	 */
	@PostMapping(value= "/create")
	public String create(@RequestBody List<FoodEntity> item) {
		logger.debug("Saving items.");
		serv.addItem(item);
		return "Item records created.";
	}

	/**
	 * Method to fetch all items from the db.
	 * @return
	 */
	@GetMapping(value= "/getall")
	public Collection<FoodEntity> getAll() {
		logger.debug("Getting all items.");
		return serv.getItems();
	}

	/**
	 * Method to fetch item by id.
	 * @param prodId
	 * @return
	 */
	@GetMapping(value= "/getbyid/{prod-id}")
	public Optional<FoodEntity> getById(@PathVariable(value= "prod-id") int prodId) {
		logger.debug("Getting item with prod-id= {}.", prodId);
		return serv.findById(prodId);
	}

	/**
	 * Method to update items by id.
	 * @param prodId
	 * @param e
	 * @return
	 */
	@PutMapping(value= "/update/{prod-id}")
	public String update(@PathVariable(value= "prod-id") int prodId, @RequestBody FoodEntity e) {
		logger.debug("Updating product with prod-id= {}.", prodId);
		e.setProdId(prodId);
		serv.updateItem(e);
		return "product record for prod-id= " + prodId + " updated.";
	}

	/**
	 * Method to delete item by id.
	 * @param prodId
	 * @return
	 */
	@DeleteMapping(value= "/delete/{prod-id}")
	public String delete(@PathVariable(value= "prod-id") int prodId) {
		logger.debug("Deleting item with prod-id= {}.", prodId);
		serv.removeItem(prodId);
		return "Item record for prod-id= " + prodId + " deleted.";
	}

	/**
	 * Method to delete all items from the db.
	 * @return
	 */
	@DeleteMapping(value= "/deleteall")
	public String deleteAll() {
		logger.debug("Deleting all items.");
		serv.deleteAllItems();
		return "All items records deleted.";
	}
}