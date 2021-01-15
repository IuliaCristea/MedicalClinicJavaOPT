package MedicalClinic.MedicalClinic.utils;

public enum Specialty {
    AllergyImmunology,
    Anesthesiology,
    Dermatology,
    DiagnosticRadiology,
    EmergencyMedicine,
    FamilyMedicine,
    InternalMedicine,
    MedicalGenetics,
    Neurology,
    NuclearMedicine,
    ObstetricsGynecology,
    Ophthalmology,
    Pathology,
    Pediatrics,
    PhysicalMedicineRehabilitation,
    PreventiveMedicine,
    Psychiatry,
    RadiationOncology,
    Surgery,
    Urology;

    public static boolean isValid(String specialty)
    {
        for(Specialty s : Specialty.values())
        {
            if(s.name().equals(specialty))
            {
                return true;
            }
        }
        return false;
    }


}