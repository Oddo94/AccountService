package account.service;

import account.exception.UserExistsException;
import account.model.entity.AppUser;
import account.model.request.UserSignupRequest;
import account.model.response.UserSignupResponse;
import account.repository.AppUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSignupService {
    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserSignupService(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity performUserSignup(UserSignupRequest signupRequest) {
        //Checks if there is an existing user that has the same email
        AppUser currentUser = userRepository.findAppUserByEmail(signupRequest.getEmail()).orElse(null);

        if (currentUser != null) {
            throw new UserExistsException();
        }

        AppUser newUser = new AppUser();
        newUser.setName(signupRequest.getName());
        newUser.setLastname(signupRequest.getLastname());
        newUser.setEmail(signupRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        AppUser savedUser = userRepository.save(newUser);

        UserSignupResponse signupResponse = new UserSignupResponse();

        if(savedUser != null) {
            signupResponse.setId(savedUser.getId());
            signupResponse.setName(savedUser.getName());
            signupResponse.setLastname(savedUser.getLastname());
            signupResponse.setEmail(savedUser.getEmail());

            return new ResponseEntity(signupResponse, HttpStatus.OK);
        }

        return new ResponseEntity(signupResponse, HttpStatus.BAD_REQUEST);
    }
}
