package es.proyecto_c

class Marca {
    String name
    String calidad
    static hasMany = [modelo: Modelos]

    String toString(){
        name
    }

}
