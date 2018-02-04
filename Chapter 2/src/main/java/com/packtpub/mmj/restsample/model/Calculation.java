package com.packtpub.mmj.restsample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author sousharm
 */
@Data
@AllArgsConstructor
public class Calculation {
    private List<String> input;
    private List<String> output;
    String function;
}