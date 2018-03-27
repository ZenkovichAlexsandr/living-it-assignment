package nl.living.it.assignment.service.transformers;

import nl.living.it.assignment.dto.Dto;
import nl.living.it.assignment.model.BaseEntity;

/**
 * @author a.zenkovich
 * @since 27.03.18.
 */
@FunctionalInterface
public interface FromDtoTransformer<D extends Dto, E extends BaseEntity> {
    /**
     * Transformer from {@link Dto} to {@link BaseEntity} object to be saved to the database.
     *
     * @param dto - the dto that needs to be converted to entity.
     * @return the entity representation of provided {@link Dto} object
     */
    E transform(D dto);
}
