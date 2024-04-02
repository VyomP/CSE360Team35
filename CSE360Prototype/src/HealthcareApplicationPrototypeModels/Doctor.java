package HealthcareApplicationPrototypeModels;

import java.util.List;
import java.util.ArrayList;

public class Doctor extends User {
    public Doctor(String username, String password) {
        super(username, password);
    }

    public void examinePatient(Patient patient) {
    }

    public void prescribeMedicine(Patient patient, String medication) {
    }

    public void viewMedicalRecords(Patient patient) {
    }

    public void viewAppointments(List<Appointment> appointments) {
    }

    public void messagePatient(Patient patient, String message) {
        
    }
}