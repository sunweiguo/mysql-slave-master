package com.coder520.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by JackWangon[www.coder520.com] 2017/10/19.
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSource();
    }
}
