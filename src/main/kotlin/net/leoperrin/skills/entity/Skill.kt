package net.leoperrin.skills.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.hibernate.annotations.UuidGenerator
import java.util.*

/**
 * Représentation d'une compétence en BDD
 */
@Entity
class Skill(

		@Id
		@GeneratedValue
		@UuidGenerator
		val id: UUID?,

		@Column(nullable = false, unique = true)
		val label: String,

		@Column
		val details: String,

		@OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY, mappedBy = "skill")
		val assessment: List<Scale>?,
)