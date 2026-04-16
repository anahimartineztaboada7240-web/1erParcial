package com.example.primer.parcial.Controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService {

    private List<Vehiculo> vehiculos = new ArrayList<>(List.of(
            new Vehiculo(1L, "Toyota",   "Corolla",  2020, "ABC-123", "Blanco"),
            new Vehiculo(2L, "Ford",     "Mustang",  2019, "XYZ-789", "Rojo"),
            new Vehiculo(3L, "Chevrolet","Spark",    2022, "DEF-456", "Azul"),
            new Vehiculo(4L, "Honda",    "Civic",    2021, "GHI-321", "Negro"),
            new Vehiculo(5L, "Nissan",   "Frontier", 2018, "JKL-654", "Gris")
    ));

    public List<Vehiculo> obtenerTodos() {
        return vehiculos;
    }

    public List<Vehiculo> obtenerConFiltros(String marca, Integer anio) {
        return vehiculos.stream()
                .filter(v -> marca == null || v.getMarca().equalsIgnoreCase(marca))
                .filter(v -> anio == null || v.getAnio() == anio)
                .collect(Collectors.toList());
    }

    public Vehiculo agregar(Vehiculo vehiculo) {
        vehiculo.setId((long) (vehiculos.size() + 1));
        vehiculos.add(vehiculo);
        return vehiculo;
    }

    public Vehiculo actualizar(Long id, Vehiculo vehiculoActualizado) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getId().equals(id)) {
                vehiculoActualizado.setId(id);
                vehiculos.set(i, vehiculoActualizado);
                return vehiculoActualizado;
            }
        }
        return null;
    }

    public boolean eliminar(Long id) {
        return vehiculos.removeIf(v -> v.getId().equals(id));
    }
}