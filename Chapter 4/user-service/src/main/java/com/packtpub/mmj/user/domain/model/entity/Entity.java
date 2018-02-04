package com.packtpub.mmj.user.domain.model.entity;

import lombok.Data;

@Data
public abstract class Entity<T> {
    T id;
    String name;
}