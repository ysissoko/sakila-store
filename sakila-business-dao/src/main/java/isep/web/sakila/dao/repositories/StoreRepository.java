package isep.web.sakila.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import isep.web.sakila.jpa.entities.Store;

public interface StoreRepository extends JpaRepository<Store, Byte> {
	@Query("select s from Store s where s.storeId = ?1")
	Store findByIdStore(Byte id);

}