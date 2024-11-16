package com.globalsolution2.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalsolution2.fiap.model.UsuarioRespostaModel;
import com.globalsolution2.fiap.repository.UsuarioRespostaRepository;

@Service
public class UsuarioRespostaService {

    @Autowired
    private UsuarioRespostaRepository usuarioRespostaRepository;

    public UsuarioRespostaModel createUsuarioResposta(UsuarioRespostaModel usuarioResposta) {
        return usuarioRespostaRepository.save(usuarioResposta);
    }

    public List<UsuarioRespostaModel> createUsuarioRespostas(List<UsuarioRespostaModel> usuarioRespostas) {
        return usuarioRespostaRepository.saveAll(usuarioRespostas);
    }

    public List<UsuarioRespostaModel> getAllUsuarioRespostas() {
        return usuarioRespostaRepository.findAll();
    }

    public Optional<UsuarioRespostaModel> getUsuarioRespostaById(Long id) {
        return usuarioRespostaRepository.findById(id);
    }

    public Optional<UsuarioRespostaModel> updateUsuarioResposta(Long id, UsuarioRespostaModel usuarioRespostaDetails) {
        return usuarioRespostaRepository.findById(id).map(usuarioResposta -> {
            usuarioResposta.setStResultado(usuarioRespostaDetails.isStResultado());
            return usuarioRespostaRepository.save(usuarioResposta);
        });
    }

    public boolean deleteUsuarioResposta(Long id) {
        return usuarioRespostaRepository.findById(id).map(usuarioResposta -> {
            usuarioRespostaRepository.delete(usuarioResposta);
            return true;
        }).orElse(false);
    }
}