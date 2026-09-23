package Laba2;

public class Person {

    private Name name;
    private int height;
    private Person father;

    public Person(Name name, int height) {
        this.name = name;
        this.height = height;
        this.father = null;
    }

    public Person(Name name, int height, Person father) {
        this.name = name;
        this.height = height;
        this.father = father;
    }

    public Name getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public Person getFather() {
        return father;
    }

    @Override
    public String toString() {

        String surname = name.getSurname();
        String firstName = name.getFirstName();
        String patronymic = name.getPatronymic();

        if ((surname == null || surname.isEmpty()) && father != null) {
            surname = father.name.getSurname();
        }

        if ((patronymic == null || patronymic.isEmpty()) && father != null) {
            String fatherFirstName = father.name.getFirstName();

            if (fatherFirstName != null && !fatherFirstName.isEmpty()) {
                patronymic = fatherFirstName + "ович";
            }
        }

        Name fullName = new Name(
                surname,
                firstName,
                patronymic
        );

        return fullName + ", рост: " + height;
    }
}
