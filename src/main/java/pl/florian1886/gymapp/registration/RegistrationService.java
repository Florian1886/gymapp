package pl.florian1886.gymapp.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.florian1886.gymapp.appuser.AppUser;
import pl.florian1886.gymapp.appuser.AppUserRole;
import pl.florian1886.gymapp.appuser.AppUserService;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException("email is not valid");
        }

        return appUserService.singUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );


    }
}
