package biz.cit.challenge.persist.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class Model implements Serializable {

	private static final int PRIME2 = 2339;

	private static final int PRIME1 = 89;

	/**
	 *
	 */
	private static final long serialVersionUID = 1884749264871950612L;

	@Id
	@Column(columnDefinition = "CHAR(36)")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Model rhs = (Model)obj;
        return new EqualsBuilder().append(id, rhs.getId()).isEquals();
    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(PRIME1, PRIME2);
        hcb = hcb.append(serialVersionUID).append(getId());
        return hcb.toHashCode();
    }

}