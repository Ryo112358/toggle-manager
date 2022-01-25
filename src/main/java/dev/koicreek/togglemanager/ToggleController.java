package dev.koicreek.togglemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/toggles")
public class ToggleController {

    @Autowired
    private ToggleService toggleService;

    @GetMapping
    public List<ToggleCM> getToggles() {
        return toggleService.getToggles();
    }

    @GetMapping("/{id}")
    public ToggleCM getToggle(@PathVariable("id") String toggleId) {
        return toggleService.getToggle(toggleId);
    }

    @PostMapping
    public void createToggle(@RequestBody ToggleCM toggle) {
        toggleService.createToggle(toggle);
    }

    @PutMapping
    public void updateToggle(@RequestBody ToggleCM toggle) {
        toggleService.updateToggle(toggle);
    }

    @DeleteMapping("/{id}")
    public void deleteToggle(@PathVariable("id") String toggleId) {
        toggleService.deleteToggle(toggleId);
    }
}
