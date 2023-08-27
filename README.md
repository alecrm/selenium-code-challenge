# Selenium Code Challenge

### Assumptions:
- The application works as intended (there are currently no bugs)
- Test users are created in the system. Ideally user generation would be a part of testing,
but for this I will pre-create any necessary users and work with those

### Planning:

Note: It has been suggested to not take much more than 2 hours, so I plan to shoot for that.

- Set up driver instantiation and website access
- Create test for the following functionality:
  - Login
  - User creation
  - Posting
  - Liking
  - Commenting

---

### Results:
Okay, so it took a little longer than 2 hrs :) In the 2 hrs, I believe I got the foundation of actually running tests
(including driver management, etc.) set up, as well as the login test and /possibly/ the user creation test.
I know the initial interview said anywhere between 2-4 hours, so I was happy to work through a little more just to
display more of how I actually write things out. I think I spanned a fairly decent very high level spread of how I
write tests and set up the page object model classes. I simplified and reduced plenty of things for the sake of time
(cut down on logging, few comments, no separate spot for common properties), but I wanted to get the meat of the actual test writing done.
Overall, it took about 5 hrs to finish what I initially set out to do,  which tracks with how real development
frequently goes, I suppose, lol.

### Pain Points:
- Had a fun time working through some chromedriver issues between my chrome instance and the driver. Naturally,
this would be the time for a background Chrome update putting my driver out of date :)
  - Of course, that then resulted in fighting with my computer to actually run the new chromedriver
- Evidently it's been long enough since I set up a test environment from scratch that I was spacing out on setting up
the TestNG test xml...took a while to realize I was just missing the <classes> tag lol.
- It was a refreshing experience to remember how much I lean on the existing utils we have set up in my current
framework and how rudimentary Selenium can feel without them! But good to work through the basics again.