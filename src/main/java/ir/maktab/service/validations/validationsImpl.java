package ir.maktab.service.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class validationsImpl implements Validations{
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$");
    private static final Pattern VALID_FULL_NAME_REGEX =  Pattern.compile("^[a-zA-Z\\s]+");
    private static final Pattern VALID_USERNAME_REGEX =  Pattern.compile("[a-zA-Z0-9\\._\\-]{3,}");


    @Override
    public boolean validatePassword(String password) throws Exception {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        if (matcher.matches())
            return true;
        else
            throw new Exception("Password id too weak.");
    }
    @Override
    public boolean validateEmail(String email) throws Exception {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (matcher.matches())
            return true;
        else
            throw new Exception("Wrong email format.");
    }
    @Override
    public boolean validateName(String name) throws Exception {
        Matcher matcher = VALID_FULL_NAME_REGEX.matcher(name);
        if (matcher.matches())
            return true;
        else
            throw new Exception("Wrong name format");
    }
    @Override
    public boolean validateUsername(String username) throws Exception {
        Matcher matcher = VALID_USERNAME_REGEX.matcher(username);
        if (matcher.matches())
            return true;
        else
            throw new Exception("The password must be at least 3 characters and a combination of letters and numbers.");
    }
}
