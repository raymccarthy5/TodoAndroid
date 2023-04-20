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
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> loginActivityTestRule
            = new ActivityScenarioRule<LoginActivity>(LoginActivity.class);


    @Test
    public void TestSignInEmailInputDisplayed(){

        onView(ViewMatchers.withId(R.id.username))
                .check(matches((ViewMatchers.isDisplayed())));
    }

    @Test
    public void TestSigInPasswordInputDisplayed() {

        onView(ViewMatchers.withId(R.id.password))
                .check(matches((ViewMatchers.isDisplayed())));

    }

    @Test
    public void TestSignInButtonDisplayed() {

        onView(ViewMatchers.withId(R.id.signInButton))
                .check(matches((ViewMatchers.isDisplayed())));
    }

}
