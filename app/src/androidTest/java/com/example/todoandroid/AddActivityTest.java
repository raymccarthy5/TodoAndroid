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
public class AddActivityTest {

    @Rule
    public ActivityScenarioRule<AddActivity> addActivityTestRule
            = new ActivityScenarioRule<AddActivity>(AddActivity.class);


    @Test
    public void TestTitleInputDisplayed(){

        onView(ViewMatchers.withId(R.id.title))
                .check(matches((ViewMatchers.isDisplayed())));
    }

    @Test
    public void TestDescriptionInputDisplayed() {

        onView(ViewMatchers.withId(R.id.description))
                .check(matches((ViewMatchers.isDisplayed())));

    }

    @Test
    public void TestDueDateInputDisplayed() {

        onView(ViewMatchers.withId(R.id.dueDate))
                .check(matches((ViewMatchers.isDisplayed())));
    }
    @Test
    public void TestAddButtonDisplayed() {

        onView(ViewMatchers.withId(R.id.checkButtonAdd))
                .check(matches((ViewMatchers.isDisplayed())));
    }
}
