package biz.cit.challenge.persist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import biz.cit.challenge.persist.domain.Office;

import biz.cit.challenge.persist.domain.Model;

@Entity
public class Person extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5835759193598838753L;

	@NotNull
	@Length(min = 1, max = 15, message = "First name should be between 1 to 15 characters.")
	@Pattern(message = "The identifier can only contain alphanumberic characters.", regexp = "^[A-Za-z-\']{1,15}$")
	private String firstName;

	@NotNull
	@Length(min = 1, max = 30, message = "First name should be between 1 to 15 characters.")
	@Pattern(message = "The identifier can only contain alphanumberic characters.", regexp = "^[A-Za-z-\']{1,15}$")
	private String lastName;

	@Length(min = 1, max = 1, message = "Initial should be only 1 character.")
	private String initial;

	private String middleName;

	@Length(min = 0, max = 5, message = "Suffixes have a maximum size of 5 characters.")
	private String suffix;

	@Column(unique = true, columnDefinition = "CHAR(6)")
	@Pattern(message = "The identifier can only contain alphanumberic characters.", regexp = "^[A-Za-z0-9]{6,8}$")
	@Length(min = 6, max = 8, message = "Unique identifier should be between 6 to 8 characters.")
	private String uniqueIdentifier;

	@ManyToOne
	private Office office;

	@ManyToOne
	private Person supervisor;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}

	@ManyToOne
	@JoinColumn(name = "office_id")
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@PrePersist
	@PreUpdate
	void updateInitial() {
		if (StringUtils.isNotBlank(middleName)) {
			this.initial = middleName.substring(0, 1);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person rhs = (Person) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj))
				.append(getUniqueIdentifier(), rhs.getUniqueIdentifier()).append(getFirstName(), rhs.getFirstName())
				.append(getMiddleName(), rhs.getMiddleName()).append(getInitial(), rhs.getInitial())
				.append(getLastName(), rhs.getLastName()).append(getSuffix(), rhs.getSuffix()).isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(89, 2339);
		hcb = hcb.append(serialVersionUID).appendSuper(super.hashCode()).append(getUniqueIdentifier())
				.append(getFirstName()).append(getMiddleName()).append(getInitial()).append(getLastName())
				.append(getSuffix());
		return hcb.toHashCode();
	}

	@Override
	public String toString() {
		return String.format("User[id=%d, firstName='%s', lastName='%s']", getId(), firstName, lastName);
	}

}
