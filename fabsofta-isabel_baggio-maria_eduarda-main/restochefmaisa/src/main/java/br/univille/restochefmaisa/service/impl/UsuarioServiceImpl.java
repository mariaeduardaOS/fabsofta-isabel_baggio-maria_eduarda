package br.univille.restochefmaisa.service.impl;

import br.univille.restochefmaisa.entity.Usuario;
import br.univille.restochefmaisa.repository.UsuarioRepository;
import br.univille.restochefmaisa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public Usuario getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}