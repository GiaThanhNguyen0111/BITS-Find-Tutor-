package com.group01.bits.service.impl;

import com.group01.bits.appfilter.AppFilter;
import com.group01.bits.dto.AuthenticationRequestDTO;
import com.group01.bits.dto.AuthenticationResponseDTO;
import com.group01.bits.entity.User;
import com.group01.bits.repository.UserRepository;
import com.group01.bits.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AppFilter.JwtAdapter jwtAdapter;

    private final AuthenticationManager authenticationManager;

    private static final String REGEX_CHECK_EMAIL = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    private static final String REGEX_CHECK_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    @Override
    @Transactional
    public AuthenticationResponseDTO register(AuthenticationRequestDTO request) throws Exception {
        if(isExisted(request.getEmail())) {
            log.info("===== Email {} is existed =====", request.getEmail());
            throw new Exception("Email is existed");
        }
        if (!checkEmail(request.getEmail())) {
            log.info("====== Email {} is invalid =====", request.getEmail());
            throw new Exception("Email is invalid");
        }
        if(!checkPassword(request.getPassword())) {
            log.info("======= Password {} is invalid =====", request.getPassword());
            throw new Exception("Password is invalid");
        }
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        User userAccount = userRepository.findByEmail(request.getEmail()).orElseThrow();
        Long userAccountID = userAccount.getUserID();
        Map<String, String> claims = new HashMap<>();
        claims.put("role", request.getRole());
        String jwtToken = jwtAdapter.generateToken(claims, user, userAccountID);
        return AuthenticationResponseDTO.builder().accessToken(jwtToken).build();
    }

    @Override
    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            log.info("===Exception=== {}", e.getMessage());
        }
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        Map<String, String> map = new HashMap<>();
        map.put("role", user.getRole());
        Map<String, String> claims = new HashMap<>();
        claims.put("role", request.getRole());
        String jwtToken = jwtAdapter.generateToken(claims, user, user.getUserID());

        return AuthenticationResponseDTO.builder().accessToken(jwtToken).build();
    }

    private boolean isExisted(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()) {
            return true;
        }
        return false;
    }

    private boolean checkEmail(String email) {
        return Pattern.compile(REGEX_CHECK_EMAIL)
                .matcher(email)
                .matches();
    }

    private boolean checkPassword(String password) {
        return Pattern.compile(REGEX_CHECK_PASSWORD)
                .matcher(password)
                .matches();
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {

    }
}
