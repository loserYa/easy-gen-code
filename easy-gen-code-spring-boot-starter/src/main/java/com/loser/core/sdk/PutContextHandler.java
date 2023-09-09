package com.loser.core.sdk;

import com.loser.entity.Context;
import com.loser.utils.ConfigUtils;

import java.util.Map;

/**
 * 从类中写入数据到全局上下文
 *
 * @author loser
 * @date 2023/9/4
 */
public interface PutContextHandler {

    Map<String, Object> putData();

    default boolean put() {

        boolean res = false;
        Map<String, Object> map = putData();
        Context context = ConfigUtils.getContext();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            context.put(entry.getKey(), entry.getValue());
            res = true;
        }
        return res;

    }

}
