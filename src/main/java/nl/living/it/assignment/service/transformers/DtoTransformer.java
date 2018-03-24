package nl.living.it.assignment.service.transformers;

import nl.living.it.assignment.dto.Dto;
import nl.living.it.assignment.model.BaseEntity;

/**
 * Base interface for all transformers that support both to and from dto operations.
 *
 * @param <D> - type of the dto
 * @param <E> - type of the entity
 *
 * @author a.zenkovich
 * @since 24.03.18.
 */
public interface DtoTransformer<D extends Dto, E extends BaseEntity> {
    /**
     * Transform from database {@link BaseEntity} object to {@link Dto} to be presented to the client.
     *
     * @param entity - object that needs to be converted to dto.
     * @return dto representation of provided {@link BaseEntity} object
     */
    D transform(E entity);

    /**
     * Transformer from {@link Dto} to {@link BaseEntity} object to be saved to the database.
     *
     * @param dto - the dto that needs to be converted to entity.
     * @return the entity representation of provided {@link Dto} object
     */
    E transform(D dto);
}
