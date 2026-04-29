package com.berryco.cafe.service;

import com.berryco.cafe.model.MenuItem;
import com.berryco.cafe.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<MenuItem> getAllItems() {
        return menuRepository.findAll();
    }

    public MenuItem addItem(MenuItem item) {
        return menuRepository.save(item);
    }

    public boolean removeItem(Long id) {
        return menuRepository.deleteById(id);
    }
}
