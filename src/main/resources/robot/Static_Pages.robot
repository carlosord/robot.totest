*** Settings ***
Documentation     Suite to test "Static Pages" from the application "robotframework-test" deployed at https://robotframework-test.herokuapp.com
Library           SeleniumLibrary    # Library to user Selenium Keywords

*** Variables ***
${WEB}            https://robotframework-test.herokuapp.com    # Web to test with robot https://robotframework-test.herokuapp.com
${SELENIUM_DELAY}    0.2    # Selenium Speed
${BROWSER}        Chrome    # Browser to do the test

*** Test Cases ***
Play Video
    [Setup]    Open Browser At Index
    Go To Video Page
    Select Frame    //iframe[@src="https://www.youtube.com/embed/8h5knh2jLCA"]
    Click Button    //button[@aria-label="Play"]
    Sleep    10s
    [Teardown]    Close Browser

Test Delay Page
    [Setup]    Open Browser At Index
    Go To Delay Page
    Click On Modal Button
    Insert Date In Modal Window    04122018
    Click On Button To Show Date
    Wait Until Page Contains    2018-04-12
    [Teardown]    Close Browser

*** Keywords ***
Open Browser At Index
    ${chrome_options}=    Evaluate    sys.modules['selenium.webdriver'].ChromeOptions()    sys
    Call Method    ${chrome_options}    add_argument    --disable-notifications
    Create Webdriver    ${BROWSER}    chrome_options=${chrome_options}
    Go To    ${WEB}
    Set Selenium Speed    ${SELENIUM_DELAY}
    Maximize Browser Window    # Funciona cuando el navegador no esta en modo headless

Go To Video Page
    Click Link    /video

Go To Delay Page
    Click Link    /delay

Click On Modal Button
    Click Button    //button[@data-target="#modal"]

Insert Date In Modal Window
    [Arguments]    ${date}
    Press Key    input-date    04122018

Click On Button To Show Date
    Click Button    //button[@onclick="showDate()"]
