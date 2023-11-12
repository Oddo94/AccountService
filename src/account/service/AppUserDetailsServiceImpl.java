package account.service;

import account.model.entity.AppUser;
import account.repository.AppUserRepository;
import account.utils.AppUserAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository userRepository;

    public AppUserDetailsServiceImpl(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AppUser user = userRepository
//                .findAppUserByName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("The requested user could not be found!"));
//
//        return new AppUserAdapter(user);
//    }

    //CHANGE!!
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = userRepository
                .findAppUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("The requested user could not be found!"));

        return new AppUserAdapter(user);
    }

    public AppUser getUserByEmail(String email) throws UsernameNotFoundException {
        AppUser user = userRepository.findAppUserByEmail(email).orElse(null);

        return user;
    }
}
