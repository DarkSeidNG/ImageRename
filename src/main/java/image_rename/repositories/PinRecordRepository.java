package image_rename.repositories;

import image_rename.models.PinRecord;
import org.springframework.data.repository.CrudRepository;

public interface PinRecordRepository extends CrudRepository<PinRecord, Integer> {

}
