/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.template.internet;

import org.tmf.dsmapi.service.qualification.template.CharacteristicValueInvalidException;
import org.tmf.dsmapi.service.qualification.template.Tuple;

/**
 *
 * @author Vicent
 */
public class InternetServiceUtil {
    
     /**
     *
     * @param characteristicValue
     * @return
     * @throws CharacteristicValueInvalidException
     */
    public static Tuple<Long, String> parseSpeedCharacteristicValue(String characteristicValue) throws CharacteristicValueInvalidException {

        if (null == characteristicValue || characteristicValue.isEmpty()) {
            throw new CharacteristicValueInvalidException("Characteristic value is empty.");
        }

        int index;
        String valueStr = null;
        Long valueNum = null;
        String unitStr = null;
        for (SpeedUnitEnum speedUnit : SpeedUnitEnum.values()) {
            index = characteristicValue.indexOf(speedUnit.getValue());
            if (index > 0) {
                valueStr = characteristicValue.substring(0, index);
                valueNum = Long.valueOf(valueStr);
                unitStr = characteristicValue.substring(index);
                if (SpeedUnitEnum.MBPS.getValue().equalsIgnoreCase(unitStr)) {
                    unitStr = SpeedUnitEnum.KBPS.getValue();
                    valueNum = valueNum * 1000;
                }
                break;
            }
        }
        if (valueNum == null || unitStr == null) {
            throw new CharacteristicValueInvalidException("Characteristic value is invalid.");
        }
        return new Tuple<>(valueNum, unitStr);
    }
}
