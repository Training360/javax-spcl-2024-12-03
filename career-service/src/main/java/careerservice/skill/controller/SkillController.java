package careerservice.skill.controller;

import careerservice.skill.command.AssignSkillsToEmployeeCommand;
import careerservice.skill.command.CreateSkillCommand;
import careerservice.skill.model.AssignedSkill;
import careerservice.skill.service.SkillService;
import careerservice.skill.view.EmployeeSkillsView;
import careerservice.skill.view.SkillView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SkillController {

    private SkillService skillService;

    @GetMapping("/api/skills")
    public List<SkillView> listSkills() {
        return skillService.listSkills();
    }

    @PostMapping("/api/skills")
    public SkillView createSkill(@RequestBody CreateSkillCommand command) {
        return skillService.create(command);
    }

    @DeleteMapping("/api/skills/{id}")
    public void deleteSkillById(@PathVariable long id) {
        skillService.deleteSkillById(id);
    }

    @PostMapping("/api/assigned-skills")
    public EmployeeSkillsView assignSkillsToEmployee(@RequestBody AssignSkillsToEmployeeCommand command) {
        return skillService.assignSkillsToEmployee(command);
    }

    @GetMapping("/api/assigned-skills")
    public EmployeeSkillsView getAssignedSkills(@RequestParam int employeeId) {
        return skillService.getAssignedSkills(employeeId);
    }

}
