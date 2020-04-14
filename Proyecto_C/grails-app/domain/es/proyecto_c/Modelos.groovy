package es.proyecto_c

class Modelos {
    String modelo
    String tipo
    Double precio

    static belongsTo = [name: Marca]

    static constraints = {
        modelo nullable: true
        tipo nullable: true
        precio nullable: true
    }

    String toString(){
        modelo
    }
}
