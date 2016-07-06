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
public class CharacteristicValueInvalidException extends RuntimeException {

    public CharacteristicValueInvalidException(String desc) {
        super(desc);
    }
}
