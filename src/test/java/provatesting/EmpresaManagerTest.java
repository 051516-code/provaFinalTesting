package provatesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import provatest.Empresa;
import provatest.EmpresaManager;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaManagerTest {
    private EmpresaManager empresaManager;

    @BeforeEach
    void setUp() {
        empresaManager = new EmpresaManager();
    }

    @Test
    void testCreateEmpresa() {
        Empresa empresa = empresaManager.createEmpresa(
                "banner.jpg",
                "12345678901234",
                1,
                "Empresa Test",
                "Razón Social Test",
                "empresa@test.com",
                "10.0000",
                "-20.0000",
                "Barrio Test",
                "123",
                "123456789",
                Arrays.asList("Lunes", "Martes"),
                Arrays.asList("Servicio A", "Servicio B"),
                "facebook.com/test",
                "instagram.com/test",
                "Calle Test"
        );

        assertNotNull(empresa);
        assertEquals("Empresa Test", empresa.getCompanyName());
        assertEquals(1, empresaManager.getAllEmpresas().size());
    }

    @Test
    void testReadEmpresa() {
        empresaManager.createEmpresa(
                "banner.jpg",
                "12345678901234",
                1,
                "Empresa Uno",
                "Razón Social Uno",
                "empresa1@test.com",
                "10.0000",
                "-20.0000",
                "Barrio Uno",
                "456",
                "123456789",
                Arrays.asList("Miércoles", "Jueves"),
                Arrays.asList("Servicio C", "Servicio D"),
                "facebook.com/uno",
                "instagram.com/uno",
                "Calle Uno"
        );

        Empresa empresa = empresaManager.readEmpresa(1);
        assertNotNull(empresa);
        assertEquals("Empresa Uno", empresa.getCompanyName());
    }

    @Test
    void testUpdateEmpresa() {
        empresaManager.createEmpresa(
                "banner.jpg",
                "12345678901234",
                1,
                "Empresa Antigua",
                "Razón Social Antigua",
                "empresa.antigua@test.com",
                "10.0000",
                "-20.0000",
                "Barrio Antigua",
                "789",
                "987654321",
                Arrays.asList("Viernes", "Sábado"),
                Arrays.asList("Servicio E", "Servicio F"),
                "facebook.com/antigua",
                "instagram.com/antigua",
                "Calle Antigua"
        );

        Empresa updatedEmpresa = empresaManager.updateEmpresa(1, "Empresa Nueva", "empresa.nueva@test.com");
        assertNotNull(updatedEmpresa);
        assertEquals("Empresa Nueva", updatedEmpresa.getCompanyName());
        assertEquals("empresa.nueva@test.com", updatedEmpresa.getEmail());
    }

    @Test
    void testDeleteEmpresa() {
        empresaManager.createEmpresa(
                "banner.jpg",
                "12345678901234",
                1,
                "Empresa Eliminar",
                "Razón Social Eliminar",
                "empresa.eliminar@test.com",
                "10.0000",
                "-20.0000",
                "Barrio Eliminar",
                "987",
                "987654321",
                Arrays.asList("Domingo"),
                Arrays.asList("Servicio G"),
                "facebook.com/eliminar",
                "instagram.com/eliminar",
                "Calle Eliminar"
        );

        boolean isDeleted = empresaManager.deleteEmpresa(1);
        assertTrue(isDeleted);
        assertNull(empresaManager.readEmpresa(1));
        assertEquals(0, empresaManager.getAllEmpresas().size());
    }

    @Test
    void testGetAllEmpresas() {
        empresaManager.createEmpresa(
                "banner1.jpg",
                "12345678901234",
                1,
                "Empresa Uno",
                "Razón Social Uno",
                "empresa1@test.com",
                "10.0000",
                "-20.0000",
                "Barrio Uno",
                "456",
                "123456789",
                Arrays.asList("Lunes", "Martes"),
                Arrays.asList("Servicio A", "Servicio B"),
                "facebook.com/uno",
                "instagram.com/uno",
                "Calle Uno"
        );

        empresaManager.createEmpresa(
                "banner2.jpg",
                "98765432109876",
                2,
                "Empresa Dos",
                "Razón Social Dos",
                "empresa2@test.com",
                "30.0000",
                "-40.0000",
                "Barrio Dos",
                "789",
                "987654321",
                Arrays.asList("Miércoles", "Jueves"),
                Arrays.asList("Servicio C", "Servicio D"),
                "facebook.com/dos",
                "instagram.com/dos",
                "Calle Dos"
        );

        List<Empresa> empresas = empresaManager.getAllEmpresas();
        assertEquals(2, empresas.size());
        assertEquals("Empresa Uno", empresas.get(0).getCompanyName());
        assertEquals("Empresa Dos", empresas.get(1).getCompanyName());
    }
}
