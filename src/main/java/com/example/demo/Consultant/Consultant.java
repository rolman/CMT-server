package com.example.demo.Consultant;

import com.example.demo.mission.Mission;
import lombok.*;
import org.hibernate.id.IncrementGenerator;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@TableGenerator(name="tab", initialValue=2)


public class Consultant {


    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator="tab")
    private Long  id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String gender;
    private  String description;
    private @NonNull String businessUnit;
    /*@OneToMany(mappedBy = "consultant", cascade = CascadeType.ALL)
    private Set<Mission> missions;*/

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender=gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit=businessUnit;
    }
}


