package net.leoperrin.skills.entity

import java.util.*

class User(
		val id: UUID,
		val username: String,
		val firstName: String,
		val lastName: String,
		val declaredSkills: List<Skill>
) {
}