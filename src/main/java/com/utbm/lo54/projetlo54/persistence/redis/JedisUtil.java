/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.persistence.redis;

import redis.clients.jedis.Jedis;

/**
 *
 * @author Jonathan
 */
public class JedisUtil {

    /*static JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    public static Jedis getConnection() {
        return pool.getResource();
    }*/
    private static final Jedis JEDIS;

    static {
        //JEDIS = new Jedis("localhost");
        JEDIS = new Jedis("127.0.0.1", 6379, 86400);
        if (JEDIS.isConnected()) {
            System.out.println("connected");
        }
        JEDIS.connect();
        if (JEDIS.isConnected()) {
            System.out.println("connected");
        }
        System.out.println("Connection to server sucessfully");
    }

    public static Jedis getConnection() {
        return JEDIS;
    }

}
