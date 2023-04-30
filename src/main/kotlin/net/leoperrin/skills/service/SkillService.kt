package net.leoperrin.skills.service

import net.leoperrin.skills.entity.Skill
import net.leoperrin.skills.repository.SkillRepository
import org.springframework.stereotype.Service

@Service
class SkillService(val db: SkillRepository) {

	fun getAll(): List<Skill> = db.findAllAndFetchScaleEagerly().toList()
	fun getSkills(): List<Skill> = db.findAll().toList()
	fun add(skill: Skill): Skill {
		return db.save(skill)
	}
}