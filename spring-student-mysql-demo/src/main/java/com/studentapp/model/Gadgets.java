package com.studentapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Gadgets {
	@Id
	private Integer gadgetId;
	private String gadgetName;
	private String gadgetmodel;
}
