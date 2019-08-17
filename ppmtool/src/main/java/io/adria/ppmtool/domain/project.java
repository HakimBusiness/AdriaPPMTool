package io.adria.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank(message="project name is required")
    String projectName;
    @NotBlank(message="project identifier is required")
    @Size(min=4,max=5,message="plz use 4 to 5 characters")
    @Column(unique = true,updatable = false)
    String projectIdentifier;
    @NotBlank(message="Project description is required")
    String description;
    @JsonFormat(pattern = "yyyy-mm-dd")
    Date start_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    Date end_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    Date created_at;
    @JsonFormat(pattern = "yyyy-mm-dd")
    Date updated_at;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
    public project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PrePersist
    protected void OnCreate()
    {
        this.created_at=new Date();
    }

    @PreUpdate
    protected void OnUpdate()
    {
        this.updated_at=new Date();
    }
}
