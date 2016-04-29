package beans;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Contact implements Serializable{
private String telephone;
private String mail;

    public Contact() {
    }

    public Contact(String telephone, String mail) {
        this.telephone = telephone;
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMail() {
        return mail;
    }




}
