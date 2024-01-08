package com.example.software_biblioteca.resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.software_biblioteca.Library;
import com.example.software_biblioteca.service.LibraryService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LibraryResource {

    @Autowired
    LibraryService libraryService;

    @PostMapping(value = "/create")
    public void createItem(@RequestBody Library item) {
        libraryService.createItem(item);
    }

    @PutMapping(value = "/put/{id}")
    public void updateLibraryItem(@PathVariable String id, @RequestBody Library item) {
        libraryService.putItem(id, item);
    }

    @GetMapping(value = "/get")
    public List<Library> getItems() {
        var items = libraryService.getItems();
        return items;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteLibraryItem(@PathVariable String id) {
        libraryService.deleteItem(id);
    }
}
