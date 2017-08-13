package com.company.goxy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "`id`", nullable = false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="entity_id_seq")
//  @SequenceGenerator(name="entity_id_seq", sequenceName="entity_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
