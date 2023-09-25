package com.palacio.sucursales.service;

import com.palacio.sucursales.model.Sucursal;
import com.palacio.sucursales.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> getAllSucursales () {
        return sucursalRepository.findAll();
    }

    public Sucursal saveSucursal (Sucursal sucursal) {
            return sucursalRepository.save(sucursal);
    }

    public ResponseEntity<Sucursal> deleteSucursal(Long id) {
        try {
            sucursalRepository.deleteById(id);
        } catch (Exception ex) {
            return (ResponseEntity<Sucursal>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public Optional<Sucursal> findSucursalById (Long id) {
        return sucursalRepository.findById(id);
    }
}
