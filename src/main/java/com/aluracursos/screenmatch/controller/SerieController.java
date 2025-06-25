package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@RestController
public class SerieController {
    @Autowired
    private SerieRepository serieRepository;
    @GetMapping("/series")
    public List<SerieDTO> obtenerTodasLasSeries(){
        return serieRepository.findAll().stream()
                .map(serie -> new SerieDTO(
                        serie.getTitulo(),
                        serie.getTotalTemporadas(),
                        serie.getEvaluacion(),
                        serie.getPoster(),
                        serie.getGenero(),
                        serie.getActores(),
                        serie.getSinopsis()))
                .toList();

    }
}
