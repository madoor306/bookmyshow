package com.bookmyshow.app.models;

import com.bookmyshow.app.exception.validation.InvalidUserNameException;
import com.bookmyshow.app.service.utils.PasswordEncoder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class User extends Auditable {

    //authentication
    private String userName;
    private String hashedSaltedPassword;

    //authorization
    private Set<Role> roles;

    public void setUserName(String userName) throws InvalidUserNameException {

        if(userName.length() < 2) {
            throw new InvalidUserNameException("Must have at least 3 letters");
        }
        this.userName = userName;
    }

    public boolean checkPassword(String password, PasswordEncoder passwordEncoder) {

        // passwordEncoder is a dependency  that we need
        String encoded = passwordEncoder.encode(password);
        return encoded.equals(this.getHashedSaltedPassword());
    }
}
