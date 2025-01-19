package com.alura.literalura.service;

public interface IConvierteDatos {

    // Convierte una cadena JSON en un objeto de la clase especificada.
    // json Cadena JSON a deserializar.
    // clase Clase del objeto a crear.
    // <T> Tipo del objeto a crear.
    // Objeto de la clase especificada.

    <T> T obtenerDatos(String Json, Class<T> clase);
}
