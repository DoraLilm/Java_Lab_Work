package Laba2;

public class Name {

    private String surname;
    private String firstName;
    private String patronymic;

    public Name(String surname, String firstName, String patronymic) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        String result = "";

        if (surname != null && !surname.isEmpty()) {
            result += surname + " ";
        }

        if (firstName != null && !firstName.isEmpty()) {
            result += firstName + " ";
        }

        if (patronymic != null && !patronymic.isEmpty()) {
            result += patronymic;
        }

        return result.trim();
    }
}