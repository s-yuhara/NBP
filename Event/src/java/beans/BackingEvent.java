package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped

public class BackingEvent {
    private Integer id;
    private String name;
    @Inject
    EventPro ip;
    
    public String setValue(){
        ip.add(id, name);
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventPro getIp() {
        return ip;
    }

    public void setIp(EventPro ip) {
        this.ip = ip;
    }
}
