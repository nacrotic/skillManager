package net.leoperrin.skills.controller

import net.leoperrin.skills.entity.Skill
import net.leoperrin.skills.service.SkillService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/skill")
class SkillController(val skillService: SkillService) {

	@GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
	@ResponseBody
	fun getAll(): List<Skill> = skillService.getSkills()

	@PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
	@ResponseBody
	fun addSkill(@RequestBody skill: Skill): Skill = skillService.add(skill)
}