*** Settings ***
Documentation     Suite to test "Static Pages" from the application "robotframework-test" deployed at https://robotframework-test.herokuapp.com
Library           SeleniumLibrary    # Library to user Selenium Keywords

*** Variables ***
${WEB}            https://robotframework-test.herokuapp.com    # Web to test with robot https://robotframework-test.herokuapp.com
${SELENIUM_DELAY}    0.5    # Selenium Speed
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

Test Delay 2 Page
    [Setup]    Open Browser At Index
    Go To Delay 2 Page
    Wait Until Page Contains Element    //button[@data-target="#modal"]    20s
    Click On Modal Button
    Insert Date In Modal Window    04122018
    Click On Button To Show Date
    Wait Until Page Contains    2018-04-12
    [Teardown]    Close Browser

Test Menu Select Option
    [Setup]    Open Browser At Index
    Click Menu Element
    Mouse Over    //*[@id="navbarSupportedContent"]/ul/li[5]/div/ul/li[3]/a
    Mouse Over    //*[@id="navbarSupportedContent"]/ul/li[5]/div/ul/li[3]/ul/li[2]/a
    Click Menu Element Carousel
    Go To Next Image
    Go To Next Image
    Go To Next Image
    Wait Until Page Contains Element    //div[@class="carousel-item active"]/img[@alt="First slide"]
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

Go To Delay 2 Page
    Click Link    //a[@onclick="sleepFunction()"]

Click On Modal Button
    Click Button    //button[@data-target="#modal"]

Insert Date In Modal Window
    [Arguments]    ${date}
    Press Key    input-date    04122018

Click On Button To Show Date
    Click Button    //button[@onclick="showDate()"]

Click Menu Element
    Click Link    //*[@id="navbarDropdown"]

Click Menu Element Carousel
    Click Link    //*[@id="navbarSupportedContent"]/ul/li[5]/div/ul/li[3]/ul/li[2]/ul/li[2]/a

Go To Next Image
    Click Link    //*[@id="carouselExampleControls"]/a[2]
