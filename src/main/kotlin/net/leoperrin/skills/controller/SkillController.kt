package net.leoperrin.skills.controller

import mu.KotlinLogging
import net.leoperrin.skills.entity.Skill
import net.leoperrin.skills.service.SkillService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = ["http://localhost:4200"])
class SkillController(val skillService: SkillService) {

	private val log = KotlinLogging.logger {}

	@GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
	@ResponseBody
	fun getAll(@RequestHeader allHeaders: Map<String, String>): List<Skill> {
		log.info(allHeaders.entries.joinToString())
		return skillService.getSkills()
	}

	@PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
	@ResponseBody
	fun addSkill(@RequestBody skill: Skill): Skill = skillService.add(skill)
}