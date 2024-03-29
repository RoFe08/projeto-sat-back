package com.example.software_biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.software_biblioteca.Library;

import jakarta.transaction.Transactional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, String> {
	
	@Modifying
	@Transactional
	@Query(value = """
			INSERT INTO tasks (id, name, description, category)
			VALUES (:id, :name, :description, :category);
			""", nativeQuery=true)
	public void createItem(String id, String name, String description, String category);
	
	@Modifying
	@Transactional
	@Query(value = """
			DELETE FROM tasks WHERE id = :id
			""", nativeQuery = true)
	public void deleteItem(String id);
	
	@Query(value = """
			SELECT * FROM tasks
			""", nativeQuery = true)
	public List<Library> findAll();
	
	@Modifying
	@Transactional
	@Query(value = """
		UPDATE tasks SET name = :name, description = :description, category = :category WHERE id = :id
			""", nativeQuery=true)
	public void putItem (String id, String name, String description, String category);
	
}
