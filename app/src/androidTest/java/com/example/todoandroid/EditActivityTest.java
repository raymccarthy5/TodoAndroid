package com.example.todoandroid;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class EditActivityTest {


    @Rule
    public ActivityScenarioRule<EditActivity> editActivityTestRule
            = new ActivityScenarioRule<EditActivity>(EditActivity.class);


    @Test
    public void TestEditTitleInputDisplayed(){

        onView(ViewMatchers.withId(R.id.titleEdit))
                .check(matches((ViewMatchers.isDisplayed())));
    }

    @Test
    public void TestEditDescriptionDisplayed() {

        onView(ViewMatchers.withId(R.id.descriptionEdit))
                .check(matches((ViewMatchers.isDisplayed())));

    }

    @Test
    public void TestEditDueDateDisplayed() {

        onView(ViewMatchers.withId(R.id.dueDateEdit))
                .check(matches((ViewMatchers.isDisplayed())));
    }
    @Test
    public void TestEditButtonDisplayed() {

        onView(ViewMatchers.withId(R.id.checkButtonEdit))
                .check(matches((ViewMatchers.isDisplayed())));
    }
}
