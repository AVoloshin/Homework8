import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;


public class Patient {
    protected String name;
    protected String year;
    protected Date fullDate;
    protected String dataF;
    protected LocalDate today;
    protected LocalDate birthday;
    protected Period age;
    Patient [] patients;

    //устанавливаем размер массива пациентов
    public void setPatients (int num){
        patients = new Patient [num];
    }
    //получаем данные из консоли ввода
    public void printIn() {
        Scanner fio = new Scanner(System.in);
        System.out.println("Введите ФИО пациента");
        name = fio.nextLine();
        Scanner years = new Scanner(System.in);
        System.out.println("Введите дату рождения (в формате 01.01.1970)");
        year = years.nextLine();
        SimpleDateFormat birthday = new SimpleDateFormat();
        birthday.applyPattern("dd.MM.yyyy"); //задаем формат даты
        try {
            fullDate = birthday.parse(year); //считываем дату из строки и записываем в поле Date
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dataF = birthday.format(fullDate); //записываем поле Date в строку для работы с методами java.time
    }


    public void getAge (){
        today= LocalDate.now(); //текущая дата
        DateTimeFormatter dateFormatter  = DateTimeFormatter.ofPattern("dd.MM.yyyy"); //устанавливаем формат даты для чтения из строки
        birthday = LocalDate.parse(dataF, dateFormatter); //дата рождения
        age = today.until(birthday); //разница между датами - возраст
        System.out.println("Возраст "+age.getYears()+" лет"+age.getMonths()+" мес");//получаем года и месяцы
    }
    //заполняем массив пациентами-объектами
    public void getPatients (){
        for (int i =0; i<3; i++){
            Patient newPatient = new Patient();
            newPatient.printIn();
            patients [i] = newPatient;
        }
    }
    //проходим по массиву объектов, получаем int годов месяцев и тд, выводим среднее значение
    public void getMidAge (){
        int ages = 0; int months = 0;
        for (Patient patient: patients){
            patient.getAge();
            ages += patient.age.getYears();
            months += patient.age.getMonths();
        }
        System.out.println("Средний возраст пациентов равен "+ ages/patients.length +" лет"+ months/patients.length +" мес");
    }
    public boolean isExists (){
        return (new File("patients.txt").exists());
    }
    public void readFile (){
        if (this.isExists()){
            try (FileReader fileRead = new FileReader("patient.txt")){
                int c;
                while((c=fileRead.read())!=-1){

                    System.out.print((char)c);
                }
                System.out.print("\n");
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }else this.printIn();
    }
}
