package miraj.basicmicroservice2024.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

import static miraj.basicmicroservice2024.util.Constants.BaseEntityConstants.*;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = -4546567345612345L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = CREATED_TS, updatable = false) // , nullable = false for unit test
    private Date insertTs;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = MODIFIED_TS)
    private Date modifiedTs;

    @Column(name = MODIFIED_BY)
    private String modifiedBy;

    @Column(name = CREATED_BY, updatable = false)
    private String createdBy;

    /**
     * The inserted timestamp.
     *
     * @return The inserted timestamp.
     */
    public Date getInsertTs() {
        return (insertTs == null) ? null : new Date(insertTs.getTime());
    }

    /**
     * Set the inserted timestamp.
     *
     * @param insertTs The inserted timestamp.
     */
    public void setInsertTs(final Date insertTs) {
        if (insertTs != null)
            this.insertTs = new Date(insertTs.getTime());
    }

    /**
     * The modified timestamp.
     *
     * @return The modified timestamp.
     */
    public Date getModifiedTs() {
        return (modifiedTs == null) ? null : new Date(modifiedTs.getTime());
    }

    /**
     * Set the modified timestamp.
     *
     * @param modifiedTs The modified timestamp.
     */
    public void setModifiedTs(final Date modifiedTs) {
        if (modifiedTs != null)
            this.modifiedTs = new Date(modifiedTs.getTime());
    }

    /**
     * Modified by.
     *
     * @return Modified by.
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Set modified by.
     *
     * @param modifiedBy Modified by.
     */
    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * Get created by.
     *
     * @return Created by.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Created by.
     *
     * @param createdBy Created by.
     */
    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * On created hookup.
     */
    @PrePersist
    protected void onCreate() {
        insertTs = new Date();
        modifiedTs = new Date();
    }

    /**
     * On update hookup.
     */
    @PreUpdate
    protected void onUpdate() {
        modifiedTs = new Date();
    }

    /**
     * To string representation.
     *
     * @return To String representation.
     */
    @Override
    public String toString() {
        return "BaseEntity{" + CREATED_TS + "=" + insertTs + ", " + MODIFIED_TS + "="
                + modifiedTs + ", " + MODIFIED_BY + "='" + modifiedBy
                + '\'' + ", " + CREATED_BY + "='" + createdBy + '\'' + '}';
    }

}