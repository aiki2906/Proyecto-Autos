package es.proyecto_c

class Marca {
    String name
    static hasMany = [modelo: Modelos]

    String toString(){
        name
    }

}
