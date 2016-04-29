package beans;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CompEntity01 implements Serializable{
@EmbeddedId
private CompositeKey01 id;
private String name;

    public CompEntity01() {
    }

    public CompositeKey01 getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompEntity01(CompositeKey01 id, String name) {
        this.id = id;
        this.name = name;
    }

}
