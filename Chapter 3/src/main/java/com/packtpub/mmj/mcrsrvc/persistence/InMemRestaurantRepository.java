package com.packtpub.mmj.mcrsrvc.persistence;

import com.packtpub.mmj.mcrsrvc.domain.model.Entity;
import com.packtpub.mmj.mcrsrvc.domain.model.Restaurant;
import com.packtpub.mmj.mcrsrvc.domain.model.RestaurantRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemRestaurantRepository implements RestaurantRepository<Restaurant, String> {

    private Map<String, Restaurant> entities;

    /**
     * Initialize the in-memory Restaurant Repository with empty Map
     */
    public InMemRestaurantRepository() {
        entities = new HashMap<>();
    }

    /**
     * Check if given restaurant name already exist.
     *
     * @return true if already exist, else false
     */
    @Override
    public boolean containsName(String name) {
        return entities.containsKey(name);
    }

    @Override
    public void add(Restaurant entity) {
        entities.put(entity.getName(), entity);
    }

    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }

    @Override
    public void update(Restaurant entity) {
        if (entities.containsKey(entity.getName())) {
            entities.put(entity.getName(), entity);
        }
    }

    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Restaurant> getAll() {
        return entities.values();
    }

}
