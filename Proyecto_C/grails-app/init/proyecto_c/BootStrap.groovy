package proyecto_c

import Proyecto_C.security.Role
import Proyecto_C.security.User
import es.proyecto_c.Marca
import Proyecto_C.security.UserRole
import proyecto_c.EmailSenderController

class BootStrap {

    def init = { servletContext ->

        if (!Marca.get(1)) {
            5.times { marcaIndex ->
                Marca marca = new Marca(name: "Marca ${marcaIndex}")
                5.times { modeloIndex ->
                    marca.addToModelo(modelo: "Modelos ${marcaIndex} - ${modeloIndex}")
                }
                marca.save()
            }
        }
        User user = new User(username: 'admin', password: '1605').save()
        Role role = new Role(authority: 'ROLE_ADMIN').save()
        UserRole.create(user, role)
    }
    def destroy = {
    }
}
