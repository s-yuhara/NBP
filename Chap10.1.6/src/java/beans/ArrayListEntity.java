package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class ArrayListEntity implements Serializable{

@Id
private String id;
private String name;
@ElementCollection
@CollectionTable(name="course")
private List<String> course;

    public ArrayListEntity() {}

    public ArrayListEntity(String id, String name, List<String> course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getCourse() {
        return course;
    }
}