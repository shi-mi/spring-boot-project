package com.example.demo.model;

import javax.persistence.*;

	@Entity
	@Table(name = "employee")
	public class Employee {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long emp_id;
		@Column(name = "first_name")
		private String firstName;
		@Column(name = "last_name")
		private String lastName;
		
		public Employee() {
		}
		public Employee(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public long getEmp_id() {
			return emp_id;
		}
}
