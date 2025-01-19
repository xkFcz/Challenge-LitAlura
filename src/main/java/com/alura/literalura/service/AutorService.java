package com.alura.literalura.service;


import com.alura.literalura.model.Autor;
import com.alura.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // Lista todos los autores junto con sus libros.
    public List<Autor> listarAutores() {

        return autorRepository.findAllConLibros();
    }

    // Lista autores vivos en un año específico junto con sus libros
    public List<Autor> listarAutoresVivosEnAno(int ano) {

        return autorRepository.findAutoresVivosEnAnoConLibros(ano);
    }

    // Crea un nuevo autor.
    public Autor crearAutor(Autor autor) {

        return autorRepository.save(autor);
    }

    // Obtiene un autor por su ID
    public Optional<Autor> obtenerAutorPorId(Long id) {

        return autorRepository.findById(id);
    }

    // Obtiene un autor por su nombre.
    public Optional<Autor> obtenerAutorPorNombre(String nombre) {

        return autorRepository.findByNombre(nombre);
    }

    // Actualiza los detalles de un autor existente.
    public Autor actualizarAutor(Long id, Autor autorDetalles) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no Encontrado"));
        autor.setNombre(autorDetalles.getNombre());
        autor.setAnoNacimiento(autorDetalles.getAnoNacimiento());
        autor.setAnoFallecimiento(autorDetalles.getAnoFallecimiento());
        return autorRepository.save(autor);
    }

    // Elimina un autor por su ID.
    public void eliminarAutor(Long id) {

        autorRepository.deleteById(id);
    }
}
