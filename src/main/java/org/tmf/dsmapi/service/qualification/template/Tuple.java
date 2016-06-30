/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.template;

/**
 *
 * @author Henry
 */
public class Tuple<M, N> {

    private final M value;
    private final N unit;

    public Tuple(M value, N unit) {
        this.value = value;
        this.unit = unit;
    }

    public M getValue() {
        return value;
    }

    public N getUnit() {
        return unit;
    }
}
