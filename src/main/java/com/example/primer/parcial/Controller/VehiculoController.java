package com.example.primer.parcial.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

//hola mundo, estoy modificando desde la rama dev
@RestController
@RequestMapping("/vehiculos")
@Tag(name = "Vehículos", description = "API para gestión de vehículos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @Operation(summary = "Listar todos los vehículos")
    @GetMapping
    public List<Vehiculo> obtenerTodos() {
        return vehiculoService.obtenerTodos();
    }

    @Operation(summary = "Filtrar vehículos por marca y/o año")
    @GetMapping("/filtrar")
    public List<Vehiculo> filtrar(
            @Parameter(description = "Marca del vehículo, ej: Toyota")
            @RequestParam(required = false) String marca,
            @Parameter(description = "Año de fabricación, ej: 2021")
            @RequestParam(required = false) Integer anio) {
        return vehiculoService.obtenerConFiltros(marca, anio);
    }

    @Operation(summary = "Agregar un nuevo vehículo")
    @PostMapping
    public Vehiculo agregar(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.agregar(vehiculo);
    }

    @Operation(summary = "Actualizar un vehículo por ID")
    @PutMapping("/{id}")
    public Vehiculo actualizar(
            @Parameter(description = "ID del vehículo a actualizar")
            @PathVariable Long id,
            @RequestBody Vehiculo vehiculo) {
        return vehiculoService.actualizar(id, vehiculo);
    }

    @Operation(summary = "Eliminar un vehículo por ID")
    @DeleteMapping("/{id}")
    public String eliminar(
            @Parameter(description = "ID del vehículo a eliminar")
            @PathVariable Long id) {
        boolean eliminado = vehiculoService.eliminar(id);
        return eliminado ? "Vehículo eliminado" : "Vehículo no encontrado";
    }
}