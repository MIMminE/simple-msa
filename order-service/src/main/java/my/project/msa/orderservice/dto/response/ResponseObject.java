package my.project.msa.orderservice.dto.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class ResponseObject {
    private final Map<String, Object> fields = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getFields() {
        return fields;
    }

    @JsonAnySetter
    public void setFields(String key, Object value) {
        fields.put(key, value);
    }

    public ResponseObject(Object data, int count) {
        fields.put("data", data);
        fields.put("count", count);
    }
}
