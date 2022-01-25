package dev.koicreek.togglemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ToggleService {

    @Autowired
    private ToggleRepository toggleRepository;

    boolean isToggleEnabled(String toggleId) {
        Optional<ToggleCM> toggleEntity = toggleRepository.findById(toggleId);

        return toggleEntity.isEmpty() || toggleEntity.get().isEnabled();
    }

    List<ToggleCM> getToggles() {
        List<ToggleCM> toggles = new ArrayList<>();
        toggleRepository.findAll().forEach(toggles::add);
        return toggles;
    }

    ToggleCM getToggle(String toggleId) {
        Optional<ToggleCM> toggleEntity = toggleRepository.findById(toggleId);

        if(toggleEntity.isPresent()) {
            return toggleEntity.get();
        }

        throw new IllegalStateException("Toggle '" + toggleId + "' does not exist");
    }

    boolean createToggle(ToggleCM toggle) {
        Optional<ToggleCM> toggleEntity = toggleRepository.findById(toggle.getId());

        if(toggleEntity.isEmpty()) {
            toggleRepository.save(toggle);
            return true;
        }

        throw new IllegalArgumentException("Toggle '" + toggle.getId() + "' already exists");
    }

    boolean updateToggle(ToggleCM toggle) {
        Optional<ToggleCM> toggleEntity = toggleRepository.findById(toggle.getId());

        if(toggleEntity.isPresent()) {
            toggleRepository.save(toggle);
            return true;
        }

        throw new IllegalStateException("Toggle '" + toggle.getId() + "' does not exist");
    }

    boolean deleteToggle(String toggleId) {
        Optional<ToggleCM> toggleEntity = toggleRepository.findById(toggleId);

        if(toggleEntity.isPresent()) {
            toggleRepository.deleteById(toggleId);
            return true;
        }

        throw new IllegalStateException("Toggle '" + toggleId + "' does not exist");
    }
}
