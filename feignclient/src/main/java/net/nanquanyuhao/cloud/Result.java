package net.nanquanyuhao.cloud;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by nanquanyuhao on 2017/10/22.
 */
@XmlRootElement
public class Result {

    @XmlElement
    private String message;

    @XmlTransient
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
