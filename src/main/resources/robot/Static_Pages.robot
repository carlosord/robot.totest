*** Settings ***
Documentation     Suite to test "Static Pages" from the application "robotframework-test" deployed at https://robotframework-test.herokuapp.com
Library           SeleniumLibrary    # Library to user Selenium Keywords

*** Variables ***
${WEB}            localhost:8090    # Web to test with robot https://robotframework-test.herokuapp.com
${SELENIUM_DELAY}    0.2    # Selenium Speed
${BROWSER}        Chrome    # Browser to do the test

*** Test Cases ***

*** Keywords ***
Open Browser At Index
    ${chrome_options}=    Evaluate    sys.modules['selenium.webdriver'].ChromeOptions()    sys
    Call Method    ${chrome_options}    add_argument    --disable-notifications
    Create Webdriver    ${BROWSER}    chrome_options=${chrome_options}
    Go To    ${WEB}
    Set Selenium Speed    ${SELENIUM_DELAY}
    Maximize Browser Window    # Funciona cuando el navegador no esta en modo headless
