package com.example.primer.parcial.Controller;

public class Vehiculo {

    private Long id;
    private String marca;
    private String modelo;
    private int anio;
    private String placa;
    private String color;

    public Vehiculo() {}

    public Vehiculo(Long id, String marca, String modelo, int anio, String placa, String color) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.placa = placa;
        this.color = color;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}