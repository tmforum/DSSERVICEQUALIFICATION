/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Lin Gets or Sets qualificationState
 */
public enum QualificationStateEnum {

    INPROGRESS("InProgress"),
    DONE("Done"),
    TERMINATEDWITHERROR("TerminatedWithError");
    private String value;

    QualificationStateEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }
}
