package com.edteam.restaurant_reservation.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean // Registrar el objeto en el contexto de Spring
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
