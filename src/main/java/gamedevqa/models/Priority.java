package gamedevqa.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRIORITIES")
public class Priority {
	
	@Id
	@Column(name="priority_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
    private String description;
    
    @OneToMany
    private List<Bug> bugs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
