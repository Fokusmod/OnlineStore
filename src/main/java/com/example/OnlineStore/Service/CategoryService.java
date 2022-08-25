package com.example.OnlineStore.Service;

import com.example.OnlineStore.Models.Category;
import com.example.OnlineStore.aspect.ExecutionTime;
import com.example.OnlineStore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    @ExecutionTime
    public List<Category> findAll() {
       return categoryRepository.findAll();
    }
    @ExecutionTime
    public Optional<Category> findByTitle (String title) {
        return categoryRepository.findByTitle(title);
    }
}
