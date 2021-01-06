package com.example.FinalProjectJava.controller;

import com.example.FinalProjectJava.controller.FinalProjectJavaController;
import com.example.FinalProjectJava.service.FinalProjectJavaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Timestamp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FinalProjectJavaTest {
    @Mock
    private FinalProjectJavaService mockFinalProjectJavaService;

    @InjectMocks
    private FinalProjectJavaController finalProjectJavaController;

    @Test
    public void getTime_CallServerReturnOutcome()
    {
        when(mockFinalProjectJavaService.getTime()).thenReturn(Timestamp.valueOf("2021-01-06 03:49:26.619650"));
        Timestamp actual = finalProjectJavaController.getTime();
        verify(mockFinalProjectJavaService).getTime();
        Timestamp expected = Timestamp.valueOf("2021-01-06 03:49:26.619650");
        assertThat(actual).isEqualTo(expected);
    }
}

//2021-05-01 06:31:50.23510000