package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class BackingArrayList implements Serializable{

    private String id;
    private String name;
    private String course1;
    private String course2;
    private String course3;

@EJB
ArrayListWorker wk;

public String register(){
    List<String>lst = new ArrayList<>();
    lst.add(course1);
    lst.add(course2);
    lst.add(course3);
    wk.register(
        new ArrayListEntity(id,name,lst));
        clear();
    return null;
}    
public void clear(){
        id=name=course1=course2=course3=null;
}

public List<ArrayListEntity> getData(){
    return wk.getData();
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

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getCourse3() {
        return course3;
    }

    public void setCourse3(String course3) {
        this.course3 = course3;
    }
}
