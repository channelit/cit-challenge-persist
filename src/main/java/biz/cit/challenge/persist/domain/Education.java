package biz.cit.challenge.persist.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import biz.cit.challenge.persist.EducationDegree;
import biz.cit.challenge.persist.domain.Model;

@Entity
public class Education extends Model {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8356456373680601673L;

	@NotNull
	private String degree;

	@NotNull
	private Calendar dateEarned;

	@NotNull
	private EducationDegree degreeType;

	@ManyToOne
	private Institution institution;

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Calendar getDateEarned() {
		return dateEarned;
	}

	public void setDateEarned(Calendar dateEarned) {
		this.dateEarned = dateEarned;
	}

	public EducationDegree getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(EducationDegree degreeType) {
		this.degreeType = degreeType;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Education)) {
			return false;
		}
		Education rhs = (Education) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(getDegree(), rhs.getDegree())
				.append(getDateEarned(), rhs.getDateEarned()).append(getDegreeType(), rhs.getDegreeType())
				.append(getInstitution(), rhs.getInstitution()).isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(89, 2339);
		hcb = hcb.append(serialVersionUID).appendSuper(super.hashCode()).append(getDegree()).append(getDateEarned())
				.append(getDegreeType()).append(getInstitution());
		return hcb.toHashCode();
	}

	@Override
	public String toString() {
		return String.format("Education[id=%d, degree='%s', degreeType='%s']", getId(), degree, degreeType);
	}

}
