package com.example.proyecto.lenguajes.services.impl;

import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.stereotype.Service;

import com.example.proyecto.lenguajes.modelos.Orden;
import com.example.proyecto.lenguajes.modelos.Repartidor;
import com.example.proyecto.lenguajes.repositories.RepartidorRepository;
import com.example.proyecto.lenguajes.services.RepartidorService;

@Service
public class RepartidorServiceImpl implements RepartidorService {

    private RepartidorRepository repartidorRepository;

    @Override
    public Repartidor crearRepartidor(Repartidor repartidor) {
        return repartidorRepository.save(repartidor);
    }

    @Override
    public Repartidor obtenerRepartidorPorId(Integer id) {
        return repartidorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Repartidor no encontrado"));
    }

    @Override
    public List<Repartidor> obtenerTodosLosRepartidores() {
        return repartidorRepository.findAll();
    }

    @Override
    public void eliminarRepartidor(Integer id) {
        repartidorRepository.deleteById(id);
    }

    @Override
    public Repartidor asignarOrden(Integer id, Orden orden) {
      Repartidor repartidor = obtenerRepartidorPorId(id);
        orden.setRepartidor(repartidor);;
        repartidor.getOrdenes().add(orden);
        repartidorRepository.save(repartidor);
        return repartidor;
    }

    @Override
    public List<Orden> findOrdenesById(Integer id) {
        return repartidorRepository.findOrdenesById(id);
    }

}
