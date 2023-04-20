package com.example.todoandroid;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;
import static androidx.test.espresso.intent.Intents.intended;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class SignUpActivityTest {

    @Rule
    public ActivityScenarioRule<SigunupActivity> signupActivityTestRule
            = new ActivityScenarioRule<SigunupActivity>(SigunupActivity.class);


    @Test
    public void TestSignUpEmailInputDisplayed(){

        onView(ViewMatchers.withId(R.id.emailCreate))
                .check(matches((ViewMatchers.isDisplayed())));
    }

    @Test
    public void TestSignUpUsernameInputDisplayed() {

        onView(ViewMatchers.withId(R.id.usernameCreate))
                .check(matches((ViewMatchers.isDisplayed())));

    }

    @Test
    public void TestSignUpButtonDisplayed() {

        onView(ViewMatchers.withId(R.id.signInButton))
                .check(matches((ViewMatchers.isDisplayed())));
    }

    @Test
    public void TestSignUpPaswordInputDisplayed() {

        onView(ViewMatchers.withId(R.id.passwordCreate))
                .check(matches((ViewMatchers.isDisplayed())));
    }


    }

