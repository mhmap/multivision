package com.labseq;

import com.labseq.services.LabseqService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class LabseqServiceTest {

    private LabseqService labseqService;

    @BeforeEach
    void setUp() {
        labseqService = new LabseqService();
    }

    @Test
    void testGetLabSeqValue_BaseCases() {
        assertEquals("0", labseqService.getLabSeqValue(0));
        assertEquals("1", labseqService.getLabSeqValue(1));
        assertEquals("0", labseqService.getLabSeqValue(2));
        assertEquals("1", labseqService.getLabSeqValue(3));
    }

    @Test
    void testGetLabSeqValue_Calculations() {
        assertEquals("1", labseqService.getLabSeqValue(4)); 
        assertEquals("1", labseqService.getLabSeqValue(5)); 
        assertEquals("2", labseqService.getLabSeqValue(7));
        assertEquals("3", labseqService.getLabSeqValue(10)); 
    }

    @Test
    void testCalculateLabSeq() {
        assertEquals(BigInteger.ZERO, labseqService.calculateLabSeq(0));
        assertEquals(BigInteger.ONE, labseqService.calculateLabSeq(1));
        assertEquals(BigInteger.ZERO, labseqService.calculateLabSeq(2));
        assertEquals(BigInteger.ONE, labseqService.calculateLabSeq(3));
        assertEquals(BigInteger.ONE, labseqService.calculateLabSeq(4));
        assertEquals(BigInteger.ONE, labseqService.calculateLabSeq(5));
        assertEquals(BigInteger.valueOf(2), labseqService.calculateLabSeq(7));
        assertEquals(BigInteger.valueOf(3), labseqService.calculateLabSeq(10));
    }


}
