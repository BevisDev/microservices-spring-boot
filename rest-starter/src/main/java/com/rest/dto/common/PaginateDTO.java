package com.rest.dto.common;

import com.rest.constant.Const;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class PaginateDTO implements Serializable {

    private static final long serialVersionUID = -5952913922941280904L;

    private int page;
    private int size;
    private String sort;
    private String search;

    public PaginateDTO() {
        if (StringUtils.isEmpty(sort)) {
            sort = Const.DESC_SORT;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
