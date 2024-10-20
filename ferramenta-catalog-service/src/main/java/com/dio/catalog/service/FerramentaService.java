package com.dio.catalog.service;

import com.dio.catalog.model.Ferramenta;
import com.dio.catalog.repository.FerramentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FerramentaService {

    @Autowired
    private FerramentaRepository ferramentaRepository;

    // Retorna todas as ferramentas
    public List<Ferramenta> listarTodas() {
        return ferramentaRepository.findAll();
    }

    // Cria uma nova ferramenta
    public Ferramenta criarFerramenta(Ferramenta ferramenta) {
        return ferramentaRepository.save(ferramenta);
    }

    // Busca uma ferramenta pelo ID
    public Optional<Ferramenta> buscarPorId(Long id) {
        return ferramentaRepository.findById(id);
    }

    // Atualiza uma ferramenta existente
    public Optional<Ferramenta> atualizarFerramenta(Long id, Ferramenta detalhesFerramenta) {
        return ferramentaRepository.findById(id).map(ferramenta -> {
            ferramenta.setNome(detalhesFerramenta.getNome());
            ferramenta.setDescricao(detalhesFerramenta.getDescricao());
            ferramenta.setEstado(detalhesFerramenta.getEstado());
            ferramenta.setCategoria(detalhesFerramenta.getCategoria());
            return ferramentaRepository.save(ferramenta);
        });
    }

    // Deleta uma ferramenta pelo ID
    public boolean deletarFerramenta(Long id) {
        Optional<Ferramenta> ferramenta = ferramentaRepository.findById(id);
        if (ferramenta.isPresent()) {
            ferramentaRepository.delete(ferramenta.get());
            return true;
        }
        return false;
    }
}
