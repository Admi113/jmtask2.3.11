package web.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "roles")
public class Role
        implements GrantedAuthority
{

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY);
//    @Column(name = "id");
    private Long id;

    @Column
    private String role;

    public Role() {
    }
    @Transient
    @ManyToMany
    @JoinTable(name = "userz_roles"
            ,joinColumns =@JoinColumn(name = "roles_id")
            ,inverseJoinColumns = @JoinColumn(name = "userz_id")
    )
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return role ;
    }
}
