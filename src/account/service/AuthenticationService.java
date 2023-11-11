package account.service;

import account.repository.AuthenticationRepository;
import account.request.UserSignupRequest;
import account.response.UserSignupResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private AuthenticationRepository authenticationRepository;

    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public ResponseEntity registerUser(UserSignupRequest userSignupRequest) {
        UserSignupResponse userSignupResponse = authenticationRepository.performUserRegistration(userSignupRequest);

        return new ResponseEntity(userSignupResponse, HttpStatus.OK);
    }
}
