package org.raptor.apis.persistence.domain.integration.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Clock;

@Document(collection = "audits")
public class Audit {

    @Id
    private String id;
    private String apiName;
    private String timestamp;

    @Version
    private Integer version;

    public Audit() {
        super();
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Audit{");
        sb.append("id='").append(id).append('\'');
        sb.append(", apiName='").append(apiName).append('\'');
        sb.append(", timestamp='").append(timestamp).append('\'');
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }
}
