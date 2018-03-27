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
public interface DtoTransformer<D extends Dto, E extends BaseEntity>
        extends FromDtoTransformer<D, E>, ToDtoTransformer<D, E> {
}
