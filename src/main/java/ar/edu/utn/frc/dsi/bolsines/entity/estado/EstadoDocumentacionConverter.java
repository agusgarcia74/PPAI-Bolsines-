package ar.edu.utn.frc.dsi.bolsines.entity.estado;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Guarda el estado en la base como texto (su nombre) y al leer reconstruye el objeto.
 * Los estados no tienen datos propios, por eso alcanza con el nombre.
 */
@Converter
public class EstadoDocumentacionConverter implements AttributeConverter<EstadoDocumentacion, String> {

    @Override
    public String convertToDatabaseColumn(EstadoDocumentacion estado) {
        return estado == null ? null : estado.getNombre();
    }

    @Override
    public EstadoDocumentacion convertToEntityAttribute(String nombre) {
        return nombre == null ? null : EstadoDocumentacion.desdeNombre(nombre);
    }
}
