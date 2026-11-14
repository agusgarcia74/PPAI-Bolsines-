package ar.edu.utn.frc.dsi.bolsines.repository;

import ar.edu.utn.frc.dsi.bolsines.entity.TipoDocumentacion;
import org.springframework.data.jpa.repository.JpaRepository;

/** Duenio: T1 (Vale). Spring genera la implementacion; se agregan metodos de busqueda si hacen falta. */
public interface TipoDocumentacionRepository extends JpaRepository<TipoDocumentacion, Long> {
}
