package com.bevis.masterservice.config.datasource;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
public class DataSourceProperties {
    String url;
    String username;
    String password;
    String type;
}
