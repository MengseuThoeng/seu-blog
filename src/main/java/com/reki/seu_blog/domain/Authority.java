package com.reki.seu_blog.domain;


import com.reki.seu_blog.config.jpa.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authority extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "authority", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<UserAuthority> userAuthorities;

}
