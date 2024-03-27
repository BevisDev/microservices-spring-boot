package com.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.constant.Const;
import com.rest.dto.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginationDTO extends BaseRequest {

    private int page;
    private int size;
    private String sort;
    private String search;

    public PaginationDTO() {
        if (StringUtils.isEmpty(this.sort)) {
            this.sort = Const.DESC_SORT;
        }
    }

}
