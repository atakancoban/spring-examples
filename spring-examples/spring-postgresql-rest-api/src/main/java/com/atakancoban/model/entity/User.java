package com.atakancoban.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "usertable")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class User {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "seq_user",allocationSize = 1)
	@GeneratedValue(generator = "seq_user",strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 100,name = "name")
	private String name;
	
	@Column(length = 100,name = "surname")
	private String surname;
	
	@OneToMany
	@JoinColumn(name = "user_address_id")
	List<Address> addressList;
	
}
