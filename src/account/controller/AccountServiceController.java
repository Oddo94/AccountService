package account.controller;

import account.request.UserSignupRequest;
import account.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class AccountServiceController {

    private AuthenticationService authenticationService;

    public AccountServiceController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/auth/signup")
    public ResponseEntity registerUser(@Valid @RequestBody UserSignupRequest userSignupRequest) {
        //return new ResponseEntity("Access to '/auth/signup' endpoint granted!", HttpStatus.OK);
        return authenticationService.registerUser(userSignupRequest);
    }

    @PostMapping("/auth/changepass")
    public ResponseEntity changePassword() {
        return new ResponseEntity("Access to '/auth/changepass' endpoint granted!", HttpStatus.OK);
    }

    @GetMapping("/empl/payment")
    public ResponseEntity displayUserPayrolls() {
        return new ResponseEntity("Access to '/empl/payment' endpoint granted!", HttpStatus.OK);
    }

    @PostMapping("/acct/payments")
    public ResponseEntity uploadPayroll() {
        return new ResponseEntity("Access to '/acct/payments' endpoint granted!", HttpStatus.OK);
    }

    @PutMapping("/acct/payments")
    public ResponseEntity updatePayment() {
        return new ResponseEntity("Access to '/acct/payments' endpoint granted!", HttpStatus.OK);
    }

    @PutMapping("/admin/user/role")
    public ResponseEntity changeUserRole() {
        return new ResponseEntity("Access to '/admin/user/role endpoint granted!", HttpStatus.OK);
    }

    @DeleteMapping("/admin/user")
    public ResponseEntity deleteUser() {
        return new ResponseEntity("Access to DELETE '/admin/user' endpoint granted!", HttpStatus.OK);
    }

    @GetMapping("/admin/user")
    public ResponseEntity getUserData() {
        return new ResponseEntity("Access to GET '/admin/user' endpoint granted!", HttpStatus.OK);
    }
}
