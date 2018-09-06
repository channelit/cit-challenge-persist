package biz.cit.challenge.persist.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import biz.cit.challenge.persist.domain.Model;

@Entity
public class Language extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8256052881066928190L;

	@NotNull
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Language)) {
			return false;
		}
		Language rhs = (Language) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(getName(), rhs.getName()).isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(89, 2339);
		hcb = hcb.append(serialVersionUID).appendSuper(super.hashCode()).append(getName());
		return hcb.toHashCode();
	}

	@Override
	public String toString() {
		return String.format("Language[id=%d, name='%s']", getId(), name);
	}

}
