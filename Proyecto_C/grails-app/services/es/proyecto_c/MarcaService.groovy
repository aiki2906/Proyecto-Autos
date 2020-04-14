package es.proyecto_c

import grails.gorm.services.Service

@Service(Marca)
interface MarcaService {

    Marca get(Serializable id)

    List<Marca> list(Map args)

    Long count()

    void delete(Serializable id)

    Marca save(Marca marca)

}