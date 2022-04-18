package com.example.blackoutboard;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class HardTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void hardandeasyTest() {
        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.HardButton), withText("Hard"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                2),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button), withText("Start Game"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.rollButton), withText("ROLL"),
                        withParent(allOf(withId(R.id.constraintLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        try {
            do {
                button.perform(click());
            } while (true);
        } catch (Exception e) {
            ViewInteraction materialButton9 = onView(
                    allOf(withId(R.id.resetButton), withText("Start Over"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    2),
                            isDisplayed()));
            materialButton9.perform(click());


            ViewInteraction materialButton1= onView(
                    allOf(withId(R.id.button), withText("Start Game"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    1),
                            isDisplayed()));
            materialButton1.perform(click());

            ViewInteraction button1= onView(
                    allOf(withId(R.id.rollButton), withText("ROLL"),
                            withParent(allOf(withId(R.id.constraintLayout),
                                    withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                            isDisplayed()));
            try {
                do {
                    button1.perform(click());
                } while (true);
            } catch (Exception ex) {
                ViewInteraction materialButton91 = onView(
                        allOf(withId(R.id.resetButton), withText("Start Over"),
                                childAtPosition(
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0),
                                        2),
                                isDisplayed()));
                materialButton91.perform(click());


                ViewInteraction materialButton2 = onView(
                        allOf(withId(R.id.button), withText("Start Game"),
                                childAtPosition(
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0),
                                        1),
                                isDisplayed()));
                materialButton2.perform(click());

                ViewInteraction button2 = onView(
                        allOf(withId(R.id.rollButton), withText("ROLL"),
                                withParent(allOf(withId(R.id.constraintLayout),
                                        withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                                isDisplayed()));
                try {
                    do {
                        button2.perform(click());
                    } while (true);
                } catch (Exception exc) {
                    ViewInteraction materialButton3 = onView(
                            allOf(withId(R.id.resetButton), withText("Start Over"),
                                    childAtPosition(
                                            childAtPosition(
                                                    withId(android.R.id.content),
                                                    0),
                                            2),
                                    isDisplayed()));
                    materialButton3.perform(click());


                }
            }

        }

    }

    @Test
    public void mediumTestWith99() {
        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.MedButton), withText("Medium"),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.playertext),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        textInputEditText.perform(replaceText("9"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.playertext), withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        textInputEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button), withText("Start Game"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.rollButton), withText("ROLL"),
                        withParent(allOf(withId(R.id.constraintLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        try {
            do {
                button2.perform(click());
            } while (true);
        } catch (Exception exc) {
            ViewInteraction materialButton3 = onView(
                    allOf(withId(R.id.resetButton), withText("Start Over"),
                            isDisplayed()));
            materialButton3.perform(click());

            ViewInteraction materialRadioButton2 = onView(
                    allOf(withId(R.id.EasyButton), withText("Easy"),
                            isDisplayed()));
            materialRadioButton2.perform(click());

            ViewInteraction textInputEditText3 = onView(
                    allOf(withId(R.id.playertext),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    2),
                            isDisplayed()));
            textInputEditText3.perform(replaceText("4"), closeSoftKeyboard());

            ViewInteraction textInputEditText4 = onView(
                    allOf(withId(R.id.playertext), withText("4"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    2),
                            isDisplayed()));
            textInputEditText4.perform(pressImeActionButton());

            ViewInteraction materialButton2 = onView(
                    allOf(withId(R.id.button), withText("Start Game"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    1),
                            isDisplayed()));
            materialButton2.perform(click());

            ViewInteraction button4 = onView(
                    allOf(withId(R.id.rollButton), withText("ROLL"),
                            withParent(allOf(withId(R.id.constraintLayout),
                                    withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                            isDisplayed()));
            try {
                do {
                    button4.perform(click());
                } while (true);
            } catch (Exception exce) {
                ViewInteraction materialButton4 = onView(
                        allOf(withId(R.id.resetButton), withText("Start Over"),
                                isDisplayed()));
                materialButton4.perform(click());
            }

        }


    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
