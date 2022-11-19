package com.finsol.tarea2_4pm1;

public class Imagenes {
    public Integer id;
    public String descripcion;
    public String image;

    //Constructor de la clase
    public Imagenes(){
        //Todo
    }

    public Imagenes(Integer id, String descripcion, String image) {
        this.id = id;
        this.descripcion = descripcion;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
