from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/crm")
    driver.maximize_window()
    wait = WebDriverWait(driver, 10)

    user_name_input = driver.find_element(By.ID, "user_name")
    password_input = driver.find_element(By.ID, "username_password")
    login_button = driver.find_element(By.ID, "bigbutton")
    user_name_input.send_keys("admin")
    password_input.send_keys("pa$$w0rd")
    login_button.click()
    time.sleep(5)
    actions_button_home_page = driver.find_element(By.ID, "tab-actions")
    wait.until(EC.visibility_of(actions_button_home_page))

    activities_menu = driver.find_element(By.XPATH, "//a[text() = 'Activities']")

    wait.until(EC.element_to_be_clickable(activities_menu))
    assert True == activities_menu.is_displayed()

    if activities_menu.is_displayed() and activities_menu.is_enabled():
    	print("Activities menu exists and is clickable")