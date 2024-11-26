package provatest;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear instancias de los managers
        UserManager userManager = new UserManager();
        EmpresaManager empresaManager = new EmpresaManager();

        // Crear usuarios
        User user1 = new User("Juan Perez", "juan@correo.com", "contraseña123");
        User user2 = new User("Maria Gomez", "maria@correo.com", "contraseña456");

        // Agregar usuarios a la lista
        userManager.addUser(user1);
        userManager.addUser(user2);

        // Mostrar todos los usuarios
        System.out.println("Lista de usuarios:");
        for (User user : userManager.getAllUsers()) {
            System.out.println(user);
        }

        // Actualizar usuario
        userManager.updateUser("juan@correo.com", "Juan Perez Actualizado", "nuevacontraseña123");

        // Buscar un usuario por email
        User foundUser = userManager.findUserByEmail("juan@correo.com");
        System.out.println("Usuario encontrado: " + foundUser);

        // Eliminar un usuario
        userManager.deleteUser("maria@correo.com");

        // Mostrar usuarios después de la eliminación
        System.out.println("Usuarios restantes:");
        for (User user : userManager.getAllUsers()) {
            System.out.println(user);
        }

        // Crear empresas
        List<String> serviceDays = new ArrayList<>();
        serviceDays.add("Lunes");
        serviceDays.add("Martes");

        List<String> serviceTypes = new ArrayList<>();
        serviceTypes.add("Servicio de mecánica");

        Empresa empresa1 = empresaManager.createEmpresa("banner1.jpg", "123456789", 1, "Empresa A", "Razón A", "email@a.com",
                "10.0", "-20.0", "Centro", "123", "999999999", serviceDays, serviceTypes, "facebook.com/a", "instagram.com/a", "Calle A");

        Empresa empresa2 = empresaManager.createEmpresa("banner2.jpg", "987654321", 2, "Empresa B", "Razón B", "email@b.com",
                "15.0", "-25.0", "Sur", "456", "888888888", serviceDays, serviceTypes, "facebook.com/b", "instagram.com/b", "Calle B");

        // Mostrar todas las empresas
        System.out.println("Lista de empresas:");
        for (Empresa empresa : empresaManager.getAllEmpresas()) {
            System.out.println(empresa);
        }

        // Actualizar empresa
        empresaManager.updateEmpresa(1, "", "nuevoemail@a.com");

        // Buscar empresa por ID
        Empresa foundEmpresa = empresaManager.readEmpresa(1);
        System.out.println("Empresa encontrada: " + foundEmpresa);

        // Eliminar una empresa
        empresaManager.deleteEmpresa(2);

        // Mostrar empresas restantes después de la eliminación
        System.out.println("Empresas restantes:");
        for (Empresa empresa : empresaManager.getAllEmpresas()) {
            System.out.println(empresa);
        }
    }
}

