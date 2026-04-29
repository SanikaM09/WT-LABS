package com.berryco.cafe.repository;

import com.berryco.cafe.model.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MenuRepository {
    private final List<MenuItem> menuItems = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public MenuRepository() {
        save(new MenuItem(null, "Berry Latte", "Coffee", 4.5));
        save(new MenuItem(null, "Strawberry Croissant", "Bakery", 3.75));
        save(new MenuItem(null, "Blueberry Cheesecake", "Dessert", 5.25));
    }

    public List<MenuItem> findAll() {
        return menuItems;
    }

    public MenuItem save(MenuItem item) {
        item.setId(idCounter.getAndIncrement());
        menuItems.add(item);
        return item;
    }

    public Optional<MenuItem> findById(Long id) {
        return menuItems.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    public boolean deleteById(Long id) {
        return menuItems.removeIf(item -> item.getId().equals(id));
    }
}
