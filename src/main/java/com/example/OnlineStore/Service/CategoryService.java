package com.example.OnlineStore.Service;

import com.example.OnlineStore.Models.Category;
import com.example.OnlineStore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
       return categoryRepository.findAll();
    }

    public Optional<Category> findByTitle (String title) {
        return categoryRepository.findByTitle(title);
    }
}
