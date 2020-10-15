package citybikesapis.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Location{
    @JsonProperty("city") 
    public String getCity() { 
		 return this.city; } 
    public void setCity(String city) { 
		 this.city = city; } 
    String city;
    @JsonProperty("country") 
    public String getCountry() { 
		 return this.country; } 
    public void setCountry(String country) { 
		 this.country = country; } 
    String country;
    @JsonProperty("latitude") 
    public double getLatitude() { 
		 return this.latitude; } 
    public void setLatitude(double latitude) { 
		 this.latitude = latitude; } 
    double latitude;
    @JsonProperty("longitude") 
    public double getLongitude() { 
		 return this.longitude; } 
    public void setLongitude(double longitude) { 
		 this.longitude = longitude; } 
    double longitude;
}
