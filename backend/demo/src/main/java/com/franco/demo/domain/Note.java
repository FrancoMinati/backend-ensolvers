package com.franco.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Note extends Base {
    @Column(name = "title")
    private String title;

    @Column(length = 65555,name = "text")
    @NotNull
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name", referencedColumnName = "id")
    private Category category;

    @Column(name = "active")
    private boolean active;
}
