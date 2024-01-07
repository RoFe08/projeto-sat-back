package com.example.software_biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.software_biblioteca.Library;

import jakarta.transaction.Transactional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
	
	@Modifying
	@Transactional
	@Query(value = """
			INSERT INTO biblioteca (id, name, description, category)
			VALUES (:id, :name, :description, :category);
			""", nativeQuery=true)
	public void createItem(String name, String description, String category);
	
	@Modifying
	@Transactional
	@Query(value = """
			DELETE FROM biblioteca WHERE id = :id
			""", nativeQuery = true)
	public void deleteItem(Long id);
	
	public List<Library> findAll();
	
	@Modifying
	@Transactional
	@Query(value = """
			UPDATE biblioteca SET name = :name, description = :description, category = :category where id = :id;
			""", nativeQuery=true)
	public void putItem(String name, String description, String category, Long id);
	
}
