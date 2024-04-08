import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Person
{
    private final String name;
    private final String surname;
    private final String patronymic;
    private String gender;
    private final String birthdate;

    private Integer age;

    Person(String name, String surname, String patronymic, String birthdate){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
    }

    public void GetInfo(){
        setAge();
        setGender();
        getInitials();
        System.out.println("Возраст: " + this.age);
        System.out.println("Пол: " + this.gender);
    }

    public void setAge(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date current = sdf.parse(birthdate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(current);

            Calendar today = Calendar.getInstance();

            int age = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);

            if (today.get(Calendar.DAY_OF_YEAR) < calendar.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }

            this.age = age;
        } catch (Exception e) {
            System.out.println("Неверный формат даты рождения");
            System.exit(0);
        }
    }

    public void getInitials() {
        if (name == null || surname == null || patronymic == null || name.isEmpty() || surname.isEmpty()) {
            System.out.println("Неверные данные");
            System.exit(0);
        }

        char nameInitial = name.charAt(0);
        char patronymicInitial = patronymic.isEmpty() ? ' ' : patronymic.charAt(0);

        System.out.println(surname + " " + nameInitial + ". " + patronymicInitial + ".");
    }

    public void setGender() {
        if (patronymic == null || patronymic.isEmpty()) {
            System.out.println("Неизвестно");
        }

        char lastLetter = patronymic.charAt(patronymic.length() - 1);

        if (lastLetter == 'ч') {
            this.gender = "Мужской";
        } else if (lastLetter == 'а') {
            this.gender = "Женский";
        } else {
            this.gender = "Неизвестно";
        }
    }
}
