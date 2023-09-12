package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseUser {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("first_name")
    private String firstName;

    public ResponseUser(Integer id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public ResponseUser() {
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
}
