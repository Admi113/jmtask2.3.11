package web.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY);
//    @Column(name = "id");
    private Long id;

    @Column
    private String role;

    public Role() {
    }

    @ManyToMany
    @JoinTable(name = "userz_roles"
            ,joinColumns =@JoinColumn(name = "roles_id")
            ,inverseJoinColumns = @JoinColumn(name = "userz_id")
    )
    private List<User> users;

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
