package HealthcareApplicationPrototypeModels;

import java.time.LocalDateTime;

public class Appointment {
    private LocalDateTime dateTime;
    private Patient patient;
    private Doctor doctor;
    private Nurse nurse;

    public Appointment(LocalDateTime dateTime, Patient patient, Doctor doctor, Nurse nurse) {
        this.dateTime = dateTime;
        this.patient = patient;
        this.doctor = doctor;
        this.nurse = nurse;
    }

    public void schedule() {
        
    }

    public void cancel() {
        
    }
}
