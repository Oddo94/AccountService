package account.repository;

import account.request.UserSignupRequest;
import account.response.UserSignupResponse;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationRepository {

    public UserSignupResponse performUserRegistration(UserSignupRequest userSignupRequest) {
        UserSignupResponse userSignupResponse = new UserSignupResponse();
        userSignupResponse.setName(userSignupRequest.getName());
        userSignupResponse.setLastname(userSignupRequest.getLastname());
        userSignupResponse.setEmail(userSignupRequest.getEmail());

        return userSignupResponse;

    }
}
