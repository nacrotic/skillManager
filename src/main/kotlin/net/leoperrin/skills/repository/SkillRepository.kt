package net.leoperrin.skills.repository

import net.leoperrin.skills.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SkillRepository : JpaRepository<Skill, UUID> {

	@Query("SELECT s FROM Skill s JOIN FETCH s.assessment")
	fun findAllAndFetchScaleEagerly(): Iterable<Skill>
}