package citybikesapis.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import citybikesapis.model.Location;
import citybikesapis.model.License;

public class Network{
    @JsonProperty("company") 
    public List<String> getCompany() { 
		 return this.company; } 
    public void setCompany(List<String> company) { 
		 this.company = company; } 
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<String> company;
    @JsonProperty("gbfs_href") 
    public String getGbfs_href() { 
		 return this.gbfs_href; } 
    public void setGbfs_href(String gbfs_href) { 
		 this.gbfs_href = gbfs_href; } 
    String gbfs_href;
    @JsonProperty("href") 
    public String getHref() { 
		 return this.href; } 
    public void setHref(String href) { 
		 this.href = href; } 
    String href;
    @JsonProperty("id") 
    public String getId() { 
		 return this.id; } 
    public void setId(String id) { 
		 this.id = id; } 
    String id;
    @JsonProperty("license") 
    public License getLicense() { 
		 return this.license; } 
    public void setLicense(License license) { 
		 this.license = license; } 
    License license;
    @JsonProperty("location") 
    public Location getLocation() { 
		 return this.location; } 
    public void setLocation(Location location) { 
		 this.location = location; } 
    Location location;
    @JsonProperty("name") 
    public String getName() { 
		 return this.name; } 
    public void setName(String name) { 
		 this.name = name; } 
    String name;
    @JsonProperty("source") 
    public String getSource() { 
		 return this.source; } 
    public void setSource(String source) { 
		 this.source = source; } 
    String source;
}