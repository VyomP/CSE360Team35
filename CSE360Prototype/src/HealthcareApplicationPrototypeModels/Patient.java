package HealthcareApplicationPrototypeModels;

import java.util.List;
import java.util.ArrayList;

public class Patient extends User {
    private MedicalRecords medicalRecords;
    private List<Appointment> appointments;
    private MessagingSystem messagingSystem;

    public Patient(String username, String password) {
        super(username, password);
        this.medicalRecords = new MedicalRecords();
        this.appointments = new ArrayList<>();
        this.messagingSystem = new MessagingSystem();
    }

    public void viewSummary() {
        //Need to load the patient values first then loop through to get summarized data
    }

    public void viewMedicalRecords() {
        medicalRecords.getHistory();
    }

    public void modifyAppointments() {
        // Implement logic to view patient appointments
    }
    
    

    public void messageDoctor(String message) {
        messagingSystem.sendMessage(message, "Doctor");
    }
}
