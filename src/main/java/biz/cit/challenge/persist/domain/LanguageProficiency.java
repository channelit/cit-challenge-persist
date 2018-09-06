package biz.cit.challenge.persist.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import biz.cit.challenge.persist.ProficiencyLevel;
import biz.cit.challenge.persist.domain.Model;

@Entity
public class LanguageProficiency extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6642533079627776568L;

	@NotNull
	@ManyToOne
	private Language language;

	private ProficiencyLevel readingLevel;

	private ProficiencyLevel writingLevel;

	private ProficiencyLevel speakingLevel;

	@NotNull
	@ManyToOne
	private Person person;

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {

		this.language = language;
	}

	public ProficiencyLevel getReadingLevel() {
		return readingLevel;
	}

	public void setReadingLevel(ProficiencyLevel readingLevel) {
		this.readingLevel = readingLevel;
	}

	public ProficiencyLevel getWritingLevel() {
		return writingLevel;
	}

	public void setWritingLevel(ProficiencyLevel writingLevel) {
		this.writingLevel = writingLevel;
	}

	public ProficiencyLevel getSpeakingLevel() {
		return speakingLevel;
	}

	public void setSpeakingLevel(ProficiencyLevel speakingLevel) {
		this.speakingLevel = speakingLevel;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof LanguageProficiency)) {
			return false;
		}
		LanguageProficiency rhs = (LanguageProficiency) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(getReadingLevel(), rhs.getReadingLevel())
				.append(getWritingLevel(), rhs.getWritingLevel()).append(getSpeakingLevel(), rhs.getSpeakingLevel())
				.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(89, 2339);
		hcb = hcb.append(serialVersionUID).appendSuper(super.hashCode()).append(getReadingLevel())
				.append(getWritingLevel()).append(getSpeakingLevel());
		return hcb.toHashCode();
	}

	@Override
	public String toString() {
		return String.format("LanguageProficiency[id=%d, language='%s', read='%s', write='%s', speak='%s' ]", getId(),
				language.getName(), readingLevel, writingLevel, speakingLevel);
	}

}
