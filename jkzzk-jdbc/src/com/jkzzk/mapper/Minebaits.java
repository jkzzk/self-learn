package com.jkzzk.mapper;

public class Minebaits extends MybaitsSimulation {

    @Override
    public String getSql(String tableName) {
        return "select * from " + tableName + " where id = '83644737042513920'";
    }
}
