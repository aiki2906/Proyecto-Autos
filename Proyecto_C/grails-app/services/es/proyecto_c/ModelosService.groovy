package es.proyecto_c

import grails.gorm.services.Service

@Service(Modelos)
interface ModelosService {

    Modelos get(Serializable id)

    List<Modelos> list(Map args)

    Long count()

    void delete(Serializable id)

    Modelos save(Modelos modelos)

}