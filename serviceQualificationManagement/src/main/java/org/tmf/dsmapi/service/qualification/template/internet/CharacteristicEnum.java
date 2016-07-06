/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.template.internet;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets CharacteristicEnum
 *
 * @author Lin
 */
public enum CharacteristicEnum {

    UPSTREAM_SPEED("upstreamSpeed"),
    DOWNSTREAM_SPEED("downstreamSpeed");
    final private String value;

    CharacteristicEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }
}
