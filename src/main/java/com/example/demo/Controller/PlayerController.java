package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Player;
import com.example.demo.Service.PlayerService;

//@Controller
@RestController
@RequestMapping("/players")
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	@GetMapping
	public List<Player> index() {
		return playerService.findAll();
	}

//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable Long id, Model model) {
//        model.addAttribute("player", playerService.findOne(id));
//        return "players/edit";
//    }

	@GetMapping("{id}")
	public Player show(@PathVariable Long id) {
		return playerService.findOne(id);
	}

//	テスト @ModelAttributeいらない？
	@PostMapping
	public String create(@RequestBody Player player) {
		playerService.save(player);
		return "success";
	}

	@PutMapping("/{id}")
	public String update(@PathVariable Long id, @RequestBody Player player) {
		player.setId(id);
		playerService.update(player);
		return "sccess";
	}

	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		playerService.delete(id);
		return "redirect:/players";
	}
}