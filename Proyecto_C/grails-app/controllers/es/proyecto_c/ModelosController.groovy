package es.proyecto_c

import grails.gsp.PageRenderer
import grails.plugin.springsecurity.annotation.Secured
import grails.plugins.mail.MailService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured('ROLE_ADMIN')
class ModelosController {

    ModelosService modelosService

    PageRenderer groovyPageRenderer
    MailService mailService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond modelosService.list(params), model:[modelosCount: modelosService.count()]
    }

    def show(Long id) {
        respond modelosService.get(id)
    }

    def create() {
        respond new Modelos(params)
    }

    def save(Modelos modelos) {
        if (modelos == null) {
            notFound()
            return
        }

        try {
            modelosService.save(modelos)
        } catch (ValidationException e) {
            respond modelos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'modelos.label', default: 'Modelos'), modelos.id])
                redirect modelos
            }
            '*' { respond modelos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond modelosService.get(id)
    }

    def update(Modelos modelos) {
        if (modelos == null) {
            notFound()
            return
        }

        try {
            modelosService.save(modelos)
        } catch (ValidationException e) {
            respond modelos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'modelos.label', default: 'Modelos'), modelos.id])
                redirect modelos
            }
            '*'{ respond modelos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        modelosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'modelos.label', default: 'Modelos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def crearPresupuesto(Long id)  {
        println params
        Modelos modelo = modelosService.get(id)
        println modelo
        render view:'crearPresupuesto', model:[modelo: modelo]
    }

    def enviarPresupuesto(Long id)  {
        Modelos modelo = modelosService.get(id)

        String title = "Presupuesto de $modelo.modelo"
        mailService.sendMail {
            to params.email
            subject title
            html groovyPageRenderer.render(template: 'presupuesto', model: [modelo: modelo])
        }

        flash.message = "Message sent at "+new Date()
        redirect action:"show", id:id
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'modelos.label', default: 'Modelos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
