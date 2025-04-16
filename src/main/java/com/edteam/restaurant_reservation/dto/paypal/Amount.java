package com.edteam.restaurant_reservation.dto.paypal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Amount {
    @JsonProperty("currency_code") // Definir el cómo debe aparecer la propiedad en formato json
    private String currencyCode;
    private String value;
}
