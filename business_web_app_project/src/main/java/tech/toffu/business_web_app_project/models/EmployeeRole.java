package tech.toffu.business_web_app_project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employeerole", uniqueConstraints = @UniqueConstraint(columnNames = "role_name"))
public class EmployeeRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "description")
    private String description;

    // Getter setter
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
