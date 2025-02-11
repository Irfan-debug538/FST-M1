from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/crm")
    driver.maximize_window()
    
    title = driver.title
    print(f"Title of the web page: {title}")
    assert title == 'SuiteCRM'