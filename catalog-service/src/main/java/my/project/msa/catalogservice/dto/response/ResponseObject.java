package my.project.msa.catalogservice.dto.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class ResponseObject {

    private Map<String, Object> fields = new HashMap();

    @JsonAnySetter
    public void setFields(String key, Object value) {
        fields.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getFields() {
        return fields;
    }

    public ResponseObject(Object data, int count) {
        fields.put("data", data);
        fields.put("count", count);
    }
}
