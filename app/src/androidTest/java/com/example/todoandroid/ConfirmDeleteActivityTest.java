package com.example.todoandroid;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ConfirmDeleteActivityTest {

    @Rule
    public ActivityScenarioRule<ConfirmDeleteActivity> confirmDeleteActivityTestRule
            = new ActivityScenarioRule<ConfirmDeleteActivity>(ConfirmDeleteActivity.class);



    @Test
    public void TestAreYouSureTextDisplayed(){

        onView(ViewMatchers.withId(R.id.textView))
                .check(matches((ViewMatchers.isDisplayed())));
    }

    @Test
    public void TestYesButtonDisplayed() {

        onView(ViewMatchers.withId(R.id.yesButton))
                .check(matches((ViewMatchers.isDisplayed())));

    }

}

