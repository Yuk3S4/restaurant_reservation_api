package com.edteam.restaurant_reservation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
// Clase para proyectar los datos puntuales que regresaré al front en caso de error
@Data
@AllArgsConstructor
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;

}
