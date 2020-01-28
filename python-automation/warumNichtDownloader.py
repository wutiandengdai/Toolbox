import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import ElementClickInterceptedException as ECIE
from selenium.common.exceptions import TimeoutException as TE


with webdriver.Chrome() as driver:
    driver.get('https://www.dw.com/en/learn-german/deutsch-warum-nicht-series-1/s-2549')
    driver.maximize_window()

    # Setup wait for later
    wait = WebDriverWait(driver, 100)

    #Accept Cookie
    try:
        cookieButton = wait.until(EC.element_to_be_clickable((By.XPATH, '//a[@class="cookie__btn cookie__btn--ok"]')))
        cookieButton.click()
    except TE:
        print("Locating cookie time out")

    #Obtain links
    linkNodes = driver.find_elements_by_partial_link_text('Chapter')
    #linkNodes = driver.find_elements_by_xpath('//div[@class="linkList intern"]/a')
    links = []
    for node in linkNodes:
        links.append(node.get_attribute('href'))

    print(len(links))
    for link in links:
        try:
            driver.get(link)

            #Click the further audio link after jumped to the page
            audiolink = wait.until(EC.element_to_be_clickable((By.XPATH, '//a[@class="overlayLink init"]')))
            print(audiolink.get_attribute('href'))
            audiolink.click()

            #Click the "Save MP3 file" link after further jumped
            mp3link = wait.until(EC.element_to_be_clickable((By.LINK_TEXT, 'Save MP3 file')))
            print(mp3link.get_attribute('href'))
            mp3link.click()
            #Wait for the Download starts
            time.sleep(60)
        except ECIE:
            print("Interrupted")
            continue
