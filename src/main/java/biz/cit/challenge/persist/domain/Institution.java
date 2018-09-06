package biz.cit.challenge.persist.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import biz.cit.challenge.persist.domain.Model;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name", "state", "country" }))
public class Institution extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9020510127039758662L;

	private String name;

	private String state;

	private String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Institution)) {
			return false;
		}
		Institution rhs = (Institution) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(getName(), rhs.getName())
				.append(getState(), rhs.getState()).append(getCountry(), rhs.getCountry()).isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(89, 2339);
		hcb = hcb.append(serialVersionUID).appendSuper(super.hashCode()).append(getName()).append(getState())
				.append(getCountry());
		return hcb.toHashCode();
	}

	@Override
	public String toString() {
		return String.format("Institution[id=%d, name='%s', state='%s', country='%s']", getId(), name, state, country);
	}

}
