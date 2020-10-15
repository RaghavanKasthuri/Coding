package helloworld;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
 
@Entity
//@Table(name = "search_history")
public class TransactionHistory implements Serializable {
    
    //@Id @GeneratedValue
    //@Column(name = "transaction_id")
    private Integer id;

    //@Column(name = "search_date")
    private Date searchDate;
    
    public Date getSearchDate() {
        return searchDate;
    }
    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

}