package com.reki.seu_blog.domain;


import com.reki.seu_blog.config.jpa.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    private String avatar;

    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<UserAuthority> authority;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Blog> blogs;


    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean accountNonExpired;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean accountNonLocked;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean credentialsNonExpired;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isEnabled;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean emailVerified;

}
