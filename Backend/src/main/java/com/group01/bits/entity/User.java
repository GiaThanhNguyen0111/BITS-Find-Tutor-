package com.group01.bits.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userID;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "dob")
    private Date birthDay;

    @Column(name = "email")
    private String email;

    @Column(name = "major")
    private String major;

    @Column(name = "password")
    private String password;

    @Column(name = "image")
    private String image;

    @Column(name = "role")
    private String role;

    @Column(name = "balance")
    private String balance;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Qualification> qualifications;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<AvailableTime> availableTimes;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_schedule",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )
    private List<Schedule> schedules;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tutor_subject",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getUserID() {
        return userID;
    }

    public String getRole() {
        return role;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getImage() {
        return image;
    }

    public List<AvailableTime> getAvailableTimes() {
        return availableTimes;
    }
}
