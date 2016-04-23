package beans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@Named 
@ViewScoped
public class BackingUser01 implements Serializable{

    @NotNull
    private String id;
    private String name;
    private String zipcode;
    private String address;

@EJB
UserWorker01 wk;
@Inject
transient Logger log;

public String register(){
    UserEntity01 entity = new UserEntity01(id, name, zipcode, address);
    try{ wk.register(entity);
    clear();
        }catch (Exception e){
            log.log(Level.SEVERE,"ID{0}を登録できません。",id);
    }
    return null;
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


   public void clear() {
        id = name = address = zipcode=null;
    }

public List<UserEntity01> getData(){
        return wk.getData();
}

}
