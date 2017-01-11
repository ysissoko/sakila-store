package isep.web.sakila.webapi.service;

import java.util.List;

import isep.web.sakila.webapi.model.InventoryWO;

public interface InventoryService {

	List<InventoryWO> findAllInventories();

	List<InventoryWO> findAllInventoriesByIdFilm(int id_film);

	InventoryWO findById(int id);

	void saveInventory(InventoryWO inventoryWO);

	void deleteInventoryById(int id);

}