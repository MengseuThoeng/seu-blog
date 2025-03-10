package com.reki.seu_blog.domain;

import com.reki.seu_blog.config.jpa.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Type;
import java.util.Set;

@Entity
@Table(name = "blogs")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Blog extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String cover;

    @Column(unique = true, nullable = false)
    private String slug;

    private Boolean isDeleted = false;


    @ManyToMany
    @JoinTable(name = "blogs_categories",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @ManyToOne
    private User user;
}
