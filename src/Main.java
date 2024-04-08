import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name, surname, patronymic, birthDate;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        name = scanner.nextLine();
        if(name == null || name.isEmpty()){
            System.out.println("Поле должно быть заполнено");
            System.exit(0);
        }

        System.out.print("Введите фамилию: ");
        surname = scanner.nextLine();
        if(surname == null || surname.isEmpty()){
            System.out.println("Поле должно быть заполнено");
            System.exit(0);
        }

        System.out.print("Введите отчество: ");
        patronymic = scanner.nextLine();

        System.out.print("Введите дату рождения (ДД:ММ:ГГГГ): ");
        birthDate = scanner.nextLine();
        if(birthDate == null ||  birthDate.isEmpty()){
            System.out.println("Поле должно быть заполнено");
            System.exit(0);
        }

        scanner.close();

        Person person = new Person(name, surname, patronymic, birthDate);
        System.out.println();
        person.GetInfo();
    }
}