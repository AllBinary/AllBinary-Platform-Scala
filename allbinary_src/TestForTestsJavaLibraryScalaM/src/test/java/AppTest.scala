/* Generated Code Do Not Modify */

import _root_.org.junit.jupiter.api.Assertions
import _root_.org.junit.jupiter.api.DisplayName
import _root_.org.junit.jupiter.api.Test

class AppTest {

    @Test
    @DisplayName("Simple test to verify that 1 + 1 equals 2")
    def testAddition() : Unit = {
        // Assertion to check if the result of 1 + 1 is equal to 2
        Assertions.assertEquals(2, 1 + 1)
    }

    @Test
    @DisplayName("Test string equality")
    def testStringEquality() : Unit = {
        var expected : String = "Hello World!"
        var actual : String = "Hello World!"
        // Assertion to check if two strings are equal
        Assertions.assertEquals(expected, actual)
    }

    @Test
    @DisplayName("Test boolean assertions")
    def testBooleanAssertions() : Unit = {
        // Assertion to check if a condition is true
        Assertions.assertTrue(true)
        // Assertion to check if a condition is false
        Assertions.assertFalse(false)
    }

}


