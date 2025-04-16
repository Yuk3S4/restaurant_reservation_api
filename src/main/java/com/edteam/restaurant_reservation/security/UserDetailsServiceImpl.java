package com.edteam.restaurant_reservation.security;

import com.edteam.restaurant_reservation.domain.entity.User;
import com.edteam.restaurant_reservation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override // * En un proceso de inicio de sesión carga la info del user por el username en la entity User de Spring Security
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findOneByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username)); // <- SI no lo encuentra

        // Devuelve los detalles del usuario para Spring Security, incluyendo nombre de usuario, contraseña y roles.
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
        }
}