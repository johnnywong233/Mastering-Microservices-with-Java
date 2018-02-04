package com.packtpub.mmj.mcrsrvc.domain.model;

import lombok.Data;

/**
 * @param <T>
 * @author Sourabh Sharma
 */
@Data
public abstract class Entity<T> {
    T id;
    String name;
}