package in.upcode.demojsonxml.model;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class TempUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        switch(username){
            case "afsal":
                return new User("afsal","afsal123", new ArrayList<>());
            case "hisham":
                return new User("hisham","hisham123", new ArrayList<>());

        }
        return null;
    }
}
