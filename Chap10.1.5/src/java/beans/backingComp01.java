package beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class backingComp01 implements Serializable{

    private String sectionId;
    private String personalId;
    private String name;
    
    @EJB
    CompWorker01 wk;
    
    public String register(){
        wk.register(
                new CompEntity01((
                new CompositeKey01(sectionId, personalId)),name));
        clear();
        return null;
    }

    public void clear(){sectionId = personalId = name=null;}

    public List<CompEntity01> getData(){
        return wk.getData();
}

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
