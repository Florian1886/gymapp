package pl.florian1886.gymapp.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        //  TODO:Regex To validate email
        return true;
    }
}
