package ir.maktab.service.validations;

public interface Validations {

    boolean validatePassword(String password) throws Exception;

    boolean validateEmail(String email) throws Exception;

    boolean validateName(String name) throws Exception;

    boolean validateUsername(String username) throws Exception;
}
