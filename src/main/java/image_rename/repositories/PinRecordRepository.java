package image_rename.repositories;

import image_rename.models.PinRecord;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Pin record repository.
 */
public interface PinRecordRepository extends CrudRepository<PinRecord, Integer> {
    /**
     * Find by pin pin record.
     *
     * @param pin the pin
     * @return the pin record
     */
    PinRecord findByPin(int pin);
}
