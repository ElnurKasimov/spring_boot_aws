package SpringBoot.app.header;

import lombok.Data;

import java.util.Map;

@Data
public class HeaderListResponse {
    private Map<String, String> headers;
}
