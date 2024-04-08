package rocks.zipcode.lambdas;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

import static rocks.zipcode.lambdas.Person.Gender.FEMALE;
import static rocks.zipcode.lambdas.Person.Gender.NONBINARY;
import static rocks.zipcode.lambdas.Person.printPersons;

public class LambdaTests {

    @Test
    public void validateAgeTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse@gmail.com";
        Person person1 = new Person(name, birthDate, gender, email);

        String name2 = "Juana";
        LocalDate birthDate2 = LocalDate.of(2000,3,7);
        Person.Gender gender2 = FEMALE;
        String email2 = "juana.gmail.com";
        Person person2 = new Person(name2, birthDate2, gender2, email2);

        printPersons(Person.getRoster(), (Person p) -> p.getAge() >= 18);
    }

    @Test
    public void validateGenderTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse@gmail.com";
        Person person = new Person(name, birthDate, gender, email);

        String name2 = "Juana";
        LocalDate birthDate2 = LocalDate.of(2000,3,7);
        Person.Gender gender2 = FEMALE;
        String email2 = "juana.gmail.com";
        Person person2 = new Person(name2, birthDate2, gender2, email2);

        printPersons(Person.getRoster(), (Person p)-> p.getGender().equals("Non-binary"));
    }

    @Test
    public void emailValidTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse@gmail.com";
        Person person = new Person(name, birthDate, gender, email);

        String name2 = "Juana";
        LocalDate birthDate2 = LocalDate.of(2000,3,7);
        Person.Gender gender2 = FEMALE;
        String email2 = "juana.gmail.com";
        Person person2 = new Person(name2, birthDate2, gender2, email2);

        Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
        printPersons(Person.getRoster(), (Person p) -> emailPattern.matcher(p.getEmailAddress()).matches());
    }

    @Test
    public void emailNoValidTest() {
        String name = "Jesse";
        LocalDate birthDate = LocalDate.of(1995,2,25);
        Person.Gender gender = NONBINARY;
        String email = "jesse@gmail.com";
        Person person = new Person(name, birthDate, gender, email);

        String name2 = "Juana";
        LocalDate birthDate2 = LocalDate.of(2000,3,7);
        Person.Gender gender2 = FEMALE;
        String email2 = "juana.gmail.com";
        Person person2 = new Person(name2, birthDate2, gender2, email2);

        Pattern emailPattern = Pattern.compile("^(.+)@(.+)?");
        printPersons(Person.getRoster(), (Person p) -> !emailPattern.matcher(p.getEmailAddress()).matches());
    }
}
