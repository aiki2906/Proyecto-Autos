package es.proyecto_c

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ModelosServiceSpec extends Specification {

    ModelosService modelosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Modelos(...).save(flush: true, failOnError: true)
        //new Modelos(...).save(flush: true, failOnError: true)
        //Modelos modelos = new Modelos(...).save(flush: true, failOnError: true)
        //new Modelos(...).save(flush: true, failOnError: true)
        //new Modelos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //modelos.id
    }

    void "test get"() {
        setupData()

        expect:
        modelosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Modelos> modelosList = modelosService.list(max: 2, offset: 2)

        then:
        modelosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        modelosService.count() == 5
    }

    void "test delete"() {
        Long modelosId = setupData()

        expect:
        modelosService.count() == 5

        when:
        modelosService.delete(modelosId)
        sessionFactory.currentSession.flush()

        then:
        modelosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Modelos modelos = new Modelos()
        modelosService.save(modelos)

        then:
        modelos.id != null
    }
}
