from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/crm")
    driver.maximize_window()
    
    copyright_text = driver.find_element(By.ID, "admin_options").text
    print("First copyright text: " +copyright_text)