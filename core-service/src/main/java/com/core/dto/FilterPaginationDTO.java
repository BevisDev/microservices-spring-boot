package com.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.core.constant.Const;
import com.core.utils.ValidateUtils;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilterPaginationDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 3122949941812274044L;

    private int page;
    private int size;
    private String sort;
    private String search;

    public FilterPaginationDTO() {
        if (ValidateUtils.isNullOrEmpty(sort)) {
            this.sort = Const.DESC_SORT;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
