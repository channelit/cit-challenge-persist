package biz.cit.challenge.persist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import biz.cit.challenge.persist.domain.Model;

@Entity
public class Skill extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8882010196946793L;

	@NotNull
	@Column(unique=true)
	private String name;

	private Skill category;

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public Skill getCategory() {
		return category;
	}


	public void setCategory(Skill category) {
		this.category = category;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Skill)) {
			return false;
		}
		Skill rhs = (Skill) obj;
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
		return String.format("Skill[id=%d, name='%s']", getId(), name);
	}
}
