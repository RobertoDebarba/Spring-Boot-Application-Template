package io.github.anantharajuc.sbtest.auth;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.github.anantharajuc.sbtest.backend.persistence.domain.backend.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	@Column(name="password")
	private String password; 
	
	@Column(name="username")
	private String username;	
	
	@Column(name="isAccountNonExpired")
	private boolean isAccountNonExpired;
	
	@Column(name="isAccountNonLocked")
	private boolean isAccountNonLocked;
	
	@Column(name="isCredentialsNonExpired")
	private boolean isCredentialsNonExpired;
	
	@Column(name="isEnabled")
	private boolean isEnabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
}
