package com.reki.seu_blog.domain;

import com.reki.seu_blog.config.jpa.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    private Boolean isDeleted = false;

    @ManyToMany(mappedBy = "categories")
    private Set<Blog> blogs;
}
