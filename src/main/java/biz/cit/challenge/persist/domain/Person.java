package biz.cit.challenge.persist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import biz.cit.challenge.persist.domain.Model;

@Entity
public class Person extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5835759193598838753L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String firstName;

	private String lastName;

	@NotNull
	private String username;

	private String initial;

	private String middleName;

	private String suffix;

	@Column(unique = true, columnDefinition = "CHAR(6)")
	private String uniqueIdentifier;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(getUsername(), rhs.getUsername())
				.append(getUniqueIdentifier(), rhs.getUniqueIdentifier()).append(getFirstName(), rhs.getFirstName())
				.append(getMiddleName(), rhs.getMiddleName()).append(getInitial(), rhs.getInitial())
				.append(getLastName(), rhs.getLastName()).append(getSuffix(), rhs.getSuffix()).isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(89, 2339);
		hcb = hcb.append(serialVersionUID).appendSuper(super.hashCode()).append(getUsername())
				.append(getUniqueIdentifier()).append(getFirstName()).append(getMiddleName()).append(getInitial())
				.append(getLastName()).append(getSuffix());
		return hcb.toHashCode();
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

}
