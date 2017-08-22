package net.klakegg.commons.builder;

import net.klakegg.commons.builder.impl.SampleObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author erlend
 */
public class SimpleTest {

    @Test
    public void verifyDefaultValues() {
        SampleObject sampleObject = SampleObject.builder()
                .build();

        Assert.assertTrue(sampleObject.get(SampleObject.BOOLEAN_PROPERTY));
        Assert.assertNull(sampleObject.get(SampleObject.STRING_PROPERTY));
        Assert.assertEquals(sampleObject.get(SampleObject.STRINGS_PROPERTY), Arrays.asList("Test", "123"));
    }

    @Test
    public void verifyOverrideOfDefaultValues() {
        SampleObject sampleObject = SampleObject.builder()
                .set(SampleObject.BOOLEAN_PROPERTY, false)
                .set(SampleObject.STRING_PROPERTY, "Dinner")
                .set(SampleObject.STRINGS_PROPERTY, "An")
                .build();

        Assert.assertFalse(sampleObject.get(SampleObject.BOOLEAN_PROPERTY));
        Assert.assertEquals(sampleObject.get(SampleObject.STRING_PROPERTY), "Dinner");
        Assert.assertEquals(sampleObject.get(SampleObject.STRINGS_PROPERTY), Collections.singletonList("An"));
    }
}
