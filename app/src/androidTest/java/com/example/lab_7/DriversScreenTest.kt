package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testDriversScreenFlow() {
        // Navigate to Drivers Screen
        composeTestRule.onNodeWithTag("driversButton").performClick()

        // Verify we are on Drivers Screen
        composeTestRule.onNodeWithText("FormulaZero Drivers").assertExists()

        // Add a driver
        val driverName = "Max Verstappen"
        composeTestRule.onNodeWithTag("driverNameInput").performTextInput(driverName)
        composeTestRule.onNodeWithTag("addDriverButton").performClick()

        // Verify driver is displayed
        composeTestRule.onNodeWithText(driverName).assertExists()

        // Clear drivers
        composeTestRule.onNodeWithTag("clearDriversButton").performClick()

        // Verify driver is no longer displayed
        composeTestRule.onNodeWithText(driverName).assertDoesNotExist()

        // Go back to Home Screen
        composeTestRule.onNodeWithTag("backButton").performClick()

        // Verify we are back on Home Screen
        composeTestRule.onNodeWithText("FormulaZero Home").assertExists()
    }
}
