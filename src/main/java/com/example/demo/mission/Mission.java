package com.example.demo.mission;

import com.example.demo.Consultant.Consultant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@TableGenerator(name="tab", initialValue=100)

public class Mission {
    @Id @GeneratedValue(strategy= GenerationType.AUTO, generator="tab")
    private Long id;
    private @NonNull String missionName;
    private @NonNull String missionDescription;
    private @NonNull float tjm;
    private @NonNull String startDate;
    private String endDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consultantId", referencedColumnName="id", updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private @NonNull Consultant consultant;

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName=missionName;
    }

    public String getMissionDescription() {
        return missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription=missionDescription;
    }

    public float getTjm() {
        return tjm;
    }

    public void setTjm(float tjm) {
        this.tjm=tjm;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate=startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate=endDate;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant=consultant;
    }
}
