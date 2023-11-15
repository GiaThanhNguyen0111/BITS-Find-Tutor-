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

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AppFilter.JwtAdapter jwtAdapter;

    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public AuthenticationResponseDTO register(AuthenticationRequestDTO request) {
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
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getEmail(),
//                        request.getPassword()
//                )
//        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        Map<String, String> map = new HashMap<>();
        map.put("role", request.getRole());
        Map<String, String> claims = new HashMap<>();
        claims.put("role", request.getRole());
        String jwtToken = jwtAdapter.generateToken(claims, user, user.getUserID());

        return AuthenticationResponseDTO.builder().accessToken(jwtToken).build();
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {

    }
}
