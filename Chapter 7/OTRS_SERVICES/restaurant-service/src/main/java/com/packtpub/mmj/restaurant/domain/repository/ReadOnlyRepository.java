package com.packtpub.mmj.restaurant.domain.repository;

import com.packtpub.mmj.restaurant.domain.model.entity.Entity;

import java.util.Collection;

/**
 * @param <TE>
 * @param <T>
 * @author Sourabh Sharma
 */
public interface ReadOnlyRepository<TE, T> {

    //long Count;

    /**
     * @param id
     * @return
     */
    boolean contains(T id);

    /**
     * @param id
     * @return
     */
    Entity get(T id);


    Collection<TE> getAll();
}
