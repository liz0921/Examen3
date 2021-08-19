package com.cenfotec.graphqlExamen.service;


import com.cenfotec.graphqlExamen.domain.Condominio;
import com.cenfotec.graphqlExamen.repositories.CondominioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CondominioServiceImpl implements CondominioService {

    @Autowired
    CondominioRepo condominioRepo;

    @Override
    public List<Condominio> getAll() {
        return condominioRepo.findAll();
    }

    @Override
    public List<Condominio> findtrue(Boolean estado) {
        return condominioRepo.findByEstado(true);

    }

    @Override
    public List<Condominio> findfalse(Boolean estado) {
        return condominioRepo.findByEstado(false);
    }


    @Override
    public Optional<Condominio> findById(long id) {
        return condominioRepo.findById(id);
                //.map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Condominio> save(Condominio contact) {
        return Optional.of(condominioRepo.save(contact));
    }

    @Override
    public Optional<Condominio> update(Condominio condominio) {
        Optional<Condominio> record = condominioRepo.findById(condominio.getId());
        if (record.isPresent()) {
            Condominio data = record.get();
            data.setCedulaJuri(condominio.getCedulaJuri());
            data.setCantidadUnidades(condominio.getCantidadUnidades());
            data.setCuotaCondominal(condominio.getCuotaCondominal());
            data.setDireccion(condominio.getDireccion());
            data.setRepresentante(condominio.getRepresentante());
            data.setNombre(condominio.getNombre());
            data.setDireccion(condominio.getDireccion());
            data.setEstado(condominio.getEstado());
            return Optional.of(condominioRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Condominio> desactivar(Condominio condominio) {
        Optional<Condominio> record = condominioRepo.findById(condominio.getId());
        if (record.isPresent()) {
            Condominio data = record.get();
            data.setEstado(condominio.getEstado());
            return Optional.of(condominioRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public Condominio create(String nombre, String direccion, String cedulaJuri, String representante, Boolean estado) {
        Condominio condominio= new Condominio();

        condominio.setNombre(nombre);
        condominio.setDireccion(direccion);
        condominio.setCedulaJuri(cedulaJuri);
        condominio.setRepresentante(representante);
        condominio.setEstado(estado);
        return this.condominioRepo.save(condominio);
    }

    @Override
    public List<Condominio> getAllCondominio(int count) {
        return this.condominioRepo.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        Optional<Condominio> result = condominioRepo.findById(id);
        if (result.isPresent()){
            condominioRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
