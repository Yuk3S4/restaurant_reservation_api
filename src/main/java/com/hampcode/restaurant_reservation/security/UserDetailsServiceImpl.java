package com.hampcode.restaurant_reservation.security;

import com.hampcode.restaurant_reservation.domain.entity.User;
import com.hampcode.restaurant_reservation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Busca al usuario en la base de datos por correo electrónico y lanza una excepción si no se encuentra.
    User user = userRepository
      .findOneByEmail(username)
      .orElseThrow(() -> new UsernameNotFoundException(username));

    // Devuelve los detalles del usuario para Spring Security, incluyendo nombre de usuario, contraseña y roles.
    return org.springframework.security.core.userdetails.User
      .withUsername(user.getEmail())
      .password(user.getPassword())
      .roles(user.getRole().name())
      .build();
  }

}
