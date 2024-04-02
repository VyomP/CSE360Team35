package HealthcareApplicationPrototypeModels;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecords {
    private List<Entry> entries;

    public MedicalRecords() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public void getHistory() {

    }

    private abstract class Entry {
        private String timestamp;

    }

    private class VitalsEntry extends Entry {
        private double weight;
        private double height;
        private double temperature;
        private double bloodPressure;

        public VitalsEntry(double weight, double height, double temperature, double bloodPressure) {
            this.weight = weight;
            this.height = height;
            this.temperature = temperature;
            this.bloodPressure = bloodPressure;
        }
    }

    private class MedicationEntry extends Entry {
        private String medication;

        public MedicationEntry(String medication) {
            this.medication = medication;
        }
    }
}