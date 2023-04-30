package net.leoperrin.skills.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import org.hibernate.annotations.UuidGenerator
import java.util.*

/**
 * Echelle d'evaluation d'une compétences.
 * Pas de nombre d'éléments pré-definits, chaque élément est porteur d'un texte précisant comment controler si un niveau est atteint ou non
 */
@Entity
@Table(
		uniqueConstraints = [
			UniqueConstraint(columnNames = ["skillId", "level"])
		]
)
class Scale(

		@Id
		@GeneratedValue
		@UuidGenerator
		var id: UUID?,

		@JoinColumn(name = "skillId")
		@ManyToOne(optional = false, fetch = FetchType.EAGER)
		var skill: Skill,

		@Column(nullable = false)
		var level: Int,

		@Column
		var control: String,
)
