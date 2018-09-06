package biz.cit.challenge.persist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;

import biz.cit.challenge.persist.domain.Model;

@Entity
public class Office extends Model {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3437064495223350131L;

	@NotNull
	@Column(unique = true, columnDefinition = "CHAR(4)")
	@Length(min = 4, max = 4, message = "Incorrect length for the office code.")
	private String code;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Office)) {
			return false;
		}
		Office rhs = (Office) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(getName(), rhs.getCode()).isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(89, 2339);
		hcb = hcb.append(serialVersionUID).appendSuper(super.hashCode()).append(getName()).append(getCode());
		return hcb.toHashCode();
	}

	@Override
	public String toString() {
		return String.format("Office[id=%d, firstName='%s', lastName='%s']", getId(), name, code);
	}

}
