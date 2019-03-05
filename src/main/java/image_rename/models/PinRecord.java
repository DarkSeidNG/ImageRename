package image_rename.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "simplified_identifier")
public class PinRecord {
    @Id
    private Integer id;

    private Integer uniq_id;

    private Integer pin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUniq_id() {
        return uniq_id;
    }

    public void setUniq_id(Integer uniq_id) {
        this.uniq_id = uniq_id;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }
}
