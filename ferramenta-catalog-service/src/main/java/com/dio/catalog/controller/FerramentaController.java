package com.dio.catalog.controller;

import com.dio.catalog.model.Ferramenta;
import com.dio.catalog.service.FerramentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ferramentas")
public class FerramentaController {

    @Autowired
    private FerramentaService ferramentaService;

    // Endpoint para listar todas as ferramentas
    @GetMapping
    public List<Ferramenta> listarTodas() {
        return ferramentaService.listarTodas();
    }

    // Endpoint para criar uma nova ferramenta
    @PostMapping
    public ResponseEntity<Ferramenta> criarFerramenta(@RequestBody Ferramenta ferramenta) {
        try {
            Ferramenta novaFerramenta = ferramentaService.criarFerramenta(ferramenta);
            return ResponseEntity.ok(novaFerramenta);
        } catch (Exception e) {
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

    // Endpoint para buscar uma ferramenta pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Ferramenta> buscarPorId(@PathVariable Long id) {
        Optional<Ferramenta> ferramenta = ferramentaService.buscarPorId(id);
        return ferramenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para atualizar uma ferramenta existente
    @PutMapping("/{id}")
    public ResponseEntity<Ferramenta> atualizarFerramenta(@PathVariable Long id,
            @RequestBody Ferramenta detalhesFerramenta) {
        Optional<Ferramenta> ferramentaAtualizada = ferramentaService.atualizarFerramenta(id, detalhesFerramenta);
        return ferramentaAtualizada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para deletar uma ferramenta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFerramenta(@PathVariable Long id) {
        if (ferramentaService.deletarFerramenta(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
