package image_rename.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type Pin record.
 */
@Entity(name = "simplified_identifier")
public class PinRecord {
    @Id
    private Integer id;

    private Integer uniq_id;

    private Integer pin;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets uniq id.
     *
     * @return the uniq id
     */
    public Integer getUniq_id() {
        return uniq_id;
    }

    /**
     * Sets uniq id.
     *
     * @param uniq_id the uniq id
     */
    public void setUniq_id(Integer uniq_id) {
        this.uniq_id = uniq_id;
    }

    /**
     * Gets pin.
     *
     * @return the pin
     */
    public Integer getPin() {
        return pin;
    }

    /**
     * Sets pin.
     *
     * @param pin the pin
     */
    public void setPin(Integer pin) {
        this.pin = pin;
    }
}
