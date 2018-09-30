package com.tony.unit.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by MABO on 2017/7/4.
 */
@Component
@Data
@RefreshScope
public class AppInfo {

    @Value("${app.build.name}")
    private String name;

    @Value("${spring.cloud.client.ipAddress}")
    private String ipAddr;

}
