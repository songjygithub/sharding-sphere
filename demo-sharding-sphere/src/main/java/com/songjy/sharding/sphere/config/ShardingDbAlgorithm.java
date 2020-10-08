package com.songjy.sharding.sphere.config;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 分库策略
 *
 * @author songjy
 */
public class ShardingDbAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> dbNames,
                                         ComplexKeysShardingValue<Long> shardingValues) {
        System.out.println("collection:" + dbNames + ",shardingValues:" + shardingValues);
        Collection<Long> orderIdValues = getShardingValue(shardingValues, "order_id");
        List<String> shardingSuffix = new ArrayList<>(8);

        for (Long orderId : orderIdValues) {

            LocalDate localDate = LocalDate.ofEpochDay(orderId);

            for (String dbName : dbNames) {
                if (dbName.endsWith(localDate.getYear() + "")) {
                    shardingSuffix.add(dbName);
                }
            }
        }

        return shardingSuffix;
    }

    private Collection<Long> getShardingValue(ComplexKeysShardingValue<Long> shardingValues,
                                              final String key) {
        Map<String, Collection<Long>> map = shardingValues.getColumnNameAndShardingValuesMap();
        return map.get(key);
    }
}
