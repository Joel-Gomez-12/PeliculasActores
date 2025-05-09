package es.uah.peliculasactores.controller;


import es.uah.peliculasactores.model.Pelicula;
import es.uah.peliculasactores.service.AzureBlobService;
import es.uah.peliculasactores.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@RestController
public class PeliculasController {

    @Autowired
    IPeliculasService peliculasService;

    @Autowired
    AzureBlobService azureBlobService;

    @GetMapping("/peliculas")
    public List<Pelicula> buscarTodas() {
        return peliculasService.buscarTodas();
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula buscarPeliculaPorId(@PathVariable("id") Integer id) {
        return peliculasService.buscarPeliculaPorId(id);
    }

    @GetMapping("/peliculas/titulo/{titulo}")
    public List<Pelicula> buscarPeliculasPorTitulo(@PathVariable("titulo") String titulo) {
        return peliculasService.buscarPeliculasPorTitulo(titulo);
    }

    @GetMapping("/peliculas/genero/{genero}")
    public List<Pelicula> buscarPeliculasPorGenero(@PathVariable("genero") String genero) {
        return peliculasService.buscarPeliculasPorGenero(genero);
    }

    @PostMapping("/guardar")
    public String guardarPelicula(Model model, Pelicula pelicula,
                                  @RequestParam("imagen") MultipartFile imagen,
                                  RedirectAttributes attributes) {
        if (!imagen.isEmpty()) {
            try {
                String url = azureBlobService.uploadFile(imagen);
                pelicula.setImagenPortada(url);
            } catch (IOException e) {
                e.printStackTrace();
                attributes.addFlashAttribute("msg", "Error al subir imagen");
                return "redirect:/ppeliculas/crear";
            }
        }

        peliculasService.guardarPelicula(pelicula);
        attributes.addFlashAttribute("msg", "Película guardada con imagen");
        return "redirect:/ppeliculas/listado";
    }

    @PutMapping("/peliculas")
    public void actualizarPelicula(@RequestBody Pelicula pelicula) {
        peliculasService.actualizarPelicula(pelicula);
    }

    @DeleteMapping("/peliculas/{id}")
    public void eliminarPelicula(@PathVariable("id") Integer id) {
        peliculasService.eliminarPelicula(id);
    }

}
