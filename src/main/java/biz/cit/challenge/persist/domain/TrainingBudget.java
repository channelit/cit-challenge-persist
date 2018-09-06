package biz.cit.challenge.persist.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import biz.cit.challenge.persist.domain.Model;

@Entity
public class TrainingBudget extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3437064495223350131L;

	@ManyToOne
	private Office office;

	@ManyToOne
	private TrainingType trainingType;

	private Double annualBudget;

	private Integer fiscalYear;

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public TrainingType getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}

	public Double getAnnualBudget() {
		return annualBudget;
	}

	public void setAnnualBudget(Double annualBudget) {
		this.annualBudget = annualBudget;
	}

	public Integer getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(Integer fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof TrainingBudget)) {
			return false;
		}
		TrainingBudget rhs = (TrainingBudget) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(getAnnualBudget(), rhs.getAnnualBudget())
				.append(getFiscalYear(), rhs.getFiscalYear()).append(getTrainingType(), rhs.getTrainingType())
				.append(getOffice(), rhs.getOffice()).isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(89, 2339);
		hcb = hcb.append(serialVersionUID).appendSuper(super.hashCode()).append(getAnnualBudget())
				.append(getTrainingType()).append(getFiscalYear()).append(getOffice());
		return hcb.toHashCode();
	}

	@Override
	public String toString() {
		return String.format("TrainingBudget[id=%d, annualBudget='%s', fiscalYear='%s', office='%s', type='%s']",
				getId(), annualBudget, fiscalYear, office.getCode(), trainingType.getName());
	}

}
