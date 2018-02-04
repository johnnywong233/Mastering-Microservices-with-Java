package com.packtpub.mmj.mcrsrvc.domain.model;

public interface RestaurantRepository<Restaurant, String> extends Repository<Restaurant, String> {

    boolean containsName(String name);
}
