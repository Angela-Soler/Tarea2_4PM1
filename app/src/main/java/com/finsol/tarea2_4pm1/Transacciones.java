package com.finsol.tarea2_4pm1;

public class Transacciones {
    //Nombre de la Base de Datos
    public static final String NameDatabase = "PM2_4";

    /*Creacion de la base de Datos*/
    public static final String TablaImagenes = "imagenes";

    /*Creación de la tabla Imagenes*/
    public static final String id = "id";
    public static final String descripcion = "descripcion";
    public static final String image = "image";

    //DDL
    public static final String createTableImagenes = "CREATE TABLE "+Transacciones.TablaImagenes+
            " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "descripcion TEXT,"+
            "image BLOB)";

    public static final String GetImagenes = "SELECT * FROM "+Transacciones.TablaImagenes;

    public static final String DropTableImagenes = "DROP TABLE IF EXISTS Imagenes";

    public static final String DeleteRegistro = "DELETE FROM "+TablaImagenes;

}

