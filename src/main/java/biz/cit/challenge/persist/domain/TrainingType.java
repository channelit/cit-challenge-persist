package biz.cit.challenge.persist.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import biz.cit.challenge.persist.domain.Model;

@Entity
public class TrainingType extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3437064495223350131L;

	@NotNull
	@Column(unique = true)
	private String name;

	private String code;

	private boolean isMandatory;
	
	private Set<Skill> attainableSkills;

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

	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public Set<Skill> getAttainableSkills() {
		return attainableSkills;
	}

	public void setAttainableSkills(Set<Skill> attainableSkills) {
		this.attainableSkills = attainableSkills;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof TrainingType)) {
			return false;
		}
		TrainingType rhs = (TrainingType) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(getName(), rhs.getName())
				.append(getCode(), rhs.getCode()).append(isMandatory(), rhs.isMandatory()).isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(89, 2339);
		hcb = hcb.append(serialVersionUID).appendSuper(super.hashCode()).append(getName()).append(getCode())
				.append(isMandatory());
		return hcb.toHashCode();
	}

	@Override
	public String toString() {
		return String.format("TrainingType[id=%d, name='%s', code='%s', mandatory='%s']", getId(), name, code,
				isMandatory);
	}

}
