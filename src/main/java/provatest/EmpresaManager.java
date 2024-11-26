package provatest;

import java.util.ArrayList;
import java.util.List;

public class EmpresaManager {

    private List<Empresa> empresas = new ArrayList<>();

    // Crear una nueva empresa
    public Empresa createEmpresa(String banner, String cnpj, int companyId, String companyName, String corporateName,
                                 String email, String latitude, String longitude, String neighborhood, String number,
                                 String phone, List<String> serviceDays, List<String> serviceType, String facebook,
                                 String instagram, String street) {
        if (readEmpresa(companyId) != null) {
            throw new IllegalArgumentException("Ya existe una empresa con el ID proporcionado.");
        }
        Empresa empresa = new Empresa(banner, cnpj, companyId, companyName, corporateName, email, latitude, longitude,
                                      neighborhood, number, phone, serviceDays, serviceType, facebook, instagram, street);
        empresas.add(empresa);
        System.out.println("Empresa creada: " + empresa.getCompanyName());
        return empresa;
    }

    // Leer (obtener) una empresa por ID
    public Empresa readEmpresa(int companyId) {
        for (Empresa empresa : empresas) {
            if (empresa.getCompanyId() == companyId) {
                return empresa;
            }
        }
        return null; // Retorna null si no se encuentra la empresa
    }

    // Actualizar una empresa
    public Empresa updateEmpresa(int companyId, String newCompanyName, String newEmail) {
        Empresa empresa = readEmpresa(companyId);
        if (empresa != null) {
            if (newCompanyName != null && !newCompanyName.trim().isEmpty()) {
                empresa.setCompanyName(newCompanyName);
            }
            if (newEmail != null && newEmail.contains("@")) {
                empresa.setEmail(newEmail);
            }
            System.out.println("Empresa actualizada: " + empresa.getCompanyName());
            return empresa;
        } else {
            throw new IllegalArgumentException("Empresa no encontrada con el ID: " + companyId);
        }
    }

    // Eliminar una empresa
    public boolean deleteEmpresa(int companyId) {
        Empresa empresa = readEmpresa(companyId);
        if (empresa != null) {
            empresas.remove(empresa);
            System.out.println("Empresa eliminada: " + empresa.getCompanyName());
            return true;
        }
        return false; // Si no se encuentra la empresa
    }

    // Obtener todas las empresas
    public List<Empresa> getAllEmpresas() {
        return new ArrayList<>(empresas); // Retorna una copia para proteger la lista original
    }
}
