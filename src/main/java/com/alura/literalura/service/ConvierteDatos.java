package com.alura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvierteDatos implements IConvierteDatos{

    private ObjectMapper objectMapper = new ObjectMapper();

    // Convierte una cadena JSON en un objeto de la clase especificada.
    // json Cadena JSON a deserializar.
    // clase Clase del objeto a crear.
    // <T> Tipo del objeto a crear.
    // Objeto de la clase especificada.
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al deserializar el JSON", e);
        }
    }
}
