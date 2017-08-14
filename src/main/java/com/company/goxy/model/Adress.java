package com.company.goxy.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "`adress`")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=User.class)
@NoArgsConstructor
public class Adress extends BaseEntity{
	@Getter
	@Setter
	@Column(name = "`text`", length = 100, nullable = false, unique = true)
	private String text;
	
	//@JsonManagedReference
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

}
