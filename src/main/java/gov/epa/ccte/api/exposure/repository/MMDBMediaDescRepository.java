package gov.epa.ccte.api.exposure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gov.epa.ccte.api.exposure.domain.MMDBMediaDesc;
import gov.epa.ccte.api.exposure.projection.MMDBMediaDescSummary;
import jakarta.annotation.Nullable;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface MMDBMediaDescRepository extends JpaRepository<MMDBMediaDesc, Integer> {

	<T> List<T> findBy(Class<T> projectionType);
}