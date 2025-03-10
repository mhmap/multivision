package com.labseq.services;


import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jakarta.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
public class LabseqService {

    private final Map<Integer, BigInteger> cache = new ConcurrentHashMap<>();

    public String getLabSeqValue( int n) {

        if (cache.containsKey(n)) {
            return convertIfNecessary(cache.get(n));
        }

        BigInteger result = calculateLabSeq(n);
        cache.put(n, result);
        return convertIfNecessary(result);
    }

    private String convertIfNecessary(BigInteger value) {
        int maxAllowedBits = 100;
        if (value.bitLength() > maxAllowedBits) {
            return String.format("%.6e", new BigDecimal(value));
        } else {
            return value.toString();
        }
    }

    public BigInteger calculateLabSeq(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }
        if (n == 1) {
            return BigInteger.ONE;
        }
        if (n == 2) {
            return BigInteger.ZERO;
        }
        if (n == 3) {
            return BigInteger.ONE;
        }

        BigInteger[] values = new BigInteger[4];
        values[0] = BigInteger.ZERO;
        values[1] = BigInteger.ONE;
        values[2] = BigInteger.ZERO;
        values[3] = BigInteger.ONE;

        for (int i = 4; i <= n; i++) {
            values[i % 4] = values[(i - 4) % 4].add(values[(i - 3) % 4]);
        }

        return values[n % 4];
    }



}
