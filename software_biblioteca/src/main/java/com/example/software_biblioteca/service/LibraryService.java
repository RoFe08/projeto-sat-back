package com.example.software_biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.software_biblioteca.Library;
import com.example.software_biblioteca.repository.LibraryRepository;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    public void createItem(Library item) {
        var newItem = new Library();
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        newItem.setCategory(item.getCategory());
        libraryRepository.createItem(newItem.getName(), newItem.getDescription(), newItem.getCategory());
    }

    public void putItem(Library item, Long id) {
        libraryRepository.putItem(item.getName(), item.getDescription(), item.getCategory(), id);
    }

    public List<Library> getItems() {
        return libraryRepository.findAll();
    }

    public void deleteItem(Long id) {
        libraryRepository.deleteItem(id);
    }
}