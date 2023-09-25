package com.palacio.sucursales.controller;

import com.palacio.sucursales.model.Sucursal;
import com.palacio.sucursales.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public List<Sucursal> getAllSucursales () {
        return sucursalService.getAllSucursales();
    }

    @GetMapping("/{id}")
    public Optional<Sucursal> findSucursalById (@PathVariable Long id) {
        return sucursalService.findSucursalById(id);
    }

    @PostMapping("/insert")
    public ResponseEntity<Sucursal> insertSucursal (@RequestBody Sucursal sucursal) {
            Sucursal sucursalTemporal = sucursalService.saveSucursal(sucursal);
            try {
                return ResponseEntity.created(new URI("/api/sucursales" + sucursalTemporal.getId())).body(sucursalTemporal);
            } catch (URISyntaxException ex) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Sucursal> updateSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        Sucursal sucursalTemporal = sucursalService.saveSucursal(sucursal);
        try {
            return ResponseEntity.ok(sucursalTemporal);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Sucursal> deleteSucursal (@PathVariable Long id) {
        return sucursalService.deleteSucursal(id);
    }
}
