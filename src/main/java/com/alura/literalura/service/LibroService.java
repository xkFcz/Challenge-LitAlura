package com.alura.literalura.service;


import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // Lista todos los libros.
    public List<Libro> listarLibros() {

        return libroRepository.findAll();
    }

    // Lista libros por su idioma
    public List<Libro> listarLibrosPorIdioma(String idioma) {

        return libroRepository.findByIdioma(idioma);
    }

    // Crea un nuevo libro.
    public Libro crearLibro(Libro libro) {

        return libroRepository.save(libro);
    }

    // Obtiene un libro por su ID.
    public Optional<Libro> obtenerLibroPorId(Long id) {

        return libroRepository.findById(id);
    }

    // Obtiene un libro por su título, ignorando mayúsculas y minúsculas.
    public Optional<Libro> obtenerLibroPorTitulo(String titulo) {
        return libroRepository.findByTituloIgnoreCase(titulo);
    }

    // Actualiza los detalles de un libro existente.
    public Libro aactualizarLibro(Long id, Libro libroDetalles) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        libro.setTitulo(libroDetalles.getTitulo());
        libro.setIdioma(libroDetalles.getIdioma());
        libro.setNumeroDescargas(libroDetalles.getNumeroDescargas());
        libro.setAutor(libroDetalles.getAutor());
        return libroRepository.save(libro);
    }

    // Elimina un libro por su ID.
    public void eliminarLibro(Long id) {

        libroRepository.deleteById(id);
    }

}
