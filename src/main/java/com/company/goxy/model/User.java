package com.company.goxy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "`user`")
@NoArgsConstructor
public class User extends BaseEntity {
	@Setter
	@Column(name = "`type`", length = 100, nullable = false, unique = false)
	private String type;

	@Column(name = "`text`", length = 100, nullable = false, unique = false)
	private String text;	
	
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "adress", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Adress> adressList = new HashSet<Adress>();
	
	public User(Long id){
		this.setId(id);
		this.setType("DEMO");
	}

	@XmlTransient
	public Set<Adress> getAdressList() {
		return adressList;
	}	

}
