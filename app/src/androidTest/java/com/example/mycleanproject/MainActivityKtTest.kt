package com.example.mycleanproject

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mycleanproject.presentation.ui.theme.MyCleanProjectTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityKtTest {


    @get: Rule
    val composeTestRule = createComposeRule()   // compose rule is required to get access to the composable component
    @Before
    fun setUp() {
        composeTestRule.setContent {    // setting our composable as content for test
            MyCleanProjectTheme {
            }
        }
    }
    @Test
    fun verify_if_all_views_exists() {
        composeTestRule.onNodeWithTag("Counter Display").assertExists()
        composeTestRule.onNodeWithTag("Input").assertExists()
        composeTestRule.onNodeWithText("Copy").performClick()
        composeTestRule.onNodeWithText("Copy").performClick()
    }
    @Test
    fun counterValue_with_emptyInput_displays_InvalidEntry() {
        composeTestRule.onNodeWithText("Copy").performClick()

        composeTestRule.onNodeWithTag("Counter Display").assertTextEquals("Invalid entry")
    }
    @Test
    fun withInput_as_1_onButtonClick_displayOnTop() {
        // mimic the user inputting the text
        composeTestRule.onNodeWithTag("Input").performTextInput("1")
        // mimic if the user clicked on the button
        composeTestRule.onNodeWithText("Copy").performClick()
        // mimic if the user is shown the desired text on UI
        composeTestRule.onNodeWithTag("Counter Display").assertTextContains("Counter = 1")
    }
}