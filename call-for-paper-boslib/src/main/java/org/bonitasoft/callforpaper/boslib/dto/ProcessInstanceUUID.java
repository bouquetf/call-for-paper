package org.bonitasoft.callforpaper.boslib.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProcessInstanceUUID")
public class ProcessInstanceUUID {
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
