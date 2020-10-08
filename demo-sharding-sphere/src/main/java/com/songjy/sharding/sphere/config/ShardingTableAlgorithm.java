package com.songjy.sharding.sphere.config;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 分表策略
 *
 * @author songjy
 */
public class ShardingTableAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> tableNames,
                                         ComplexKeysShardingValue<Long> shardingValues) {
        System.out.println("collection:" + tableNames + ",shardingValues:" + shardingValues);
        Collection<Long> orderIdValues = getShardingValue(shardingValues, "order_id");
        //Collection<Long> userIdValues = getShardingValue(shardingValues, "user_id");
        List<String> shardingSuffix = new ArrayList<>(8);


        for (Long orderId : orderIdValues) {

            LocalDate localDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(orderId), ZoneId.systemDefault()).toLocalDate();

            String suffix = localDate.getYear() + "_" + localDate.getMonthValue() + "_" + localDate.getDayOfMonth();
            System.out.println(">>" + suffix);
            for (String tableName : tableNames) {
                if (tableName.endsWith(suffix)) {
                    shardingSuffix.add(tableName);
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
