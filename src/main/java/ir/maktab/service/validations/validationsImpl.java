package ir.maktab.service.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validationsImpl implements Validations{


    @Override
    public boolean validatePassword(String password) {
        String regex ="^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(password);
        return matcher.matches();
    }
}
