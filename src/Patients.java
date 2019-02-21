public class Patients {
    Patient [] patients;

    //устанавливаем размер массива пациентов
    public void setPatients (int num){
        patients = new Patient [num];
    }

    public void getPatients (){
        for (int i =0; i<patients.length; i++){
            Patient newPatient = new Patient();
            newPatient.printIn();
            patients [i] = newPatient;
        }
    }
}
