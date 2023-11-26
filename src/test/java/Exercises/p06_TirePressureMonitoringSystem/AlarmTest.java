package Exercises.p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Target;

import static org.junit.Assert.*;

public class AlarmTest {
    private static final double LOW_PRESSURE = 14.0;
    private static final double HIGH_PRESSURE = 22.0;
    private static final double NORMAL_PRESSURE = 20.0;

    private Alarm alarm;
    private Sensor fakeSensor;
    @Before
    public void setAlarm() {
       fakeSensor  = Mockito.mock(Sensor.class);
       this.alarm = new Alarm(fakeSensor);
    }
    @Test
    public void checking_If_Alarm_On_Low_Pressure() {
        Mockito.when(fakeSensor.popNextPressurePsiValue()).thenReturn(14.0);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void checking_If_Alarm_On_High_Pressure() {
        Mockito.when(fakeSensor.popNextPressurePsiValue()).thenReturn(22.0);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void checking_If_Alarm_Off() {
        Mockito.when(fakeSensor.popNextPressurePsiValue()).thenReturn(20.0);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}