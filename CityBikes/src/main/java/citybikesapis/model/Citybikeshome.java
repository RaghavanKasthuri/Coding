package citybikesapis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
 
@Entity
public class Citybikeshome implements Serializable {
       
    private String networkName;
    private String country;
    private String city;
    
    public String getNetworkName() {
        return networkName;
    }
    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
}