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
        libraryRepository.createItem(item.getId(), item.getName(), item.getDescription(), item.getCategory());
    }

    public void putItem(String id, Library item) {
        libraryRepository.putItem(id, item.getName(), item.getDescription(), item.getCategory());
    }

    public List<Library> getItems() {
        return libraryRepository.findAll();
    }

    public void deleteItem(String id) {
        libraryRepository.deleteItem(id);
    }
}