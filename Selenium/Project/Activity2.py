from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/crm")
    driver.maximize_window()
    
    url = driver.find_element(By.XPATH, "//div[@class = 'companylogo']//img").get_dom_attribute("src")
    print(f"URL of the header image: {url}")