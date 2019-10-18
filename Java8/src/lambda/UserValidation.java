package lambda;

public class UserValidation {

    public static void main(String[] args) {

        UserValidator validator = (name, string) -> name.equalsIgnoreCase(string);

        System.out.println(validator.isValid("Ankit","ankit"));
        System.out.println(validator.isValid("ankit","kumar"));

    }
}
