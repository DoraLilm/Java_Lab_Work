
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

    // Если фамилия отсутствует, берем ее у отца
    public String getFullSurname() {
        String surname = name.getSurname();

        if ((surname == null || surname.isEmpty()) && father != null) {
            return father.getFullSurname();
        }

        return surname;
    }

    @Override
    public String toString() {

        String surname = getFullSurname();
        String firstName = name.getFirstName();
        String patronymic = name.getPatronymic();

        // Если отчество отсутствует, формируем его из имени отца
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
