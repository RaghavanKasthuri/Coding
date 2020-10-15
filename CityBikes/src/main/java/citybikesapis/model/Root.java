package citybikesapis.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Root{
    @JsonProperty("networks") 
    public List<Network> getNetworks() { 
		 return this.networks; } 
    public void setNetworks(List<Network> networks) { 
		 this.networks = networks; } 
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<Network> networks;
}
