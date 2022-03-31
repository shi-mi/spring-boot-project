package com.example.demo.model;

import javax.persistence.*;

	@Entity
	@Table(name = "department")
	public class Department {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long dept_id;
		@Column(name = "name")
		private String name;
		
		public Department() {
		}
		public Department(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public long getDept_id() {
			return dept_id;
		}
}
