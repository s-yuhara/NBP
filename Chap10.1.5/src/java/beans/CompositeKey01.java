package beans;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class CompositeKey01 implements Serializable{
private String sectionId;
private String personalId;

public CompositeKey01 (){}

    public CompositeKey01(String sectionId, String personalId) {
        this.sectionId = sectionId;
        this.personalId = personalId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public String getPersonalId() {
        return personalId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.sectionId);
        hash = 13 * hash + Objects.hashCode(this.personalId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CompositeKey01 other = (CompositeKey01) obj;
        if (!Objects.equals(this.sectionId, other.sectionId)) {
            return false;
        }
        if (!Objects.equals(this.personalId, other.personalId)) {
            return false;
        }
        return true;
    }


}
