package beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="USER_DATA1")
public class UserEntity01 implements Serializable{

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long uid;

private String id;
private String name;
private String zipcode;
private String address;
public UserEntity01(){}
public UserEntity01(String id, String name ,String zipcode,String address){
    this.uid = uid;
    this.id =id;
    this.name = name;
    this.zipcode = zipcode;
    this.address = address;
}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }


}
