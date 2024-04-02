package HealthcareApplicationPrototypeModels;

import java.util.List;
import java.util.ArrayList;


public class Nurse extends User {
    public Nurse(String username, String password) {
        super(username, password);
    }

    public void recordVitals(Patient patient, double weight, double height, double temperature, double bloodPressure) {
    	patient.viewMedicalRecords();
    }

    public void viewMedicalRecords(Patient patient) {
        patient.viewMedicalRecords();
    }

    public void viewAppointments(List<Appointment> appointments) { //Improve the relationship between sharing appointments

    }
}
