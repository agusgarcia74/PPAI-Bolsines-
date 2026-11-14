package ar.edu.utn.frc.dsi.bolsines.entity.estado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.List;
import org.junit.jupiter.api.Test;

/** Que los 9 estados se guarden por nombre y se reconstruyan bien desde la base. */
class EstadoDocumentacionConverterTest {

    private final EstadoDocumentacionConverter converter = new EstadoDocumentacionConverter();

    @Test
    void cadaEstadoIdaYVuelta() {
        List<EstadoDocumentacion> estados = List.of(new Registrada(), new EnRemito(), new EnBolsinSaliente(),
                new EnBolsinEnviado(), new RecibidaYAceptada(), new RecibidaYRechazada(), new NoRecibida(),
                new ParaRedirigir(), new DeBaja());
        for (EstadoDocumentacion estado : estados) {
            String columna = converter.convertToDatabaseColumn(estado);
            assertEquals(estado.getClass().getSimpleName(), columna);
            assertInstanceOf(estado.getClass(), converter.convertToEntityAttribute(columna));
        }
    }

    @Test
    void nombreDesconocidoFalla() {
        assertThrows(IllegalArgumentException.class, () -> EstadoDocumentacion.desdeNombre("Inventado"));
    }
}
