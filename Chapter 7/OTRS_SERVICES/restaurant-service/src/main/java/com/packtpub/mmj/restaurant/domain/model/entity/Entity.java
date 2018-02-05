package com.packtpub.mmj.restaurant.domain.model.entity;

import lombok.Data;

@Data
public abstract class Entity<T> {
    T id;
    String name;
}
