package nl.living.it.assignment.service.transformers;

import nl.living.it.assignment.dto.Dto;
import nl.living.it.assignment.model.BaseEntity;

/**
 * @author a.zenkovich
 * @since 27.03.18.
 */
@FunctionalInterface
public interface ToDtoTransformer<D extends Dto, E extends BaseEntity> {
    /**
     * Transform from database {@link BaseEntity} object to {@link Dto} to be presented to the client.
     *
     * @param entity - object that needs to be converted to dto.
     * @return dto representation of provided {@link BaseEntity} object
     */
    D transform(E entity);
}
