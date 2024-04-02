package HealthcareApplicationPrototypeModels;

public class Receptionist extends User {
    public Receptionist(String username, String password) {
        super(username, password);
    }

    public void checkInPatient(Patient patient) {
        // Implement logic to check in a patient
    }

    public void scheduleAppointment(Patient patient, Appointment appointment) {
        patient.modifyAppointments();
    }
}
