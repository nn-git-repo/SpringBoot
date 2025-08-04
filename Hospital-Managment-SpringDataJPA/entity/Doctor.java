package com.example.hospital.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String specialization;
	    private String email;
	    private String phone;

	    @OneToMany(mappedBy = "doctor")
	    private List<Appointment> appointments;

		public Doctor() {
			
		}

		public Doctor(Long id, String name, String specialization, String email, String phone,
				List<Appointment> appointments) {
		
			this.id = id;
			this.name = name;
			this.specialization = specialization;
			this.email = email;
			this.phone = phone;
			this.appointments = appointments;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSpecialization() {
			return specialization;
		}

		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public List<Appointment> getAppointments() {
			return appointments;
		}

		public void setAppointments(List<Appointment> appointments) {
			this.appointments = appointments;
		}
	    
	    
	    
}
