package rocks.zipcode.lambdas;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
public class Person {

    public enum Gender {
        MALE("Male"),
        FEMALE("Female"),
        NONBINARY("Non-binary");
        private final String text;

        Gender(final String text) {
            this.text = text;
        }
        public String getGender() {
            return text;
        }
    }

    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String emailAddress;
    private  static List<Person> roster = new ArrayList<>();

    public Person(String name, LocalDate birthday, Gender gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        roster.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender.text;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        if (birthday != null) {
            return Period.between(this.birthday, LocalDate.now()).getYears();
        }
        return 0;
    }

    public static List<Person> getRoster() {
        return roster;
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                System.out.println(p.toString());
            }
        }
    }
    @Override
    public String toString() {
        String person = String.format("Name: %s\nBirthDay: %s\nAge: %s\nGender: %s\nEmail: %s\n", name, birthday, this.getAge(), this.getGender(), emailAddress);
        return person;
    }

    static class validateAdult implements CheckPerson {
        @Override
        public boolean test(Person person) {
            if (person.getAge() >= 18)
                return true;

            return false;
        }
    }

    static class checkGender implements CheckPerson {

        @Override
        public boolean test(Person person) {
            if (person.getGender().equals("Male") || person.getGender().equals("Female") || person.getGender().equals("Non-binary"))
                return true;
            return false;
        }
    }
    static class checkEmail implements CheckPerson {

        @Override
        public boolean test(Person person) {
            String emailRegex = "^(.+)@(.+)$";
            Pattern emailPattern = Pattern.compile(emailRegex);

            try {
                if (emailPattern.matcher(person.emailAddress).matches())
                    return true;

            } catch (NullPointerException e) {
            }
            System.out.println("Email format must be:\n[username][@][domain]");
            return false;
        }
    }
}
