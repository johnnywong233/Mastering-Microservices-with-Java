package com.packtpub.mmj.restaurant.domain.valueobject;

import com.packtpub.mmj.restaurant.domain.model.entity.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class RestaurantVO {
    private List<Table> tables = new ArrayList<>();
    private String name;
    private String id;
    private String address;
}