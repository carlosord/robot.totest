*** Settings ***
Documentation     Suite to test "People Management List" from the application "robotframework-test" deployed at https://robotframework-test.herokuapp.com
Library           SeleniumLibrary    # Library to user Selenium Keywords

*** Variables ***
${WEB}            https://robotframework-test.herokuapp.com    # Web to test with robot
${SELENIUM_DELAY}    0.2    # Selenium Speed
${BROWSER}        Chrome    # Browser to do the test

*** Test Cases ***
Login at app
    [Documentation]    Test login from app
    [Setup]    Open Browser At Index
    Go To Page People Management List
    Login With User    user-1    user-1
    Submit Form    login-form
    [Teardown]    Close Browser

*** Keywords ***
Open Browser At Index
    ${chrome_options}=    Evaluate    sys.modules['selenium.webdriver'].ChromeOptions()    sys
    Call Method    ${chrome_options}    add_argument    --disable-notifications
    Create Webdriver    ${BROWSER}    chrome_options=${chrome_options}
    Go To    ${WEB}
    Set Selenium Speed    ${SELENIUM_DELAY}
    Maximize Browser Window    # Funciona cuando el navegador no esta en modo headless

Go To Page People Management List
    Click Link    /list

Login With User
    [Arguments]    ${name}    ${password}
    Input Text    username    ${name}
    Input Password    password    ${password}
