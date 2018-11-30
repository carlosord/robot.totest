*** Settings ***
Documentation     Suite to test "People Management List" from the application "robotframework-test" deployed at https://robotframework-test.herokuapp.com
Library           SeleniumLibrary    # Library to user Selenium Keywords

*** Variables ***
${WEB}            localhost:8090    # Web to test with robot https://robotframework-test.herokuapp.com
${SELENIUM_DELAY}    0.2    # Selenium Speed
${BROWSER}        Chrome    # Browser to do the test

*** Test Cases ***
Login at app
    [Documentation]    Test login from app
    [Setup]    Open Browser At Index
    Go To Page People Management List
    Login With User    user-A    user-A
    Submit Form    login-form
    Wait Until Page Contains Element    people-list
    [Teardown]    Close Browser

Create New Person
    [Documentation]    Test create action from app
    [Setup]    Open Browser At Index
    Go To Page People Management List
    Login With User    user-A    user-A
    Submit Form    login-form
    Click On Create A Person
    Fill Form With Sample Data And Submit
    Check If Table Contains The New Person
    [Teardown]    Close Browser

Delete Existing Person
    [Setup]    Open Browser At Index
    Go To Page People Management List
    Login With User    user-A    user-A
    Submit Form    login-form
    Delete User 10
    Click OK In Confirm Window

Edit Existing Person
    [Setup]    Open Browser At Index
    Go To Page People Management List
    Login With User    user-A    user-A
    Submit Form    login-form
    Click On Edit Button From User10
    Fill Form With New Data And Submit
    Check If Table Contains The New Person
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

Click On Create A Person
    Click Link    /new

Fill Form With Sample Data And Submit
    Input Text    dni    10101010A
    Input Text    name    user10
    Input Text    lastname    user10
    Input Text    age    30
    Select From List By Index    gender    1
    Select Checkbox    hascar
    Submit Form    person-form

Check If Table Contains The New Person
    Wait Until Page Contains    10101010A

Delete User 10
    Click Link    //*[@id="people-list"]/tbody/tr[10]/td[7]/a

Click OK In Confirm Window
    Click Button    body > div.jconfirm.jconfirm-supervan.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-buttons > button:nth-child(1)

Check If Table Contains The Updated Person
    Wait Until Page Contains    user11

Click On Edit Button From User10
    Click Link    /edit/10101010A

Fill Form With New Data And Submit
    Input Text    name    user11
    Input Text    lastname    user11
    Select From List By Index    gender    0
    Unselect Checkbox    hascar
    Submit Form    person-form
