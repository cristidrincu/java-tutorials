
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristiandrincu
 */
class PsdeTireClusterHeader {
    private int wltpId;
    private String salesDesignation;
    private String motorDescription;
    private Date sov;
    private String options;
    
    public PsdeTireClusterHeader() {}

    public int getWltpId() {
        return wltpId;
    }

    public String getSalesDesignation() {
        return salesDesignation;
    }

    public String getMotorDescription() {
        return motorDescription;
    }

    public Date getSov() {
        return sov;
    }

    public String getOptions() {
        return options;
    }

    public void setWltpId(int wltpId) {
        this.wltpId = wltpId;
    }

    public void setSalesDesignation(String salesDesignation) {
        this.salesDesignation = salesDesignation;
    }

    public void setMotorDescription(String motorDescription) {
        this.motorDescription = motorDescription;
    }

    public void setSov(Date sov) {
        this.sov = sov;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "PsdeTireClusterHeader{" + "wltpId=" + wltpId + ", salesDesignation=" + salesDesignation + ", motorDescription=" + motorDescription + ", sov=" + sov + ", options=" + options + '}';
    }
}
