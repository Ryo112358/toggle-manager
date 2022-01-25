package dev.koicreek.togglemanager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Toggle")
@JsonPropertyOrder({"toggleId", "toggleName", "enabled", "description"})
public class ToggleCM {

    @Id
    @Column(name="toggle_id")
    @JsonProperty("toggleId")
    private String id;

    @Column(name="toggle_name")
    @JsonProperty("toggleName")
    private String name;

    private boolean enabled;
    private String description;

    public ToggleCM() {
    }

    public ToggleCM(String toggleId, String toggleName) {
        this.id = toggleId;
        this.name = toggleName;
        this.enabled = true;
        this.description = null;
    }

    public ToggleCM(String toggleId, String toggleName, String description) {
        this.id = toggleId;
        this.name = toggleName;
        this.enabled = true;
        this.description = description;
    }

    public ToggleCM(String toggleId, String toggleName, boolean enabled, String description) {
        this.id = toggleId;
        this.name = toggleName;
        this.enabled = enabled;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\nobject Toggle {\n");

        sb.append(String.format("\tid: %s,\n", wrapInQuotations(this.id)));
        sb.append(String.format("\tname: %s,\n", wrapInQuotations(this.name)));
        sb.append(String.format("\tenabled: %b\n", this.enabled));
        sb.append(String.format("\tdescription: %s\n", wrapInQuotations(this.description)));
        sb.append("}");

        return sb.toString();
    }

    private String wrapInQuotations(String s) {
        if(s != null) {
            return "\"" + s + "\"";
        }

        return null;
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }

        return o.toString().replace("\n", "\n\t");
    }
}
