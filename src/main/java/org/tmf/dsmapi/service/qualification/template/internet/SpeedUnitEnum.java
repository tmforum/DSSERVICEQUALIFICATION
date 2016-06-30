/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.template.internet;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets CharacteristicUnitEnum
 *
 * @author Lin
 */
public enum SpeedUnitEnum {

    KBPS("KBPS"),
    MBPS("MBPS");
    final private String value;

    SpeedUnitEnum(String value) {
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
