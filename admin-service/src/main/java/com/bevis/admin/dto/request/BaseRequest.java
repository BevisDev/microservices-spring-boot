package com.bevis.admin.dto.request;

import com.bevis.admin.utils.CommonUtils;
import com.bevis.admin.utils.ValidateUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 2905646205909847233L;

    private String requestId;
    private Date requestTime;

    public BaseRequest() {
        if (StringUtils.isEmpty(requestId)) {
            requestId = CommonUtils.randomUUID();
        }
        if (ValidateUtils.isNullOrEmpty(requestTime)) {
            requestTime = new Date();
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
