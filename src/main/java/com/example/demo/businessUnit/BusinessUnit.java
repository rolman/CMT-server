package com.example.demo.businessUnit;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter@Setter
@NoArgsConstructor
@ToString@EqualsAndHashCode
@TableGenerator(name="tab", initialValue=3)

public class BusinessUnit {
    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator="tab")
    private Long id;
    private @NonNull String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }



}
