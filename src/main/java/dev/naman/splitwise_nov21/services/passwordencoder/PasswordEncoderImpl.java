package dev.naman.splitwise_nov21.services.passwordencoder;

import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderImpl implements PasswordEncoder {

    @Override
    public String encode(String password) {
        return "Encoded" + password + "Done";
    }
}
