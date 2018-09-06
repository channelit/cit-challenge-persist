package biz.cit.challenge.persist.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import biz.cit.challenge.persist.TrainingStatus;
import biz.cit.challenge.persist.domain.Model;

@Entity
public class Training extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3437064495223350131L;

	@NotNull
	@ManyToOne
	private Person trainee;

	@NotNull
	@ManyToOne
	private Person approver;

	@NotNull
	@ManyToOne
	private TrainingType type;

	@NotNull
	@ManyToOne
	private Institution institution;

	@NotNull
	private TrainingStatus status;

	@NotNull
	private Double cost;

	@NotNull
	private Calendar requestedDate;

	private Calendar approvedDate;

	private Calendar rejectedDate;

	private Calendar expirationDate;

	private Calendar certificationDate;

	public Person getTrainee() {
		return trainee;
	}

	public void setTrainee(Person trainee) {
		this.trainee = trainee;
	}

	public Person getApprover() {
		return approver;
	}

	public void setApprover(Person approver) {
		this.approver = approver;
	}

	public TrainingType getType() {
		return type;
	}

	public void setType(TrainingType type) {
		this.type = type;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public TrainingStatus getStatus() {
		return status;
	}

	public void setStatus(TrainingStatus status) {
		this.status = status;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Calendar getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Calendar requestedDate) {
		this.requestedDate = requestedDate;
	}

	public Calendar getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Calendar approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Calendar getRejectedDate() {
		return rejectedDate;
	}

	public void setRejectedDate(Calendar rejectedDate) {
		this.rejectedDate = rejectedDate;
	}

	public Calendar getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Calendar expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Calendar getCertificationDate() {
		return certificationDate;
	}

	public void setCertificationDate(Calendar certificationDate) {
		this.certificationDate = certificationDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Training)) {
			return false;
		}
		Training rhs = (Training) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(getTrainee(), rhs.getTrainee())
				.append(getApprover(), rhs.getApprover()).append(getType(), rhs.getType())
				.append(getInstitution(), rhs.getInstitution()).append(getStatus(), rhs.getStatus())
				.append(getCost(), rhs.getCost()).append(getRequestedDate(), rhs.getRequestedDate())
				.append(getApprovedDate(), rhs.getApprovedDate()).append(getRejectedDate(), rhs.getRejectedDate())
				.append(getExpirationDate(), rhs.getExpirationDate())
				.append(getCertificationDate(), rhs.getCertificationDate()).isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(89, 2339);
		hcb = hcb.append(serialVersionUID).appendSuper(super.hashCode()).append(getTrainee()).append(getApprover())
				.append(getType()).append(getInstitution()).append(getStatus()).append(getCost()).append(getRequestedDate())
				.append(getApprovedDate()).append(getRejectedDate()).append(getExpirationDate())
				.append(getCertificationDate());
		return hcb.toHashCode();
	}
}
