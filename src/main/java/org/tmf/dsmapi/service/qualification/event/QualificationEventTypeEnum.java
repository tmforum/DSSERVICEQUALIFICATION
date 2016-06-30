/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.event;

/**
 *
 * @author Lin
 */
public enum QualificationEventTypeEnum {
    
    ServiceQualificationCreation("ServiceQualificationCreation"),
    ProductOfferingQualificationCreation("AppointmentUpdateNotification");
    
    private String text;

    QualificationEventTypeEnum(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return this.text;
    }

    /**
     *
     * @param text
     * @return
     */
    public static QualificationEventTypeEnum fromString(String text) {
        if (text != null) {
            for (QualificationEventTypeEnum b : QualificationEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}
